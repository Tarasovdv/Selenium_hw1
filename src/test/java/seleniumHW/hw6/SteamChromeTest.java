package seleniumHW.hw6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;
import static seleniumHW.hw6.SingletonDriver.getDriver;

public class SteamChromeTest {
    private static final String PROP_FILE = "chrome.properties";
    private static final String URL_STEAM_GENERAL = selectParams(readPropFile(PROP_FILE), "url.steam.general");
    static WebDriver driver = getDriver();
    static SteamMainPage mainPage = new SteamMainPage();


    @BeforeClass
    public void createDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get(URL_STEAM_GENERAL);

    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы.")
    public static void visibilityCategoryTextElementAtBottomPage() {
        assertTrue(mainPage.visibilityCategoryTextElementAtBottomPage(),
                "Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы.")
    public static void visibilityTextElementOnLeftSidePage() {
        assertTrue(mainPage.visibilityCategoryTextElementOnLeftSidePage(),
                "Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Выпадающий список по кнопке 'Категории'")
    public static void visibilityCategoryPullDownButtonIsDisplayed() {
        assertTrue(mainPage.visibilityCategoryPullDownButton(), "Выпадающий список по кнопке 'Категории' - не найден");
    }

    @Test(description = "Тест на соответствие текста элемента: Кнопка-ссылка 'Приключенческая игра'")
    public static void adventureGameLinkButtonGetText() {
        mainPage.clickCategoryPullDownButton();
        Assert.assertEquals(mainPage.adventureGameLinkButtonGetText()
                , "Приключенческая игра"
                , "Текст кнопки 'Приключенческая игра' - не соответствует ожидаемому результату");
    }

    @Test
    public static void checkingCorrectnessOfPriceAndCurrency() {
        SoftAssert softAssert = new SoftAssert();
        scrollJS(2250);
        softAssert.assertTrue(mainPage.visibilityCategoriesButtonTopMenuDesktop(), "Игра по указанному XPath не найдена.");
        String[] parts = mainPage.categoriesButtonTopMenuDesktopGetText().split(" ");
        softAssert.assertEquals(parts[0], "715", "Указана некорректная цена товара");
        softAssert.assertEquals(parts[1], "pуб.", "Указана некорректная валюта в стоимости");
        softAssert.assertAll();
    }

    private static void scrollJS(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + scroll + ");");
    }
}