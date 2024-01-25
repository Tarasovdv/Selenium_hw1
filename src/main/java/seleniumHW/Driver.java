package seleniumHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static seleniumHW.ReadProperties.*;

public class Driver {

    public static void main(String[] args) {

//        Properties File Name
        String propFile = "chrome.properties";

//        CHROME PARAMS
        String chrome = selectParams(readPropFile(propFile), "chrome");
        String chromePath = selectParams(readPropFile(propFile), "chrome.path");

//        URLs
//        String urlSteam = selectParams(readPropFile(propFile), "url.steam.general");
        String urlYantra = selectParams(readPropFile(propFile), "url.yantra");
        String urlCatalogPlate = "https://yantrakeramika.ru/catalog/Tarelki/";

        System.setProperty(chrome, chromePath);
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get(urlYantra);
        System.out.println("chromeDriver.getTitle() = " + chromeDriver.getTitle());

        chromeDriver.navigate().to(urlCatalogPlate);
        System.out.println("chromeDriver.getTitle() = " + chromeDriver.getTitle());

        chromeDriver.quit();
    }
}