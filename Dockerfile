# Stage 1: Build the Java application
# Use a JDK image that includes Maven and the full Java Development Kit
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and download dependencies (leveraging Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Build the project, creating the runnable JAR/test target
# The '-DskipTests' is often used to quickly build the package, then tests are run in the final image
RUN mvn package -DskipTests

# ---
# Stage 2: Create the final, lean test execution image
# Use a minimal JRE image for running the tests (smaller and more secure)
FROM eclipse-temurin:21-jre-alpine

# Set environment variable for the web driver (e.g., ChromeDriver)
# This assumes you have the browser/driver installed on the base image or add it in a preceding step
# Note: For full headful browser execution, you often need a much larger image (like one with Xvfb)
ENV PATH="/usr/bin:${PATH}"

# Set the working directory
WORKDIR /app

# Copy the built JAR/test artifact from the 'build' stage
# Adjust 'your-project-name-1.0-SNAPSHOT.jar' to match the output of your 'mvn package'
# For Cucumber/Selenium, you usually copy the compiled classes and dependencies
COPY --from=build /app/target/classes /app/classes
COPY --from=build /app/target/test-classes /app/test-classes
COPY --from=build /root/.m2/repository /root/.m2/repository

# Copy any necessary configuration files (e.g., Log4j config, test properties)
COPY src/test/resources /app/resources

# Define the default command to run your Cucumber tests
# The full command will depend on your test runner setup (e.g., JUnit, TestNG)
# This example uses Maven to run the tests
CMD ["java", "-cp", "./classes:./test-classes:$(find /root/.m2/repository -name '*.jar' | tr '\n' ':')", "org.testng.TestRunner", "com.yourpackage.TestRunnerClass"]
# Note: The above CMD is complex. A simpler, robust approach is often to use the 'maven' image and run 'mvn test'