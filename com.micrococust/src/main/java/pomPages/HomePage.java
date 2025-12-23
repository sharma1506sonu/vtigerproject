package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginHeader = By.xpath("//a[text()='Login']");
    By customerLogin = By.xpath("//button[contains(@class,'dropdown-item') and normalize-space()='Customer Login']");

    public void openLoginPopup() throws InterruptedException {
        driver.findElement(loginHeader).click();
     
        driver.findElement(customerLogin).click();
    }
}
