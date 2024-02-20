import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;

public class loginPageTest{
    @Test(priority=1)
    public void TestingLoginPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        WebElement logoDisplayed=driver.findElement(By.className("login-website-logo"));
        logoDisplayed.isDisplayed();

        String expectedHomeHeading = "Login";
        WebElement actualHomeHeadingEl = driver.findElement(By.className("sign-in-heading"));
        String actualHomeHeading = actualHomeHeadingEl.getText();
        Assert.assertEquals(expectedHomeHeading, actualHomeHeading, "login page matched");

        WebElement buttonElement=driver.findElement(By.className("login-button"));
        buttonElement.isDisplayed();

        driver.quit();

    }
    @Test(priority=2)
    public void inputFieldsEmpty(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
    }
    @Test(priority=3)
    public void emptyUsername(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        WebElement usernameInputField=driver.findElement(By.id("passwordInput"));
        usernameInputField.sendKeys("rahul@2021");
        WebElement submitButton = driver.findElement(By.className("login-button"));
        submitButton.click();
    }
    @Test(priority=4)
    public void emptyPassword() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        WebElement passwordInputField=driver.findElement(By.id("usernameInput"));
        passwordInputField.sendKeys("rahul");
        WebElement submitButton = driver.findElement(By.className("login-button"));
        submitButton.click();
    }
    @Test(priority = 5)
    public void loginInvalidCredentials() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        //navigate to url moviespage
        driver.get("https://qamoviesapp.ccbp.tech");

        //username input
        WebElement username=driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        //password input
        //username input
        WebElement password=driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2023");
        //login
        WebElement loginButton=driver.findElement(By.className("login-button"));
        loginButton.submit();
        //wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        //message
        WebElement errorMessage = driver.findElement(By.className("error-message"));
        String errorMessageE1 = errorMessage.getText();
        Assert.assertEquals(errorMessageE1, "*username and password didn't match");
        //quit
        driver.quit();
    }
    @Test(priority = 6)
    public void loginWithInvalidCredentials() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver.exe");

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        //navigate to url moviespage
        driver.get("https://qamoviesapp.ccbp.tech");

        //username input
        WebElement username=driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        //password input
        //username input
        WebElement password=driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");
        //login
        WebElement loginButton=driver.findElement(By.className("login-button"));
        loginButton.submit();
        // Declare expected URL
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        //wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        //assert
        Assert.assertEquals(expectedUrl, currentUrl, "URL matched");
        //quit
        driver.quit();
    }

}
