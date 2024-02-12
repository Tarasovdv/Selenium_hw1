package seleniumHW.hw3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class SteamChromeTest {
    private static final String propFile = "chrome.properties";
    private final String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
    private static WebDriver driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();

    @BeforeClass
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlSteamGeneral);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы.")
    public static void categoryDownTextIsDisplayed() {
        WebElement categoryDownTextElement = driver.findElement(By.xpath("//div[@class='home_page_content content_hub_carousel_ctn']/div[@class='title']"));
        Assert.assertTrue(categoryDownTextElement.isDisplayed(), "Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы.")
    public static void categoryLeftTextIsDisplayed() {
        WebElement categoryLeftTextElement = driver.findElement(By.xpath("//div[@role='main']//div[@class='home_page_gutter_block']/div[@class='gutter_header pad' and text() = 'Категории']"));
        Assert.assertTrue(categoryLeftTextElement.isDisplayed(), "Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Выпадающий список по кнопке 'Категории'")
    public static void categoryPullDownButtonIsDisplayed() {
        WebElement categoryPullDownButtonElement = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        Assert.assertTrue(categoryPullDownButtonElement.isDisplayed(), "Выпадающий список по кнопке 'Категории' - не найден");
    }

    @Test(description = "Тест на наличие элемента: Кнопка-ссылка 'Приключенческая игра'", dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void adventureGameLinkButtonIsDisplayed() {
        WebElement categoryPullDownButtonElement = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        categoryPullDownButtonElement.click();
        WebElement adventureGameLinkButtonElement = driver.findElement(By.xpath("//a[contains(text(),'Приключенческая игра')]"));
        Assert.assertTrue(adventureGameLinkButtonElement.isDisplayed(), "Кнопка-ссылка 'Приключенческая игра' - не найдена");
    }

    @Test(description = "Тест на соответствие текста элемента: Кнопка-ссылка 'Приключенческая игра'", dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void adventureGameLinkButtonGetText() {
        WebElement categoryPullDownButtonElement = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        categoryPullDownButtonElement.click();
        WebElement adventureGameLinkButtonElement = driver.findElement(By.xpath("//a[contains(text(),'Приключенческая игра')]"));
        Assert.assertEquals(adventureGameLinkButtonElement.getText(), "Приключенческая игра", "Текст кнопки 'Приключенческая игра' - не соответствует ожидаемому результату");
    }

    @Test
    public static void checkingCorrectnessOfPriceAndCurrencyTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://store.steampowered.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + 2250 + ");");
        WebElement categoriesButtonTopMenuDesktop = driver.findElement(By.xpath("//img[@alt = 'TEKKEN 8']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']"));
        Assert.assertTrue(categoriesButtonTopMenuDesktop.isDisplayed(), "Игра по указанному XPath не найдена.");
        String[] parts = categoriesButtonTopMenuDesktop.getText().split(" ");
        Assert.assertEquals(parts[0], "4199", "Указана некорректная цена товара");
        Assert.assertEquals(parts[1], "pуб.", "Указана некорректная валюта в стоимости");
    }
}