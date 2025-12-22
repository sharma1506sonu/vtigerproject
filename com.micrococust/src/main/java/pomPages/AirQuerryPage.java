package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AirQuerryPage {

    WebDriver driver;

    public AirQuerryPage(WebDriver driver) {
        this.driver = driver;
    }

    By origin = By.id("origin");
    By destination = By.id("destination");
    By weight = By.id("weight");
    By pieces = By.id("pieces");
    By shipmentDate = By.id("shipmentDate");
    By commodity = By.id("commodity");
    By submitBtn = By.xpath("//button[contains(text(),'Submit')]");

    public void submitAirQuery(String org, String dest, String wt,
                               String pcs, String date, String comm) {

        driver.findElement(origin).sendKeys(org);
        driver.findElement(destination).sendKeys(dest);
        driver.findElement(weight).sendKeys(wt);
        driver.findElement(pieces).sendKeys(pcs);
        driver.findElement(shipmentDate).sendKeys(date);
        driver.findElement(commodity).sendKeys(comm);
        driver.findElement(submitBtn).click();
    }
}
