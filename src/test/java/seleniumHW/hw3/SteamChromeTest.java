package seleniumHW.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class SteamChromeTest {
   private static final String propFile = "chrome.properties";
   private final String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
   private static WebDriver driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();

    @BeforeClass
    public void createDrivers() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlSteamGeneral);
    }

    @AfterClass
    public void quitDrivers() {
        driver.quit();
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы.")
    public static void categoryDownTextIsDisplayed() {
        WebElement categoryDownTextElement = driver.findElement(By.xpath("//div[@class='home_page_content content_hub_carousel_ctn']/div[@class='title']"));
        boolean categoryDownTextIsDisplayed = categoryDownTextElement.isDisplayed();
        Assert.assertTrue(categoryDownTextIsDisplayed, "Текстовый эл-т 'КАТЕГОРИИ', находящийся внизу главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы.")
    public static void categoryLeftTextIsDisplayed() {
        WebElement categoryLeftTextElement = driver.findElement(By.xpath("//div[@role='main']//div[@class='home_page_gutter_block']/div[@class='gutter_header pad' and text() = 'Категории']"));
        boolean categoryLeftTextIsDisplayed = categoryLeftTextElement.isDisplayed();
        Assert.assertTrue(categoryLeftTextIsDisplayed, "Текстовый эл-т 'КАТЕГОРИИ', находящийся в левом меню главной страницы - не найден");
    }

    @Test(description = "Тест на наличие элемента: Выпадающий список по кнопке 'Категории'")
    public static void categoryPullDownButtonIsDisplayed() {
        WebElement categoryPullDownButtonElement = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        boolean categoryPullDownButtonIsDisplayed = categoryPullDownButtonElement.isDisplayed();
        Assert.assertTrue(categoryPullDownButtonIsDisplayed, "Выпадающий список по кнопке 'Категории' - не найден");
    }

    @Test(description = "Тест на наличие элемента: Кнопка-ссылка 'Приключенческая игра'", dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void adventureGameLinkButtonIsDisplayed() {
        WebElement categoryPullDownButtonElement = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        categoryPullDownButtonElement.click();
        WebElement adventureGameLinkButtonElement = driver.findElement(By.xpath("//a[contains(text(),'Приключенческая игра')]"));
        boolean adventureGameLinkButtonIsDisplayed = adventureGameLinkButtonElement.isDisplayed();
        Assert.assertTrue(adventureGameLinkButtonIsDisplayed, "Кнопка-ссылка 'Приключенческая игра' - не найдена");
    }

    @Test(description = "Тест на соответствие текста элемента: Кнопка-ссылка 'Приключенческая игра'", dependsOnMethods = {"categoryPullDownButtonIsDisplayed"})
    public static void adventureGameLinkButtonGetText() {
        WebElement categoryPullDownButtonElement = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        categoryPullDownButtonElement.click();
        WebElement adventureGameLinkButtonElement = driver.findElement(By.xpath("//a[contains(text(),'Приключенческая игра')]"));
        String adventureGameLinkButtonText = adventureGameLinkButtonElement.getText();
        Assert.assertEquals(adventureGameLinkButtonText, "Приключенческая игра", "Текст кнопки 'Приключенческая игра' - не соответствует ожидаемому результату");
    }

    @Test(description = "Тест на корректность отображения стоимости товара: TEKKEN-8 в разделе 'Популярные новинки'")
    public static void priceTekken8FromPopularNewGamesInRu() {
        WebElement newInterestingPullDownButtonElement = driver.findElement(By.xpath("//a[ @class = 'pulldown_desktop' and text() ='Новое и интересное']"));
        newInterestingPullDownButtonElement.click();
        WebElement newGamesLinkButton = driver.findElement(By.xpath("//a[ @class = 'popup_menu_item' and contains(text(),'Новинки')]"));
        newGamesLinkButton.click();
        WebElement priceTekken8FromPopularNewGamesInRu = driver.findElement(By.xpath("//a[@class = 'tab_item app_impression_tracked']//div[ @class = 'discount_final_price' and contains(text(),'4199 pуб.')] |and| div[@class = 'tab_item_name' and contains(text(),'TEKKEN 8')]"));
        String priceTekken8 = priceTekken8FromPopularNewGamesInRu.getText();
        Assert.assertEquals(priceTekken8, "4199 руб.", "Текст кнопки 'Приключенческая игра' - не соответствует ожидаемому результату");
    }
}
