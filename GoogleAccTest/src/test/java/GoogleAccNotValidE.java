import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleAccNotValidE {
    private WebDriver driver;

    @Before
    public void testSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void testTearDown() {
        driver.close();
    }

    @Test
    public void checkNotValidEmail() {
        driver.get("https://accounts.google.com");
        driver.findElement(By.id("identifierId")).sendKeys("swd_junit_test@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.getPageSource().contains("Не удалось найти аккаунт Google");




    }

}
