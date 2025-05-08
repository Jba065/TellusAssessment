package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutAddressPg extends BasePage {
    public CheckoutAddressPg(WebDriver driver) {
        super(driver);
    }

    public CheckoutAddressPg populateAddress(String firstName, String lastName, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewPg clickContinue() {
        driver.findElement(By.id("continue")).click();
        return new CheckoutOverviewPg(driver);
    }
}
