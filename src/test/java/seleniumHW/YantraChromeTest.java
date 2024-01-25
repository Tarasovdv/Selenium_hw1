package seleniumHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class YantraChromeTest {
    private WebDriver driver;
    private final String propFile = "chrome.properties";

    private final String chrome = selectParams(readPropFile(propFile), "chrome");
    private final String chromePath = selectParams(readPropFile(propFile), "chrome.path");
    private final String urlYantra = selectParams(readPropFile(propFile), "url.yantra");
//    private final String urlSteam = selectParams(readPropFile(propFile), "url.steam.general");

    @BeforeClass
    public void createDrivers() {
        System.setProperty(chrome, chromePath);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void quitDrivers() {
        driver.quit();
    }

    @Test
    public void currentUrl() {
        driver.get(urlYantra);
        String currentUrl_yantra = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl_yantra, urlYantra);
    }

    @Test
    public void getPageTitle() {
        driver.get(urlYantra);
        String title_yantra = driver.getTitle();
        Assert.assertEquals(title_yantra, "ЯнтраКерамика ручная авторская роспись керамической посуды");
    }

    @Test
    public void navigateTo() {
        String targetUrl = "https://yantrakeramika.ru/catalog/Tarelki/";
        driver.get(urlYantra);
        driver.navigate().to(targetUrl);
        String currentTitleYantra = driver.getTitle();
        Assert.assertEquals(currentTitleYantra, "Керамические тарелки в подарок, под заказ и в наличии");
    }

    @Test
    public void navigateBack() {
        driver.get(urlYantra);
        String startUrl = driver.getCurrentUrl();
        String targetUrl = "https://yantrakeramika.ru/catalog/Tarelki/";
        driver.navigate().to(targetUrl);
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, startUrl);
    }

    @Test
    public void navigateForward() {
        String targetUrl = "https://yantrakeramika.ru/catalog/Tarelki/";
        driver.get(urlYantra);
        driver.navigate().to(targetUrl);
        driver.navigate().back();
        driver.navigate().forward();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, targetUrl);
    }

    @Test
    public void findElement() {
        driver.get(urlYantra);
        WebElement element = driver.findElement(By.className("search-get"));
        Assert.assertNotNull(element);
    }
}