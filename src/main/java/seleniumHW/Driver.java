package seleniumHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static seleniumHW.ReadProperties.*;

public class Driver {

    public static void main(String[] args) throws IOException {

//        Properties File Name
        String propFile = "chrome.properties";

//        CHROME PARAMS
        String chrome = selectParams(readPropFile(propFile), "chrome");
        String chrome_path = selectParams(readPropFile(propFile), "chrome_path");

//        URLs
        String url_steam_general = selectParams(readPropFile(propFile), "url_steam_general");
        String url_yantra = selectParams(readPropFile(propFile), "url_yantra");

        System.setProperty(chrome, chrome_path);

        WebDriver chromeDriver_yantra = new ChromeDriver();
        WebDriver chromeDriver_steam = new ChromeDriver();
        chromeDriver_steam.get(url_steam_general);
        chromeDriver_yantra.get(url_yantra);

        System.out.println("chromeDriver_yantra.getTitle() = " + chromeDriver_yantra.getTitle());

        String url_catalog_plate = "https://yantrakeramika.ru/catalog/Tarelki/";
        chromeDriver_yantra.navigate().to(url_catalog_plate);
        System.out.println("chromeDriver_yantra.getTitle() = " + chromeDriver_yantra.getTitle());

//        chromeDriver.quit();

    }
}