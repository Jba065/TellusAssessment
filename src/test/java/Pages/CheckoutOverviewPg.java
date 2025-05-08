package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPg extends BasePage {
     public CheckoutOverviewPg(WebDriver driver) {
        super(driver);
    }
    public void clickFinish(){
        driver.findElement(By.id("finish")).click();
    }
}


