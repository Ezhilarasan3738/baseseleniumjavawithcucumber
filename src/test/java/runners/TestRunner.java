package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/FTK/USRMR2025/2502/google.feature",
		glue = {"ftkstepdefinition"},
		tags = "@current",
		plugin = {"pretty", "html:target/cucumber-reports/html-report.html", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner {
}