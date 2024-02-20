import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class moviesDetailsPage {
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
    public void searchTest(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement HomepageE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("Home")));
        HomepageE1.click();
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='home-bottom-container']"));
        System.out.println(searchResult.size() + " Results Found");
        WebElement PopularpageE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("Popular")));
        PopularpageE1.click();
    }
}
