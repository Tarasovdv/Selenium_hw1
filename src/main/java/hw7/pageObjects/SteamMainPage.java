package hw7.pageObjects;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SteamMainPage {
    private final String storeNavAreaPoint = "//div[@id='store_nav_area']//a[@class='pulldown_desktop' and contains(text(), '%s')]";
    private final String subparagraphLinkButtonOnCategory = "//a[contains(text(),'%s')]";

    public SteamMainPage clickStoreNavAreaPoint(String namePoint) {
        $x(String.format(storeNavAreaPoint, namePoint))
                .should(visible, Duration.ofSeconds(2))
                .click();
        return this;
    }

    public SteamMainPage clickSubparagraphLinkButtonOnCategory(String nameSubparagraph) {
        $x(String.format(subparagraphLinkButtonOnCategory, nameSubparagraph))
                .should(visible, Duration.ofSeconds(2))
                .click();
        return this;
    }
}