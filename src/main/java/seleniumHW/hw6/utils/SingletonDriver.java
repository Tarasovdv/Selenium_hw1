package seleniumHW.hw6.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static seleniumHW.hw6.utils.Properties.readPropFile;
import static seleniumHW.hw6.utils.Properties.selectParams;


public enum SingletonDriver {
    DRIVER_MANAGER;
    private static final String PROP_FILE = "chrome.properties";
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverManager.getInstance(selectParams(readPropFile(PROP_FILE), "browser.name")).create();
        }
        return driver;
    }
}

