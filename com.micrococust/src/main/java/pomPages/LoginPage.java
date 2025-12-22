package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    By email = By.xpath("//input[@placeholder='Email']");
    By password = By.name("password");
    By loginBtn = By.xpath("//div[text()='Sign In']");

    public void login(String user, String pass) {
        driver.findElement(email).sendKeys("devops5@aaa2innovate.com");
        driver.findElement(password).sendKeys("@cupcake3#");
        driver.findElement(loginBtn).click();
    }
}
