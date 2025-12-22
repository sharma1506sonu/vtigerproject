package pomPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatesQueryPreviewPage {

    WebDriver driver;

    public RatesQueryPreviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By rateCards = By.cssSelector(".rate-card");
    By currencyDropdown = By.id("currency");
    By bookNowBtn = By.xpath("//button[contains(text(),'Book')]");

    public boolean isRatesDisplayed() {
        return driver.findElements(rateCards).size() > 0;
    }

    public void changeCurrency(String currency) {
        driver.findElement(currencyDropdown).sendKeys(currency);
    }

    public void clickBookNow() {
        driver.findElement(bookNowBtn).click();
    }
}
