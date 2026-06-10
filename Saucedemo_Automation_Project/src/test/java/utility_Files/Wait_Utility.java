package utility_Files;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utility {

	
	//waits for an element to be clickable(Best for Button/Links)
	public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	// waits for an elemnet to be visible (Best for Text/labels)
	public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
