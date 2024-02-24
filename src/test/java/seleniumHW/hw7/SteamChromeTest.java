package seleniumHW.hw7;

import hw7.pageObjects.CoopPage;
import hw7.pageObjects.GarrysModPage;
import hw7.pageObjects.SteamMainPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static hw7.utils.Properties.readPropFile;
import static hw7.utils.Properties.selectParams;

public class SteamChromeTest {
    private static final String PROP_FILE = "chrome.properties";
    private static final String URL_STEAM_GENERAL = selectParams(readPropFile(PROP_FILE), "url.steam.general");

    @AfterTest
    public void quitDriver() {
        getWebDriver().quit();
    }

    @Test(description = "Тестирование корректного перехода на страницу ИГРЫ по пути:\" " + "            \" Главная страница/Категории/Кооперативы/С наивысшим рейтингом\" +\n" + "            \"/Фильтры:Основные жанры-Казуальная игра/Игроки-кооператив")
    public void checkingCorrectProductDisplayWithFilterParametersCooperative() {
        open(URL_STEAM_GENERAL);
        getWebDriver().manage().window().maximize();
        Assert.assertEquals(getWebDriver().getCurrentUrl(), URL_STEAM_GENERAL, "Opening the wrong site page");

        SteamMainPage steamMainPage = new SteamMainPage();
        steamMainPage.clickStoreNavAreaPoint("Категории");
        steamMainPage.clickSubparagraphLinkButtonOnCategory("Кооперативы");

        CoopPage coopPage = new CoopPage();
        coopPage.scrollFilterSectionFrame();
        coopPage.clickFilterGamesButton();
        coopPage.clickSubparagraphOnPointBorderButtonOnFilter("Основные жанры", "Казуальная игра");
        coopPage.collapseSectionOnFilter("Основные жанры");
        coopPage.clickPointBorderButtonOnFilter("Игроки");
        coopPage.clickSubparagraphOnPointBorderButtonOnFilter("Игроки", "Кооператив");
        coopPage.clickCapsuleImageGameLink("Garry's Mod");

        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));

        GarrysModPage garrysModPage = new GarrysModPage();
        Assert.assertEquals(garrysModPage.getTextAppName(), "Garry's Mod", "Произведен некорректный выбор игры");
    }
}