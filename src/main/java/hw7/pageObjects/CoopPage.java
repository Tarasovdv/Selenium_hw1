package hw7.pageObjects;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CoopPage {
    private final String filterGamesButton = "//div[contains(text(),'Фильтры')]";
    private final String pointBorderButtonOnFilter = "//div[contains(text(),'%s')]";
    /**
     * Filter/point
     */
    private final String subparagraphOnPointBorderButtonOnFilter = pointBorderButtonOnFilter + "/following::a[contains(text(),'%s')]";
    /**
     * Filter/point/sub-paragraph
     */
    private final String dropdownBorderButtonOnFilter = "//div[text()='%s']/..//*[local-name()='svg']";
    private final String capsuleImageGameLink = "//div[contains(@class,'NO-IP')]//a//img[contains(@alt,\"%s\")]";
    private final String filterSectionFrame = "//div[@id = 'SaleSection_13268']";

    public CoopPage scrollFilterSectionFrame() {
        $x(filterSectionFrame).scrollTo()
                .should(visible, Duration.ofSeconds(5));
        return this;
    }

    public CoopPage clickFilterGamesButton() {
        $x(filterGamesButton).should(visible, Duration.ofSeconds(5))
                .click();
        return this;
    }

    public CoopPage clickSubparagraphOnPointBorderButtonOnFilter(String namePoint, String nameSubparagraph) {
        $x(String.format(subparagraphOnPointBorderButtonOnFilter, namePoint, nameSubparagraph))
                .should(visible, Duration.ofSeconds(5))
                .click();
        return this;
    }

    public CoopPage collapseSectionOnFilter(String namePoint) {
        $x(String.format(dropdownBorderButtonOnFilter, namePoint))
                .should(visible, Duration.ofSeconds(5))
                .click();
        return this;
    }

    public CoopPage clickPointBorderButtonOnFilter(String namePoint) {
        $x(String.format(pointBorderButtonOnFilter, namePoint))
                .should(visible, Duration.ofSeconds(5))
                .click();
        return this;
    }

    public CoopPage clickCapsuleImageGameLink(String nameGame) {
        $x(String.format(capsuleImageGameLink, nameGame))
                .should(visible, Duration.ofSeconds(5))
                .click();
        return this;
    }
}