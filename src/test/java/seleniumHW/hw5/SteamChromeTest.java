package seleniumHW.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertTrue;
import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class SteamChromeTest {
    private static final String PROP_FILE = "chrome.properties";
    private static final String URL_STEAM_GENERAL = selectParams(readPropFile(PROP_FILE), "url.steam.general");
    private static final WebDriver DRIVER = WebDriverManager.getInstance(selectParams(readPropFile(PROP_FILE), "browser.name")).create();

    private static final WebDriverWait WAIT = new WebDriverWait(DRIVER, Duration.ofSeconds(2));

    @BeforeClass
    public void createDriver() {
        DRIVER.manage().window().maximize();
    }

    @AfterClass
    public void quitDriver() {
        DRIVER.quit();
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы.")
    public static void visibilityTextElementAtBottomPage() {
        DRIVER.get(URL_STEAM_GENERAL);
        assertTrue(WAIT.until(visibilityOfElementLocated(By
                                .xpath("//div[contains(@class,'content_hub_carousel')]/div[@class='title']")))
                        .isDisplayed(),
                "Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы.")
    public static void visibilityTextElementOnLeftSidePage() {
        DRIVER.get(URL_STEAM_GENERAL);
        assertTrue(WAIT.until(visibilityOfElementLocated(By
                                .xpath("//div[text() = 'Рекомендуется']/following::div[@class='gutter_header pad' and text() = 'Категории']")))
                        .isDisplayed(),
                "Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Выпадающий список по кнопке 'Категории'")
    public static void categoryPullDownButtonIsDisplayed() {
        DRIVER.get(URL_STEAM_GENERAL);
        assertTrue(WAIT.until(visibilityOfElementLocated(By
                        .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")))
                .isDisplayed(), "Выпадающий список по кнопке 'Категории' - не найден");
    }

    @Test(description = "Тест на наличие элемента: Кнопка-ссылка 'Приключенческая игра'")
    public static void adventureGameLinkButtonIsDisplayed() {
        DRIVER.get(URL_STEAM_GENERAL);
        WebElement categoryPullDownButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")));
        categoryPullDownButton.click();
        assertTrue(WAIT.until(visibilityOfElementLocated
                        (By.xpath("//a[contains(text(),'Приключенческая игра')]")))
                .isDisplayed(), "Кнопка-ссылка 'Приключенческая игра' - не найдена");
    }

    @Test(description = "Тест на соответствие текста элемента: Кнопка-ссылка 'Приключенческая игра'")
    public static void adventureGameLinkButtonGetText() {
        DRIVER.get(URL_STEAM_GENERAL);
        WebElement categoryPullDownButton = WAIT.until(visibilityOfElementLocated
                (By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")));
        categoryPullDownButton.click();
        Assert.assertEquals(WAIT.until(visibilityOfElementLocated(By
                                .xpath("//a[contains(text(),'Приключенческая игра')]")))
                        .getText()
                , "Приключенческая игра"
                , "Текст кнопки 'Приключенческая игра' - не соответствует ожидаемому результату");
    }

    @Test
    public static void checkingCorrectnessOfPriceAndCurrency() {
        DRIVER.get(URL_STEAM_GENERAL);
        SoftAssert softAssert = new SoftAssert();
        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
        js.executeScript("window.scrollBy(0, " + 2250 + ");");
        WebElement categoriesButtonTopMenuDesktop = WAIT.until(visibilityOfElementLocated(By
                .xpath("//img[@alt = 'Goat Simulator 3']/ancestor::a[contains(@class,'app_impression_tracked')]" +
                        "//div[@class = 'discount_final_price']")));
        softAssert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Игра по указанному XPath не найдена.");
        String[] parts = categoriesButtonTopMenuDesktop.getText().split(" ");
        softAssert.assertEquals(parts[0], "715", "Указана некорректная цена товара");
        softAssert.assertEquals(parts[1], "pуб.", "Указана некорректная валюта в стоимости");
        softAssert.assertAll();
    }

    @Test(description = "Тест на соответствие корректного перехода на страницу ИГРЫ по пути:" +
            " Главная страница/Категории/Кооперативы/С наивысшим рейтингом" +
            "/Фильтры:Основные жанры-Казуальная игра/Игроки-кооператив")
    public static void checkCorrectNameGame() {
        DRIVER.get(URL_STEAM_GENERAL);
        Actions actionWithYourFrame = new Actions(DRIVER);
        WebElement categoryPullDownButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")));
        categoryPullDownButton.click();
        WebElement cooperativesLinkButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//a[contains(text(),'Кооперативы')]")));
        cooperativesLinkButton.click();
        scrollJS(1890);
        WebElement filterGamesButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Фильтры')]")));
        filterGamesButton.click();
        WebElement casualGameButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Основные жанры')]/following::a[contains(text(),'Казуальная игра')]")));
        casualGameButton.click();
        WebElement mainGenresBorderButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div[text()='Основные жанры']/..//*[local-name()='svg']")));
        mainGenresBorderButton.click();
        WebElement gamersButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Игроки')]")));
        actionWithYourFrame.scrollToElement(gamersButton).build().perform();
        gamersButton.click();
        WebElement cooperativesButton = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Игроки')]/following::a[contains(text(),'Кооператив')]")));
        actionWithYourFrame.scrollToElement(cooperativesButton).build().perform();
        cooperativesButton.click();
        WebElement capsuleImageGameLink = WAIT.until(visibilityOfElementLocated(By
                .xpath("//div[contains(@class,'NO-IP')]//a//img[contains(@alt,\"Garry's Mod\")]")));
        actionWithYourFrame.scrollToElement(capsuleImageGameLink).build().perform();
        capsuleImageGameLink.click();
        ArrayList<String> tabs = new ArrayList<>(DRIVER.getWindowHandles());
        DRIVER.switchTo().window(tabs.get(1));
        Assert.assertEquals(WAIT.until(visibilityOfElementLocated
                                (By.xpath("//div[@id = 'appHubAppName']")))
                        .getText()
                , "Garry's Mod"
                , "Произведен некорректный выбор игры");
    }

    private static void scrollJS(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
        js.executeScript("window.scrollBy(0, " + scroll + ");");
    }
}