package seleniumHW.hw6;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import seleniumHW.hw6.pageObjects.CoopPage;
import seleniumHW.hw6.pageObjects.GarrysModPage;
import seleniumHW.hw6.pageObjects.SteamMainPage;

import java.util.ArrayList;

import static seleniumHW.hw6.utils.SingletonDriver.MANAGER_DRIVER;

public class SteamChromeTest {
    @AfterTest
    public void quitDriver() {
        MANAGER_DRIVER.getDriver().quit();
    }

    @Test(description = "Тестирование корректного перехода на страницу ИГРЫ по пути:\" " +
            "            \" Главная страница/Категории/Кооперативы/С наивысшим рейтингом\" +\n" +
            "            \"/Фильтры:Основные жанры-Казуальная игра/Игроки-кооператив")
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        MANAGER_DRIVER.getDriver().manage().window().maximize();
        SteamMainPage.goToMainPage();
        Assert.assertEquals(MANAGER_DRIVER.getDriver()
                .getCurrentUrl(), "https://store.steampowered.com/", "Opening the wrong site page");
        SteamMainPage steamMainPage = new SteamMainPage();
        CoopPage coopPage = new CoopPage();
        GarrysModPage garrysModPage = new GarrysModPage();
        steamMainPage.clickCategoryPulldownDesktopButton();
        steamMainPage.clickCooperativesLinkButton();
        scrollJS(1890);
        coopPage.clickFilterGamesButton();
        coopPage.clickCasualGameButtonOnMainGenreOnFilterParam();
        coopPage.collapseSectionMainGenreOnFilterParam();
        coopPage.clickGamersBorderButtonOnFilterParam();
        coopPage.clickCooperativesButtonOnGamersOnFilterParam();
        coopPage.clickCapsuleImageGameLink();
        ArrayList<String> tabs = new ArrayList<>(MANAGER_DRIVER.getDriver().getWindowHandles());
        MANAGER_DRIVER.getDriver().switchTo().window(tabs.get(1));
        Assert.assertEquals(garrysModPage.getTextAppName()
                , "Garry's Mod"
                , "Произведен некорректный выбор игры");
    }

    private static void scrollJS(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) MANAGER_DRIVER.getDriver();
        js.executeScript("window.scrollBy(0, " + scroll + ");");
    }
}