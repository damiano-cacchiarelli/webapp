import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyWebsiteTest {
    private WebDriver driver;

    @BeforeEach
    void startConfiguration(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    void checkProsSite() throws InterruptedException {

        driver.get("http://localhost:8080/maven-webapp/");

        Thread.sleep(3000);

        String at = driver.getTitle();
        String et = "SPM 2022";

        Thread.sleep(4000);

        Assertions.assertEquals(et, at);
    }

    @AfterEach
    void endConfiguration(){
        driver.close();
        driver.quit();
    }
}
