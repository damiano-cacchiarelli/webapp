
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;

public class SeleniumTest {

    private WebDriver driver;


    @BeforeEach
    @Tag("AcceptanceTest")
    void startConfiguration(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    @Tag("AcceptanceTest")
    void checkProsSite() throws InterruptedException {

        driver.get("http://pros.unicam.it/");

        Thread.sleep(3000);

        String at = driver.getTitle();
        String et = "PROS - PROcesses & Services lab | Computer Science division @Unicam";

        Thread.sleep(4000);

        Assertions.assertEquals(et, at);
    }

    @Test
    @Tag("AcceptanceTest")
    void checkProsSiteSearch() throws InterruptedException {

        driver.get("https://pros.unicam.it/");
        Thread.sleep(4000);

        //Find Element by className
        driver.findElement(By.className("toggle-search")).click();
        Thread.sleep(1000);

        driver.findElement(By.className("search")).click();
        Thread.sleep(1000);

        driver.findElement(By.className("search")).sendKeys("bprove");
        Thread.sleep(2000);

        driver.findElement(By.className("search")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.findElements(By.className("type-portfolio-title")).forEach(e -> {
            String text = e.findElement(By.tagName("a")).getText();
            text = text.toLowerCase();
            //System.out.println(text);
            //Assertions.assertTrue(text.contains("bprove"));

        });
    }

    @AfterEach
    @Tag("AcceptanceTest")
    void endConfiguration(){
        driver.close();
        driver.quit();
    }

}
