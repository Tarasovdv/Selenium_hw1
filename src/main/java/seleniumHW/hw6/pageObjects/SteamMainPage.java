package seleniumHW.hw6.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static seleniumHW.hw6.utils.Properties.readPropFile;
import static seleniumHW.hw6.utils.Properties.selectParams;
import static seleniumHW.hw6.utils.SingletonDriver.MANAGER_DRIVER;


public class SteamMainPage {
    private static final String PROP_FILE = "chrome.properties";
    private static final String URL_STEAM_GENERAL = selectParams(readPropFile(PROP_FILE), "url.steam.general");
    private final WebDriverWait wait = new WebDriverWait(MANAGER_DRIVER.getDriver(), Duration.ofSeconds(2));
    private final By categoryPulldownDesktopButton = By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']");
    private final By cooperativesLinkButton = By.xpath("//a[contains(text(),'Кооперативы')]");

    public static void goToMainPage() {
        MANAGER_DRIVER.getDriver().get(URL_STEAM_GENERAL);
    }

    public void clickCategoryPulldownDesktopButton() {
        try {
            wait.until(visibilityOfElementLocated(categoryPulldownDesktopButton));
            MANAGER_DRIVER.getDriver().findElement(categoryPulldownDesktopButton).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Категории' в верхнем меню не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCooperativesLinkButton() {
        try {
            wait.until(visibilityOfElementLocated(cooperativesLinkButton));
            MANAGER_DRIVER.getDriver().findElement(cooperativesLinkButton).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Кооперативы' в выпадающем меню 'Категории' не найдена");
            throw noSuchElementException;
        }
    }
}
