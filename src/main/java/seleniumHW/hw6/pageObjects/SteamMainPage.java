package seleniumHW.hw6.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static seleniumHW.hw6.utils.SingletonDriver.DRIVER_MANAGER;

public class SteamMainPage {
    private final WebDriverWait wait = new WebDriverWait(DRIVER_MANAGER.getDriver(), Duration.ofSeconds(2));
    private final By categoryPulldownDesktopButton = By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']");
    private final By cooperativesLinkButton = By.xpath("//a[contains(text(),'Кооперативы')]");

    public void clickCategoryPulldownDesktopButton() {
        try {
            wait.until(visibilityOfElementLocated(categoryPulldownDesktopButton)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Категории' в верхнем меню не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCooperativesLinkButton() {
        try {
            wait.until(visibilityOfElementLocated(cooperativesLinkButton)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Кооперативы' в выпадающем меню 'Категории' не найдена");
            throw noSuchElementException;
        }
    }
}
