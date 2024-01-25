package seleniumHW;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static seleniumHW.ReadProperties.readPropFile;
import static seleniumHW.ReadProperties.selectParams;

public class WebDriverManagerPractice {
    public static void main(String[] args) {
        String propFile = "chrome.properties";
        String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
        String urlYantra = selectParams(readPropFile(propFile), "url.yantra");

        WebDriver driver;
        driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(urlYantra);
    }

}
