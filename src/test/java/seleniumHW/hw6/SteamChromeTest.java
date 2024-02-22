package seleniumHW.hw6;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import seleniumHW.hw6.pageObjects.CoopPage;
import seleniumHW.hw6.pageObjects.GarrysModPage;
import seleniumHW.hw6.pageObjects.SteamMainPage;

import java.util.ArrayList;

import static seleniumHW.hw6.utils.Properties.readPropFile;
import static seleniumHW.hw6.utils.Properties.selectParams;
import static seleniumHW.hw6.utils.SingletonDriver.DRIVER_MANAGER;

public class SteamChromeTest {
    private static final String PROP_FILE = "chrome.properties";
    private static final String URL_STEAM_GENERAL = selectParams(readPropFile(PROP_FILE), "url.steam.general");

    @AfterTest
    public void quitDriver() {
        DRIVER_MANAGER.getDriver().quit();
    }

    @Test(description = "Тестирование корректного перехода на страницу ИГРЫ по пути:\" " +
            "            \" Главная страница/Категории/Кооперативы/С наивысшим рейтингом\" +\n" +
            "            \"/Фильтры:Основные жанры-Казуальная игра/Игроки-кооператив")
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        DRIVER_MANAGER.getDriver().manage().window().maximize();
        DRIVER_MANAGER.getDriver().get(URL_STEAM_GENERAL);
        Assert.assertEquals(DRIVER_MANAGER.getDriver()
                .getCurrentUrl(), URL_STEAM_GENERAL, "Opening the wrong site page");

        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.clickCategoryPulldownDesktopButton();
        steamMainPage.clickCooperativesLinkButton();

        CoopPage coopPage = new CoopPage();
        coopPage.scrollingFilterSectionFrame();
        coopPage.clickFilterGamesButton();
        coopPage.clickCasualGameButtonOnMainGenreOnFilterParam();
        coopPage.collapseSectionMainGenreOnFilterParam();
        coopPage.clickGamersBorderButtonOnFilterParam();
        coopPage.clickCooperativesButtonOnGamersOnFilterParam();
        coopPage.clickCapsuleImageGameLink();

        ArrayList<String> tabs = new ArrayList<>(DRIVER_MANAGER.getDriver().getWindowHandles());
        DRIVER_MANAGER.getDriver().switchTo().window(tabs.get(1));

        GarrysModPage garrysModPage = new GarrysModPage();
        Assert.assertEquals(garrysModPage.getTextAppName()
                , "Garry's Mod"
                , "Произведен некорректный выбор игры");
    }

    private static void scrollJS(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) DRIVER_MANAGER.getDriver();
        js.executeScript("window.scrollBy(0, " + scroll + ");");
    }
}