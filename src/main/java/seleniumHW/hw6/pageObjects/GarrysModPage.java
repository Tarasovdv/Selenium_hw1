package seleniumHW.hw6.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static seleniumHW.hw6.utils.SingletonDriver.DRIVER_MANAGER;

public class GarrysModPage {
    private final By appName = By.xpath("//div[@id = 'appHubAppName']");
    private final WebDriverWait wait = new WebDriverWait(DRIVER_MANAGER.getDriver(), Duration.ofSeconds(2));

    public String getTextAppName() {
        try {
            wait.until(visibilityOfElementLocated(appName));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("'Текстовое поле с названием игры' не найдено");
            throw noSuchElementException;
        }
        return DRIVER_MANAGER.getDriver().findElement(appName).getText();
    }

}
