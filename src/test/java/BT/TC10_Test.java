package BT;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import driver.driverFactory;
import pom.TC10_Page;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class TC10_Test {
    @Test
    public void captureScreenshotByCondition() throws IOException {
        WebDriver driver = driverFactory.getChromeDriver();
        TC10_Page page = new TC10_Page(driver);

        // Step 1: Go to backend login page
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        // Step 2: Login with provided credentials
        page.login("user01", "guru99com");

        // Step 3: Navigate to Sales -> Orders menu
        page.closeMsgBox();
        page.goToOrders();

        // Step 4: Input OrderId and FromDate -> ToDate
        // Assuming you have elements for OrderId, FromDate, ToDate, and Search button
        // Modify the following lines with the actual elements
        By OrderIdInput = By.id("sales_order_grid_filter_real_order_id");
        By FromDateInput = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[1]/input");

        By ToDateInput = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[2]/input");
        By SearchButton = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/table/tbody/tr/td[3]/button[2]");

        driver.findElement(OrderIdInput).sendKeys("60024");
        driver.findElement(FromDateInput).sendKeys("2023-01-01"); // Replace with your FromDate
        driver.findElement(ToDateInput).sendKeys("2023-12-31"); // Replace with your ToDate
        driver.findElement(SearchButton).click();

        // Step 5: Screenshot capture
         TakesScreenshot screenshot = (TakesScreenshot) driver;
         File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
         String screenshotPath = "./screenshot.png";
         FileUtils.copyFile(srcFile, new File(screenshotPath));

        // Step 6: Handle the captured screenshot as needed
         driver.quit();
    }
}
