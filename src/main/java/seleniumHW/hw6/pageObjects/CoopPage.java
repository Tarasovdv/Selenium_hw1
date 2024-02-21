package seleniumHW.hw6.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static seleniumHW.hw6.utils.SingletonDriver.MANAGER_DRIVER;

public class CoopPage {
    private final By filterGamesButton = By.xpath("//div[contains(text(),'Фильтры')]");
    private final By casualGameButtonOnMainGenreOnFilterParam = By.xpath("//div[contains(text(),'Основные жанры')]/following::a[contains(text(),'Казуальная игра')]");
    private final By mainGenreBorderButtonOnFilterParam = By.xpath("//div[text()='Основные жанры']/..//*[local-name()='svg']");
    private final By gamersBorderButtonOnFilterParam = By.xpath("//div[contains(text(),'Игроки')]");
    private final By cooperativesButtonOnGamersOnFilterParam = By.xpath("//div[contains(text(),'Игроки')]/following::a[contains(text(),'Кооператив')]");
    private final By capsuleImageGameLink = By.xpath("//div[contains(@class,'NO-IP')]//a//img[contains(@alt,\"Garry's Mod\")]");
    private final Actions actionWithYourFrame = new Actions(MANAGER_DRIVER.getDriver());
    private final WebDriverWait wait = new WebDriverWait(MANAGER_DRIVER.getDriver(), Duration.ofSeconds(2));

    public void clickFilterGamesButton() {
        try {
            wait.until(visibilityOfElementLocated(filterGamesButton));
            MANAGER_DRIVER.getDriver().findElement(filterGamesButton).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Фильтры' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCasualGameButtonOnMainGenreOnFilterParam() {
        try {
            wait.until(visibilityOfElementLocated(casualGameButtonOnMainGenreOnFilterParam));
            MANAGER_DRIVER.getDriver().findElement(casualGameButtonOnMainGenreOnFilterParam).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Казуальная игра'->'Основные жанры'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void collapseSectionMainGenreOnFilterParam() {
        try {
            wait.until(visibilityOfElementLocated(mainGenreBorderButtonOnFilterParam));
            MANAGER_DRIVER.getDriver().findElement(mainGenreBorderButtonOnFilterParam).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Свернуть раздел Основные жанры'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickGamersBorderButtonOnFilterParam() {
        try {
            wait.until(visibilityOfElementLocated(gamersBorderButtonOnFilterParam));
            actionWithYourFrame.scrollToElement(MANAGER_DRIVER.getDriver().findElement(gamersBorderButtonOnFilterParam)).build().perform();
            MANAGER_DRIVER.getDriver().findElement(gamersBorderButtonOnFilterParam).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Игроки'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCooperativesButtonOnGamersOnFilterParam() {
        try {
            wait.until(visibilityOfElementLocated(cooperativesButtonOnGamersOnFilterParam));
            actionWithYourFrame.scrollToElement(MANAGER_DRIVER.getDriver().findElement(cooperativesButtonOnGamersOnFilterParam)).build().perform();
            MANAGER_DRIVER.getDriver().findElement(cooperativesButtonOnGamersOnFilterParam).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Кооперативы'->'Игроки'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCapsuleImageGameLink() {
        try {
            wait.until(visibilityOfElementLocated(capsuleImageGameLink));
            actionWithYourFrame.scrollToElement(MANAGER_DRIVER.getDriver().findElement(capsuleImageGameLink)).build().perform();
            MANAGER_DRIVER.getDriver().findElement(capsuleImageGameLink).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка игры 'Garry's Mod' не найдена");
            throw noSuchElementException;
        }
    }
}
