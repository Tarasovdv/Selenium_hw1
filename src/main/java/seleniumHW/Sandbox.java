package seleniumHW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class Sandbox {
    public static void main(String[] args) {
        String propFile = "chrome.properties";
        String xpathFile = "xpath.properties";

        String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
        String xpathCategoryTextDown = selectParams(readPropFile(xpathFile), "category.text.down");
//      String urlYantra = selectParams(readPropFile(propFile), "url.yantra");

        WebDriver driver;
        driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();
        driver.manage().window().maximize();
        driver.get(urlSteamGeneral);

//        #в поиске: 4 - КАТЕГОРИИ текст внизу
        System.out.println("\n");
        WebElement element = driver.findElement(By.xpath(xpathCategoryTextDown));
        System.out.println("element.getText() = " + element.getText());

//        #в поиске: 1.2 - Кнопка КАТЕГОРИИ сверху
        System.out.println("\n");
        WebElement element2 = driver.findElement(By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']"));
        System.out.println("element2.getText() = " + element2.getText());
        System.out.println("element2.isDisplayed() = " + element2.isDisplayed());
        element2.click();

//        #в поиске: 3 - КАТЕГОРИИ текст слева
        System.out.println("\n");
        WebElement element3 = driver.findElement(By.xpath("//div[@role='main']//div[@class='home_page_gutter_block']/div[@class='gutter_header pad' and text() = 'Категории']"));
        System.out.println("element3.getText() = " + element3.getText());
        System.out.println("element3.isDisplayed() = " + element3.isDisplayed());

//        Гипер ссылка на Приключенческие игры
        System.out.println("\n");
        WebElement element4 = driver.findElement(By.xpath("//a[@href='https://store.steampowered.com/category/adventure/?snr=1_4_4__12']"));
        System.out.println("element4.getText() = " + element4.getText());
        System.out.println("element4.isDisplayed() = " + element4.isDisplayed());
        element4.click();



//        3. 5 любых элементов на выбор, нажимайте, берите текст, проверяйте на видимость, разные действия в контексте того, что знаем, ассерты пишем
//        друг другу пишем
//        4. пробуем использовать оси xPath
//        5. подготовить для коллег варианты задач по запросам xPath, без фанатизма
    }
}
