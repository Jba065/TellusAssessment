package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
   // WebDriver driver;

    List<WebElement> addToCartButtons= driver.findElements(By.xpath("//button[starts-with(@id,\"add\")]"));
    WebElement shoppingCartButton= driver.findElement(By.id("shopping_cart_container"));

    public ProductsPage(WebDriver driver) {
       super(driver);
    }

    public CartPage addThreeItemsToCart() {

        addToCartButtons.stream().limit(3).forEach(button -> button.click()) ;
        shoppingCartButton.click();
        return new CartPage(driver);

    }
    public CartPage addItemsWithin20And50() {
        driver.findElements(By.xpath("//div[@data-test=\"inventory-item\"]")).stream()
                .filter(element -> (Integer.parseInt(element.getText().substring(element.getText().indexOf("$") + 1, element.getText().lastIndexOf("."))) > 30) &&
                        (Integer.parseInt(element.getText().substring(element.getText().indexOf("$") + 1, element.getText().lastIndexOf("."))) > 30))
                .map(element -> element.findElement(By.xpath(".//button[contains(text(),'Add to cart')]")))
                .forEach(element -> element.click());
        shoppingCartButton.click();
        return new CartPage(driver);
    }


}
