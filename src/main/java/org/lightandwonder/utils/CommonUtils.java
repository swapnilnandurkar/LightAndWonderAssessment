package org.lightandwonder.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

public class CommonUtils {
    WebDriver driver;

    public CommonUtils(WebDriver driver){
        this.driver = driver;
    }

    public void switchToWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
    }

    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }

    public  void switchToNewWindow(String currentWindowHandles){
        Set<String> windowHandles = driver.getWindowHandles();
        for(String windowHandle : windowHandles){
            if(!Objects.equals(windowHandle, currentWindowHandles)) {
                switchToWindow(windowHandle);
                break;
            }
        }
    }

    public void handleElementNotIntractableException(String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Attempt to click on the element with retry mechanism
        boolean clicked = false;
        int retryCount = 0;
        while (!clicked && retryCount < 3) { // Retry for a maximum of 3 times
            try {
                // Check if the element is present using explicit wait
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
                element.click();
                clicked = true; // Set clicked to true if click succeeds
            } catch (ElementNotInteractableException e) {
                retryCount++;
            }
        }
    }
}
