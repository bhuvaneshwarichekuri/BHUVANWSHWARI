import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class accountsPage {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        WebElement username = driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        WebElement password = driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.submit();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void accoutsTest(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement accountpageE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        accountpageE1.click();
        WebElement logoutButton=driver.findElement(By.className("logout-button"));
        logoutButton.click();
    }
}

