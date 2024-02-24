package hw7.pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SteamMainPage {
    private final String storeNavAreaPoint = "//div[@id='store_nav_area']//a[@class='pulldown_desktop' and contains(text(), '%s')]";
    private final String subparagraphLinkButtonOnCategory = "//a[contains(text(),'%s')]";

    public void clickStoreNavAreaPoint(String namePoint) {
        try {
            $x(String.format(storeNavAreaPoint, namePoint)).should(visible, Duration.ofSeconds(2)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.printf("Кнопка '%s' -> не найдена%n", namePoint);
            throw noSuchElementException;
        }
    }

    public void clickSubparagraphLinkButtonOnCategory(String nameSubparagraph) {
        try {
            $x(String.format(subparagraphLinkButtonOnCategory, nameSubparagraph)).should(visible, Duration.ofSeconds(2)).click();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.printf("Кнопка 'Категории'/'%s' -> не найдена%n", nameSubparagraph);
            throw noSuchElementException;
        }
    }
}