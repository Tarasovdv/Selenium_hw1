package sandbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.WindowType.WINDOW;
import static sandbox.Properties.readPropFile;
import static sandbox.Properties.selectParams;

public class Sandbox {
    public static void main(String[] args) throws IOException {
        String propFile = "chrome.properties";
        String xpathFile = "xpath.properties";

        String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
//        String xpathCategoryTextDown = selectParams(readPropFile(xpathFile), "category.text.down");
////      String urlYantra = selectParams(readPropFile(propFile), "url.yantra");

        WebDriver driver;
        driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();
        driver.manage().window().maximize();
        driver.get(urlSteamGeneral);

//        #в поиске: 4 - КАТЕГОРИИ текст внизу
//        System.out.println("\n");
//        WebElement element = driver.findElement(By.xpath(xpathCategoryTextDown));
        //div[@class='home_page_content content_hub_carousel_ctn']/div[@class='title']
//        System.out.println("element.getText() = " + element.getText());

//        #в поиске: 1.2 - Кнопка КАТЕГОРИИ сверху
//        System.out.println("\n");
//        WebElement element2 = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
//        System.out.println("element2.getText() = " + element2.getText());
//        System.out.println("element2.isDisplayed() = " + element2.isDisplayed());
//        element2.click();

//        #в поиске: 3 - КАТЕГОРИИ текст слева
//        System.out.println("\n");
//        WebElement element3 = driver.findElement(By.xpath("//div[@role='main']//div[@class='home_page_gutter_block']/div[@class='gutter_header pad' and text() = 'Категории']"));
//        System.out.println("element3.getText() = " + element3.getText());
//        System.out.println("element3.isDisplayed() = " + element3.isDisplayed());

//        Гипер ссылка на Приключенческие игры
//        System.out.println("\n");
//        WebElement element4 = driver.findElement(By.xpath("//a[@href='https://store.steampowered.com/category/adventure/?snr=1_4_4__12']"));
//        System.out.println("element4.getText() = " + element4.getText());
//        System.out.println("element4.isDisplayed() = " + element4.isDisplayed());
//        element4.click();
//
//        LOGO STEAM
//        System.out.println("\n");
//        WebElement elementLogo = driver.findElement(By.xpath("//div[@class = 'logo']//child::img"));
//        String src = elementLogo.getAttribute("src");
//        System.out.println("src = " + src);
//        System.out.println("elementLogo.isDisplayed() = " + elementLogo.isDisplayed());
//        elementLogo.click();

//        LOGO STEAM 2
//        driver.switchTo(src);
//        driver.switchTo().newWindow(WINDOW);
//        driver.get(src);
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("C:\\Users\\HANNYA\\IdeaProjects\\BUTTON-ONE\\Selenium_hw1\\src\\main\\resources\\scrn.png"));
//        System.out.println("scrsht safed!");
//
////        SEARCH
//        System.out.println("\n");
//        WebElement search = driver.findElement(By.xpath("//div[@class = 'search_area']//child::input[@placeholder = 'поиск']"));
//        System.out.println("search.isDisplayed() = " + search.isDisplayed());
//        search.sendKeys("warhammer 40000");
//        search.submit();

//        INTO SEARCH #2 btn close
//        v1
//        WebElement btnClose = driver.findElement(By.xpath("//div[@class = 'searchtag']//child::a"));
//        driver.switchTo().frame(btnClose);
//        driver.findElement(By.className("btn")).click();
//        System.out.println("btn close - done");


////        v2
//        WebElement frameWithBtnClose = driver.findElement(By.xpath("//div[@class = 'termcontainer']"));
//        driver.switchTo().frame(frameWithBtnClose);
//        driver.findElement(By.className("btn")).click();

//        SCROLL

//        WebElement scrollFrame = driver.findElement(By.xpath("//div[@class = 'range_container_inner']//child::input[@id = 'price_range']"));
//        driver.switchTo().frame("price_range");
        WebElement newInterestingPullDownButtonElement = driver.findElement(By.xpath("//a[ @class = 'pulldown_desktop' and text() ='Новое и интересное']"));
        newInterestingPullDownButtonElement.click();
        WebElement newGamesLinkButton = driver.findElement(By.xpath("//a[ @class = 'popup_menu_item' and contains(text(),'Новинки')]"));
        newGamesLinkButton.click();
        WebElement priceTekken8FromPopularNewGamesInRu = driver.findElement(By.xpath("//a[@class = 'tab_item app_impression_tracked']//div[ @class = 'discount_final_price' and contains(text(),'4199 pуб.')] |and| div[@class = 'tab_item_name' and contains(text(),'TEKKEN 8')]"));
        String priceTekken8 = priceTekken8FromPopularNewGamesInRu.getText();
        System.out.println("priceTekken8 = " + priceTekken8);

    }
}
