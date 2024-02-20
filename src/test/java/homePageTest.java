import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;






public class homePageTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        WebElement username=driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        WebElement password=driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");
        WebElement loginButton=driver.findElement(By.className("login-button"));
        loginButton.submit();
    }
    @Test
    public void playButtonTest(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement playButtonE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
        playButtonE1.isDisplayed();
    }
    @Test
    public void contactUsTest(){
        WebElement contactUs=driver.findElement(By.xpath("//p[starts-with(@class, 'contact')]"));
        String actualContent = contactUs.getText();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}


