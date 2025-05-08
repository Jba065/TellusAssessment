import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TellusTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLogin()  {
        LoginPage loginPagePg = new LoginPage(driver);
        loginPagePg.loginWithStandardUser("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login Successful");


    }

    @Test
    public void verifyCheckout2Items()  {
        LoginPage loginPagePg = new LoginPage(driver);
        loginPagePg.loginWithStandardUser("standard_user", "secret_sauce")
                .addThreeItemsToCart()
                .removeOneItem()
                .checkout()
                .populateAddress("aaa", "bbb", "11111").clickContinue()
                .clickFinish();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "Checkout Successful");
    }

    @Test
    public void verifyOrderBetween20And50(){
        LoginPage loginPagePg = new LoginPage(driver);
        loginPagePg.loginWithStandardUser("standard_user", "secret_sauce")
                .addItemsWithin20And50();
    }
}