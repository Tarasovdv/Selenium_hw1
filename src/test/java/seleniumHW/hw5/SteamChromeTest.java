package seleniumHW.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertTrue;
import static seleniumHW.hw6.utils.Properties.readPropFile;
import static seleniumHW.hw6.utils.Properties.selectParams;

public class SteamChromeTest {
    private static final String propFile = "chrome.properties";
    private final String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
    private static WebDriver driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();

    private static WebDriverWait wait;

    @BeforeClass
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get(urlSteamGeneral);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы.")
    public static void categoryDownTextIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(visibilityOfElementLocated(By
                                .xpath("//div[@class='home_page_content content_hub_carousel_ctn']/div[@class='title']")))
                        .isDisplayed(),
                "Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы.")
    public static void categoryLeftTextIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(visibilityOfElementLocated(By
                                .xpath("//div[@role='main']//div[@class='home_page_gutter_block']/div[@class='gutter_header pad' and text() = 'Категории']")))
                        .isDisplayed(),
                "Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Выпадающий список по кнопке 'Категории'")
    public static void categoryPullDownButtonIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(visibilityOfElementLocated(By
                        .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")))
                .isDisplayed(), "Выпадающий список по кнопке 'Категории' - не найден");
    }

    @Test(description = "Тест на наличие элемента: Кнопка-ссылка 'Приключенческая игра'"
            , dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void adventureGameLinkButtonIsDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryPullDownButtonElement = wait.until(visibilityOfElementLocated(By
                .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")));
        categoryPullDownButtonElement.click();
        assertTrue(wait.until(visibilityOfElementLocated
                        (By.xpath("//a[contains(text(),'Приключенческая игра')]")))
                .isDisplayed(), "Кнопка-ссылка 'Приключенческая игра' - не найдена");
    }

    @Test(description = "Тест на соответствие текста элемента: Кнопка-ссылка 'Приключенческая игра'"
            , dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void adventureGameLinkButtonGetText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryPullDownButtonElement = wait.until(visibilityOfElementLocated
                (By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")));
        categoryPullDownButtonElement.click();
        Assert.assertEquals(wait.until(visibilityOfElementLocated(By
                                .xpath("//a[contains(text(),'Приключенческая игра')]")))
                        .getText()
                , "Приключенческая игра"
                , "Текст кнопки 'Приключенческая игра' - не соответствует ожидаемому результату");
    }

    @Test
    public static void checkingCorrectnessOfPriceAndCurrency() {
        driver.get("https://store.steampowered.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + 2250 + ");");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoriesButtonTopMenuDesktop = wait.until(visibilityOfElementLocated(By
                .xpath("//img[@alt = 'Симулятор Чушпана']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']")));
        assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Игра по указанному XPath не найдена.");
        String[] parts = categoriesButtonTopMenuDesktop.getText().split(" ");
        Assert.assertEquals(parts[0], "48", "Указана некорректная цена товара");
        Assert.assertEquals(parts[1], "pуб.", "Указана некорректная валюта в стоимости");
    }

    @Test(description = "Тест на соответствие корректного перехода на страницу ИГРЫ по пути:" +
            " Главная страница/Категории/Кооперативы/С наивысшим рейтингом" +
            "/Фильтры:Основные жанры-Казуальная игра/Игроки-кооператив"
            , dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void checkCorrectNameGame() {
        driver.get("https://store.steampowered.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryPullDownButtonElement = wait.until(visibilityOfElementLocated(By
                .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")));
        categoryPullDownButtonElement.click();
        WebElement cooperativesLinkButtonElement = wait.until(visibilityOfElementLocated(By
                .xpath("//a[contains(text(),'Кооперативы')]")));
        cooperativesLinkButtonElement.click();
        scrollJS(1890);
        WebElement filterGamesButton = wait.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Фильтры')]")));
        filterGamesButton.click();
        WebElement casualGameButton = wait.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Основные жанры')]/following::a[contains(text(),'Казуальная игра')]")));
        casualGameButton.click();
        scrollJS(300);
        WebElement gamersButton = wait.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Игроки')]")));
        gamersButton.click();
        WebElement cooperativesButton = wait.until(visibilityOfElementLocated(By
                .xpath("//div[contains(text(),'Игроки')]/following::a[contains(text(),'Кооператив')]")));
        cooperativesButton.click();
        scrollJS(-300);
        driver.get(wait.until(visibilityOfElementLocated(By
                        .xpath("//div[@class='facetedbrowse_FacetedBrowseItems_NO-IP']//a/div[contains(text(),\"Garry's Mod\")]/..")))
                .getAttribute("href"));
        Assert.assertEquals(wait.until(visibilityOfElementLocated
                                (By.xpath("//div[@id = 'appHubAppName']")))
                        .getText()
                , "Garry's Mod"
                , "Произведен некорректный выбор игры");
    }

    private static void scrollJS(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + scroll + ");");
    }
}