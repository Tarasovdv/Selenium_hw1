package seleniumHW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import static seleniumHW.Properties.readPropFile;
import static seleniumHW.Properties.selectParams;

public class Sandbox {
    public static void main(String[] args) {
        String propFile = "chrome.properties";
        String urlSteamGeneral = selectParams(readPropFile(propFile), "url.steam.general");
//        String urlYantra = selectParams(readPropFile(propFile), "url.yantra");

        WebDriver driver;
        driver = WebDriverManager.getInstance(selectParams(readPropFile(propFile), "browser.name")).create();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(urlSteamGeneral);


//        0. как предыдущие задачи, выписываем функции xPath, !оси xPath!, учим
//        1. в стиме берем кнопки и текст 'Категории'
//        2. внутри категории нажать на 'Приключенческая игра' возможно это не просто)
//        3. 5 любых элементов на выбор, нажимайте, берите текст, проверяйте на видимость, разные действия в контексте того, что знаем, ассерты пишем
//        друг другу пишем
//        4. пробуем использовать оси xPath
//        5. подготовить для коллег варианты задач по запросам xPath, без фанатизма
    }
}
