import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class headerSectionTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        WebElement username=driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        WebElement password=driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");
        WebElement loginButton=driver.findElement(By.className("login-button"));
        loginButton.submit();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void navBarElementlogoDisplayed (){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement logoNavBarE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        logoNavBarE1.isDisplayed();
    }
    @Test
    public void navBarElementHomeDisplayed (){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement homeNavBarE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
        homeNavBarE1.isDisplayed();
    }
    @Test
    public void navBarElementpopularDisplayed (){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement popularNavBarE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        popularNavBarE1.isDisplayed();
    }
    @Test
    public void navBarElementSearchButtonDisplayed (){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement searchNavBarE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-empty-button")));
        searchNavBarE1.isDisplayed();
    }
    @Test
    public void navBarElementprofileDisplayed (){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement profileNavBarE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        profileNavBarE1.isDisplayed();
    }


}
