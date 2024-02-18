package seleniumHW.hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class SingletonDriver {
    private static final String PROP_FILE = "chrome.properties";
    private static WebDriver driver;

    private SingletonDriver() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverManager.getInstance(selectParams(readPropFile(PROP_FILE), "browser.name")).create();
        }
        return driver;
    }
}

