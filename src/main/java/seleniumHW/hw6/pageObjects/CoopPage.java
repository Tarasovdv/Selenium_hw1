package seleniumHW.hw6.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static seleniumHW.hw6.utils.SingletonDriver.DRIVER_MANAGER;

public class CoopPage {
    private final By filterGamesButton = By.xpath("//div[contains(text(),'Фильтры')]");
    private final By casualGameButtonOnMainGenreOnFilterParam = By.xpath("//div[contains(text(),'Основные жанры')]/following::a[contains(text(),'Казуальная игра')]");
    private final By mainGenreBorderButtonOnFilterParam = By.xpath("//div[text()='Основные жанры']/..//*[local-name()='svg']");
    private final By gamersBorderButtonOnFilterParam = By.xpath("//div[contains(text(),'Игроки')]");
    private final By cooperativesButtonOnGamersOnFilterParam = By.xpath("//div[contains(text(),'Игроки')]/following::a[contains(text(),'Кооператив')]");
    private final By capsuleImageGameLink = By.xpath("//div[contains(@class,'NO-IP')]//a//img[contains(@alt,\"Garry's Mod\")]");
    private final By filterSectionFrame = new By.ByXPath("//div[@id = 'SaleSection_13268']");
    private final Actions actionWithYourFrame = new Actions(DRIVER_MANAGER.getDriver());
    private final WebDriverWait wait = new WebDriverWait(DRIVER_MANAGER.getDriver(), Duration.ofSeconds(2));

    public void clickFilterGamesButton() {
        try {
            wait.until(visibilityOfElementLocated(filterGamesButton)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Фильтры' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCasualGameButtonOnMainGenreOnFilterParam() {
        try {
            wait.until(visibilityOfElementLocated(casualGameButtonOnMainGenreOnFilterParam)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Казуальная игра'->'Основные жанры'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void collapseSectionMainGenreOnFilterParam() {
        try {
            wait.until(visibilityOfElementLocated(mainGenreBorderButtonOnFilterParam)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Свернуть раздел Основные жанры'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickGamersBorderButtonOnFilterParam() {
        try {
            actionWithYourFrame.scrollToElement(wait.until(visibilityOfElementLocated(gamersBorderButtonOnFilterParam))).build().perform();
            DRIVER_MANAGER.getDriver().findElement(gamersBorderButtonOnFilterParam).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Игроки'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCooperativesButtonOnGamersOnFilterParam() {
        try {
            actionWithYourFrame.scrollToElement(wait.until(visibilityOfElementLocated(cooperativesButtonOnGamersOnFilterParam))).build().perform();
            DRIVER_MANAGER.getDriver().findElement(cooperativesButtonOnGamersOnFilterParam).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Кооперативы'->'Игроки'->'Фильтр' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickCapsuleImageGameLink() {
        try {
            actionWithYourFrame.scrollToElement(wait.until(visibilityOfElementLocated(capsuleImageGameLink))).build().perform();
            DRIVER_MANAGER.getDriver().findElement(capsuleImageGameLink).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка игры 'Garry's Mod' не найдена");
            throw noSuchElementException;
        }
    }

    public void scrollingFilterSectionFrame() {
        try {
            actionWithYourFrame.scrollToElement(wait.until(visibilityOfElementLocated(filterSectionFrame))).perform();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел с фильтром не найден");
            throw noSuchElementException;
        }
    }

}
