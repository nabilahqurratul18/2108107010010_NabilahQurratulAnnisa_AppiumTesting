import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basic extends base {
    public static void main(String[] args) throws MalformedURLException {
        // Set the desired capabilities
        AndroidDriver<AndroidElement> driver = capabilities();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Wait for the app to load
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Input a name in the EditText
        AndroidElement editTextName = driver.findElement(By.id("com.example.androidtest:id/editTextName"));
        editTextName.sendKeys("Nabilah");

        // Click the greet button
        AndroidElement buttonGreet = driver.findElement(By.id("com.example.androidtest:id/buttonGreet"));
        buttonGreet.click();

        // Explicit wait for the TextView to be updated
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement textViewGreeting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.androidtest:id/textViewGreeting")));

        // Get the result from the TextView
        String result = textViewGreeting.getText();

        // Print the result
        System.out.println("Result: " + result);

        // Close the driver
        // driver.quit();
    }
}
