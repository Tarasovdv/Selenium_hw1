package hw7.pageObjects;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GarrysModPage {
    private final String appName = "//div[@id = 'appHubAppName']";

    public String getTextAppName() {
        return $x(appName).scrollTo()
                .should(visible, Duration.ofSeconds(5))
                .getText();
    }
}