package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.webdriver.WebDriverUtility;

public class AirQuerryPage {

    private WebDriver driver;

    public AirQuerryPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy (xpath="//button[text()='Next Step']")
    private WebElement nextBtn;
    
     @FindBy (xpath="//div[@class=' css-hlgwow']")
      private WebElement inputDropdown;
     
     @FindBy (id="destination")
    private WebElement destination;
    
     @FindBy (id="weight")
     private WebElement weight;
     
     @FindBy (id="pieces")
     private WebElement pieces;
     
     @FindBy (id="shipmentDate")
     private WebElement shipmentDate;
     
     @FindBy (id="commodity")
    private WebElement commodity;
    
     @FindBy (xpath="//button[contains(text(),'Submit')]")
    private WebElement submitBtn ;
   
   
    public WebElement clickNext() {
       return nextBtn;
    }

    public WebElement selectInput(String src) {
      return  inputDropdown;
    }

    public WebElement setDestination(String dest) {
       return  destination;
        
    }

    public WebElement setWeight(String wt) {
       return weight;
    }

    public WebElement setPieces(String pcs) {
       return pieces;
    }

    public WebElement setShipmentDate(String date) {
       return shipmentDate;
    }

    public WebElement setCommodity(String comm) {
       return commodity;
    }

    public WebElement clickSubmit() {
       return submitBtn;
    }


public void submitAirQuery() throws InterruptedException {
	
	 WebDriverUtility wUtil = new WebDriverUtility();
	 wUtil.javascriptExecutorScroll(driver);
	 clickNext().click();
   //  wUtil.javascriptExecutorClick(driver, nextBtn);
	
	

}
}
