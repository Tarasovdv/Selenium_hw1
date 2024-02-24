package hw7.pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GarrysModPage {
    private final String appName = "//div[@id = 'appHubAppName']";

    public String getTextAppName() {
        try {
            $x(appName).should(visible, Duration.ofSeconds(2));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("'Текстовое поле с названием игры' не найдено");
            throw noSuchElementException;
        }
        return $x(appName).getText();
    }
}