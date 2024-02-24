package hw7.pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

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

    public void scrollFilterSectionFrame() {
        try {
            $x(filterSectionFrame).scrollTo().should(visible, Duration.ofSeconds(2));
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Раздел с фильтром не найден");
            throw noSuchElementException;
        }
    }

    public void clickFilterGamesButton() {
        try {
            $x(filterGamesButton).should(visible, Duration.ofSeconds(1)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Кнопка 'Фильтры' не найдена");
            throw noSuchElementException;
        }
    }

    public void clickSubparagraphOnPointBorderButtonOnFilter(String namePoint, String nameSubparagraph) {
        try {
            $x(String.format(subparagraphOnPointBorderButtonOnFilter, namePoint, nameSubparagraph))
                    .should(visible, Duration.ofSeconds(1))
                    .click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.printf("Кнопка 'Фильтр'/'%s'/'%s' -> не найдена%n", namePoint, nameSubparagraph);
            throw noSuchElementException;
        }
    }

    public void collapseSectionOnFilter(String namePoint) {
        try {
            $x(String.format(dropdownBorderButtonOnFilter, namePoint))
                    .should(visible, Duration.ofSeconds(2))
                    .click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.printf("Кнопка 'Свернуть '%s' в разделе 'Фильтр' -> не найдена%n", namePoint);
            throw noSuchElementException;
        }
    }

    public void clickPointBorderButtonOnFilter(String namePoint) {
        try {
            $x(String.format(pointBorderButtonOnFilter, namePoint))
                    .should(visible, Duration.ofSeconds(1))
                    .click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.printf("Кнопка '%s'->'Фильтр' не найдена%n", namePoint);
            throw noSuchElementException;
        }
    }

    public void clickCapsuleImageGameLink(String nameGame) {
        try {
            $x(String.format(capsuleImageGameLink, nameGame))
                    .should(visible, Duration.ofSeconds(2))
                    .click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.printf("Кнопка игры '%s' не найдена%n", nameGame);
            throw noSuchElementException;
        }
    }
}