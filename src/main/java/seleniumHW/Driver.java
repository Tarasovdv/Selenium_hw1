package seleniumHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// <<<<<<< JIRA-0004-TestNG
// import static seleniumHW.Properties.*;

// public class Driver {

//     public static void main(String[] args) {
// =======
// import java.io.IOException;

// import static seleniumHW.ReadProperties.*;

// public class Driver {

//     public static void main(String[] args) throws IOException {
// >>>>>>> master

//        Properties File Name
        String propFile = "chrome.properties";

//        CHROME PARAMS
//         String chrome = selectParams(readPropFile(propFile), "chrome");
// <<<<<<< JIRA-0004-TestNG
//         String chromePath = selectParams(readPropFile(propFile), "chrome.path");

// //        URLs
// //        String urlSteam = selectParams(readPropFile(propFile), "url.steam.general");
//         String urlYantra = selectParams(readPropFile(propFile), "url.yantra");
//         String urlCatalogPlate = "https://yantrakeramika.ru/catalog/Tarelki/";

//         System.setProperty(chrome, chromePath);
//         WebDriver chromeDriver = new ChromeDriver();

//         chromeDriver.get(urlYantra);
//         System.out.println("chromeDriver.getTitle() = " + chromeDriver.getTitle());

//         chromeDriver.navigate().to(urlCatalogPlate);
//         System.out.println("chromeDriver.getTitle() = " + chromeDriver.getTitle());
// =======
//         String chrome_path = selectParams(readPropFile(propFile), "chrome_path");

// //        URLs
//         String url_steam_general = selectParams(readPropFile(propFile), "url_steam_general");
//         String url_yantra = selectParams(readPropFile(propFile), "url_yantra");

//         System.setProperty(chrome, chrome_path);

//         WebDriver chromeDriver = new ChromeDriver();
//         chromeDriver.get(url_steam_general);
//         chromeDriver.get(url_yantra);
// >>>>>>> master

        chromeDriver.quit();
    }
}