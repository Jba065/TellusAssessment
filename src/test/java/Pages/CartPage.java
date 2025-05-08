package Pages;


import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    WebElement checkoutButton = driver.findElement(By.id("checkout"));
    List<WebElement> removeButtons = driver.findElements(By.xpath("//button[starts-with(@id,\"remove\")]"));
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage removeOneItem() {
        removeButtons.get(0).click();
        return this;
    }
    public CheckoutAddressPg checkout() {
        checkoutButton.click();
        return new CheckoutAddressPg(driver);
    }
}

