package seleniumHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static seleniumHW.ReadProperties.readPropFile;
import static seleniumHW.ReadProperties.selectParams;

public class TestNG {
    private WebDriver driver_yantra;
    private WebDriver driver_steam;
    private String propFile = "chrome.properties";

    private String chrome = selectParams(readPropFile(propFile), "chrome");
    private String chrome_path = selectParams(readPropFile(propFile), "chrome_path");
    private String url_yantra = selectParams(readPropFile(propFile), "url_yantra");
    private String url_steam = selectParams(readPropFile(propFile), "url_steam_general");

    public TestNG() throws IOException {
    }


    @BeforeClass
    public void createDrivers() throws IOException {
        System.setProperty(chrome, chrome_path);
        driver_yantra = new ChromeDriver();
        driver_steam = new ChromeDriver();
    }

//    @AfterClass
//    public void quitDrivers() {
//        driver_yantra.quit();
//        driver_steam.quit();
//    }

    @Test
    public void currentUrl() throws IOException {
        driver_yantra.get(url_yantra);
        driver_steam.get(url_steam);

        String currentUrl_yantra = driver_yantra.getCurrentUrl();
        String currentUrl_steam = driver_steam.getCurrentUrl();

        Assert.assertEquals(currentUrl_yantra, url_yantra);
        Assert.assertEquals(currentUrl_steam, url_steam);
    }

    @Test
    public void getPageTitle() {
        driver_yantra.get(url_yantra);
        driver_steam.get(url_steam);

        String title_yantra = driver_yantra.getTitle();
        String title_steam = driver_steam.getTitle();

        Assert.assertEquals(title_yantra, "ЯнтраКерамика ручная авторская роспись керамической посуды");
        Assert.assertEquals(title_steam, "Добро пожаловать в Steam");
    }

    @Test
    public void navigateTo() {
        String targetUrl = "https://yantrakeramika.ru/catalog/Tarelki/";

        driver_yantra.get(url_yantra);
        driver_yantra.navigate().to(targetUrl);

        String currentTitle_yantra = driver_yantra.getTitle();

        Assert.assertEquals(currentTitle_yantra, "Керамические тарелки в подарок, под заказ и в наличии");
    }

    @Test
    public void navigateBack() {
        driver_yantra.get(url_yantra);

        String startUrl = driver_yantra.getCurrentUrl();
        String targetUrl = "https://yantrakeramika.ru/catalog/Tarelki/";

        driver_yantra.navigate().to(targetUrl);
        driver_yantra.navigate().back();

        String currentUrl = driver_yantra.getCurrentUrl();

        Assert.assertEquals(currentUrl, startUrl);
    }

    @Test
    public void navigateForward() {
        String targetUrl = "https://yantrakeramika.ru/catalog/Tarelki/";

        driver_yantra.get(url_yantra);
        driver_yantra.navigate().to(targetUrl);
        driver_yantra.navigate().back();
        driver_yantra.navigate().forward();

        String currentUrl = driver_yantra.getCurrentUrl();

        Assert.assertEquals(currentUrl, targetUrl);
    }

    @Test
    public void findElement() {
        driver_yantra.get(url_yantra);

        WebElement element = driver_yantra.findElement(By.className("search-get"));

        Assert.assertNotNull(element);
    }
}