package seleniumHW.hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static seleniumHW.hw6.SingletonDriver.getDriver;


public class SteamMainPage {
//    private static WebDriver driver = getDriver();
    private static final WebDriverWait WAIT = new WebDriverWait(getDriver(), Duration.ofSeconds(2));


    private final By categoryTextElementAtBottomPage = By.xpath("//div[contains(@class,'content_hub_carousel')]/div[@class='title']");
    private final By categoryTextElementOnLeftSidePage = By.xpath("//div[text() = 'Рекомендуется']/following::div[@class='gutter_header pad' and text() = 'Категории']");
    private final By categoryPullDownButton = By.xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']");
    private final By adventureGameLinkButton = By.xpath("//a[contains(text(),'Приключенческая игра')]");
    private final By categoriesButtonTopMenuDesktop = By.xpath("//img[@alt = 'Goat Simulator 3']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']");

    public Boolean visibilityCategoryTextElementAtBottomPage() {
        return WAIT.until(visibilityOfElementLocated(categoryTextElementAtBottomPage))
                .isDisplayed();
    }

    public Boolean visibilityCategoryTextElementOnLeftSidePage() {
        return WAIT.until(visibilityOfElementLocated(categoryTextElementOnLeftSidePage))
                .isDisplayed();
    }

    public Boolean visibilityCategoryPullDownButton() {
        return WAIT.until(visibilityOfElementLocated(categoryPullDownButton))
                .isDisplayed();
    }

    public void clickCategoryPullDownButton() {
        WAIT.until(visibilityOfElementLocated(categoryPullDownButton))
                .click();
    }

    public String adventureGameLinkButtonGetText() {
        return WAIT.until(visibilityOfElementLocated(adventureGameLinkButton))
                .getText();
    }

    public Boolean visibilityCategoriesButtonTopMenuDesktop() {
        return WAIT.until(visibilityOfElementLocated(categoriesButtonTopMenuDesktop))
                .isDisplayed();
    }
    public String categoriesButtonTopMenuDesktopGetText() {
        return WAIT.until(visibilityOfElementLocated(categoriesButtonTopMenuDesktop))
                .getText();
    }

}
