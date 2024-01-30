package sandbox;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// <<<<<<< JIRA-0001_description-of-the-methods-webdriver
// =======
import org.openqa.selenium.chrome.ChromeOptions;
// >>>>>>> master

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
// <<<<<<< JIRA-0001_description-of-the-methods-webdriver

//=======
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary(File path); Задает путь к исполняемому файлу Chrome. Этот путь должен существовать на компьютере, на котором будет запущен Chrome. Путь должен быть либо абсолютным, либо относительным к местоположению запущенного сервера ChromeDriver
//        options.setBinary(String path);
//        options.addArguments(String... arguments); аргументы - аргументы, которые будут использоваться при запуске Chrome.
//          options.addArguments(List<String> arguments); Добавляет дополнительные аргументы командной строки, которые будут использоваться при запуске Chrome. Например:
//        options.addArguments(
//                "load-extension=/path/to/unpacked_extension",
//                "allow-outdated-plugins");https:
//github.com/GoogleChrome/chrome-launcher/blob/main/docs/chrome-flags-for-tools.md
//        options.addExtensions(List<File> paths); Добавляет новое расширение Chrome для установки при запуске браузера. В каждом пути должно указываться упакованное расширение Chrome (CRX-файл).
//        options.addExtensions(File... paths);
//        options.addEncodedExtensions(String... encoded); encoded - данные устанавливаемых расширений, закодированные в Base64.
//        options.addEncodedExtensions(List<String> encoded); Добавляет новое расширение Chrome для установки при запуске браузера. В каждой строке данных должна указываться строка в кодировке Base64 упакованного расширения Chrome (CRX-файл).
//        options.setExperimentalOption(String name, Object value); Устанавливает экспериментальный параметр. Полезно для новых опций ChromeDriver, которые еще не доступны через ChromiumOptions API.
//                      name - Название экспериментальной опции.
//                      value - значение экспериментальной опции, которое должно быть преобразовано в JSON.

//        WebDriver driver = new ChromeDriver(options);
// >>>>>>> master
        WebDriver driver = new ChromeDriver();


//        1. WebDriver Chrome Methods
        driver.get("https://yantrakeramika.ru/"); // Загрузка и открытие страницы в окне браузера

        // QIUT / CLOSE
//        driver.quit(); // Завершает работу данного драйвера.Закрывая все связанные с ним окна.
//        driver.close(); // Закроет текущее окно, завершив работу браузера, если это последнее окно, открытое в данный момент.

        // getWindowHandle /...Handles
        String parentWin = driver.getWindowHandle(); //Возвращает ID страницы-окна в браузере, до закрытия сессии.( quit(); close(); )
        System.out.println("parentWin = " + parentWin);

        Set<String> windows = driver.getWindowHandles(); //Возращает множество IDs страниц-окон в браузере.
        System.out.println("windows = " + windows);

        // NAVIGATE
        driver.navigate().back(); // navigate()- Абстракция,позволяющая получить доступ к истории браузера и перейти по заданному URL-адресу.
        // back()- перемещение НАЗАД по истории браузера
        driver.navigate().forward(); // forward()- перемещение ВПЕРЕД по истории браузера
        driver.navigate().refresh(); // refresh()- обновление текущей страницы
        driver.navigate().to("https://yantrakeramika.ru/contact/"); // открыть-перейти по URL в том же окне браузера

        String url_catalog_plate = "https://yantrakeramika.ru/catalog/Tarelki/";
        driver.navigate().to(url_catalog_plate); // открыть-перейти по String(url) в том же окне браузера

        // getPageSource
//        String sourcePage = driver.getPageSource(); //Возвращает данные страницы. код страницы
//        System.out.println("sourcePage = " + sourcePage);

        // MANAGE
//        driver.manage().addCookie(Cookie cookie); //cookie-The cookie to add. добавить куки. ????
//        driver.manage().deleteCookie(Cookie cookie); //Удалите файл cookie из "хранилища файлов cookie" браузера. ????
//        driver.manage().deleteAllCookies(); //Удалить все файлы cookie для текущего домена.
//        driver.manage().deleteCookieNamed(String name); //Удалите именованный файл cookie из текущего домена.

//        Set<Cookie> domainCookies = driver.manage().getCookies(); // Получите все файлы cookie для текущего домена.
//        System.out.println("domainCookies = " + domainCookies);

//        driver.manage().getCookieNamed(String name); // Возвращает файл cookie или null, если файл cookie с заданным именем отсутствует
//        driver.manage().timeouts(). // интерфейс для управления тайм-аутами драйверов.
        driver.manage().window().fullscreen(); // window-интерфейс по управлению окном. Полноэкранный режим.
        driver.manage().window().getSize(); // Получить размер текущего окна
//        driver.manage().window().setSize(Dimension targetSize);// Установить размер для текущего окна
        driver.manage().window().getPosition(); // Позиция текущего окна.
//        driver.manage().window().setPosition(Point targetPosition); // targetPosition - Целевое положение окна.
        driver.manage().window().maximize(); // Разворачивает текущее окно
        driver.manage().window().minimize(); // Сворачивает текущее окно

        // TITLE
        String title = driver.getTitle(); // Заголовок текущей страницы
        System.out.println("title = " + title);

        // switchTo
//        driver.switchTo().window(String nameOrHandle); // switchTo-Отправляйте будущие команды в другой фрейм или окно.
        // window() - Переключите фокус будущих команд для этого драйвера на окно с заданным именем/дескриптором.
        driver.switchTo().alert(); // Переключается на текущий активный модальный диалог для данного конкретного экземпляра драйвера. Возвращает Дескриптор диалогового окна.
        driver.switchTo().defaultContent(); // Этот драйвер сосредоточился на верхнем окне/первой рамке.
//        driver.switchTo().newWindow(WindowType typeHint); //Создает новое окно браузера и переключает фокус для будущих команд этого драйвера на новое окно.
        // WindowType typeHint - тип нового окна
//        driver.switchTo().frame(String nameOrId); // Выбери рамку по его имени или идентификатору. Фокус драйвера на эту рамку.
//        driver.switchTo().frame(WebElement frameElement);// Выбери рамку, используя его ранее расположенный веб-элемент. Фокус драйвера на эту рамку.
        driver.switchTo().parentFrame(); // Этот драйвер сфокусирован на родительском фрейме

        driver.quit();

        //    public static void main(String[] args) throws IOException {
//
//        // Первый способ
//        File file = new File("src/main/resources/chrome.properties");
//        Properties props = new Properties();
//        props.load(new FileInputStream(file));
//        System.out.println("props.getProperty(\"webdriver.chrome.driver\") = " + props.getProperty("webdriver.chrome.driver"));
//
//        // Второй способ
//        ClassLoader classLoader = ReadProperties.class.getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("chrome.properties");
//
//        Properties props2 = new Properties();
//        props2.load(inputStream);
//        System.out.println("props2.getProperty(\"webdriver.chrome.driver\") = " + props2.getProperty("webdriver.chrome.driver"));
//    }


    }
}