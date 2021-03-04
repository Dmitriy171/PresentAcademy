import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners(ScreenShooter.class)
public class ConditionsTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteMethod() {
//        WebDriverManager.chromedriver().version("80").setup();
        Configuration.timeout = 10000;
        Configuration.baseUrl = "http://automationpractice.com/";
        Configuration.startMaximized = true;
        Configuration.headless = false;

    }
}