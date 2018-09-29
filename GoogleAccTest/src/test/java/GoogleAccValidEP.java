import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class GoogleAccValidEP {
    private WebDriver driver;
    @Before
    public void testSetUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void testTearDown(){
        driver.close();
    }
    @Test
    public void checkValidEmailValidPassword() {
        driver.get("https://accounts.google.com");
        driver.findElement(By.id("identifierId")).sendKeys("swdjunittest@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.cssSelector("div#password input")).sendKeys("Swd_jUnit_Test");
        driver.findElement(By.id("passwordNext")).click();
        driver.getPageSource().contains("Добро пожаловать, Test Test!");
        driver.findElement(By.cssSelector("a[href*='SignOut']")).click();
        driver.findElement(By.linkText("Выйти")).click();




    }

}

