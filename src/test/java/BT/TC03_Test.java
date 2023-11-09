package BT;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.TC03_Page;

import java.time.Duration;
public class TC03_Test {
    @Test
    public void Main() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");

        TC03_Page page = new TC03_Page(driver);

        page.clickOnMobileMenu();
        page.addToCartSonyXperia();
        page.changeQty("1000");
        page.clickUpdateButton();

        String expectedErrorMessage = "Some of the products cannot be ordered in requested quantity.";
        String actualErrorMessage = page.getErrorMessage();
        assert actualErrorMessage.equals(expectedErrorMessage) : "Error message does not match!";

        page.clickEmptyCartLink();

        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        String actualEmptyCartMessage = page.getEmptyCartMessage();
        assert actualEmptyCartMessage.equals(expectedEmptyCartMessage) : "Empty cart message does not match!";

        driver.quit();
    }
}

