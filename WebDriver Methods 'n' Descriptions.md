#    WebDriver Chrome Methods

Загрузка и открытие страницы в окне браузера

        driver.get("https://yantrakeramika.ru/"); 

## QIUT; CLOSE

1. Завершает работу данного драйвера.Закрывая все связанные с ним окна.

`driver.quit();`

2. Закроет текущее окно, завершив работу браузера, если это последнее окно, открытое в данный момент.

`driver.close(); `

## getWindowHandle /...Handles

1. Возвращает ID страницы-окна в браузере, до закрытия сессии.( `quit();` `close();` )

        String parentWin = driver.getWindowHandle(); 
        
        System.out.println("parentWin = " + parentWin);

2. Возращает множество IDs страниц-окон в браузере.

        Set<String> windows = driver.getWindowHandles(); 
    
        System.out.println("windows = " + windows);

## NAVIGATE



1. `driver.navigate().back(); `

`navigate()` - Абстракция, позволяющая получить доступ к истории браузера и перейти по заданному URL-адресу.

`back()`- перемещение НАЗАД по истории браузера
2. `driver.navigate().forward();` 

`forward()`- перемещение ВПЕРЕД по истории браузера

3. `driver.navigate().refresh(); `

`refresh()`- обновление текущей страницы

4.      driver.navigate().to("https://yantrakeramika.ru/contact/");

открыть-перейти по URL в том же окне браузера

5.      String url_catalog_plate = "https://yantrakeramika.ru/catalog/Tarelki/";

        driver.navigate().to(url_catalog_plate); 

открыть-перейти по `String(url)` в том же окне браузера

## getPageSource

Возвращает данные страницы. код страницы

    String sourcePage = driver.getPageSource(); 
    System.out.println("sourcePage = " + sourcePage);

## MANAGE
### Cookies
1. `driver.manage().addCookie(Cookie cookie); `

`cookie`- The cookie to add. добавить куки. ????

2. `driver.manage().deleteCookie(Cookie cookie); `

Удалите файл cookie из "хранилища файлов cookie" браузера. ????

3. `driver.manage().deleteAllCookies(); `

Удалить все файлы cookie для текущего домена.

4. `driver.manage().deleteCookieNamed(String name);`

Удалите именованный файл cookie из текущего домена.

5.      Set<Cookie> domainCookies = driver.manage().getCookies(); 
    
        System.out.println("domainCookies = " + domainCookies);

Получите все файлы cookie для текущего домена.

6. `driver.manage().getCookieNamed(String name);`

Возвращает файл cookie или null, если файл cookie с заданным именем отсутствует

### Timeouts

`driver.manage().timeouts(). `

интерфейс для управления тайм-аутами драйверов.

У `timeouts()` - есть свои методы. Необходимо ознакомиться!!!

### Window

1. `driver.manage().window().fullscreen(); `

`window`- интерфейс по управлению окном.

`fullscreen()` - Полноэкранный режим.

2. `driver.manage().window().getSize();`

Получить размер текущего окна

3. `driver.manage().window().setSize(Dimension targetSize);`

Установить размер для текущего окна

4. `driver.manage().window().getPosition();`

Позиция текущего окна.

5. `driver.manage().window().setPosition(Point targetPosition);`

`targetPosition` - Целевое положение окна.

6. `driver.manage().window().maximize();`

Разворачивает текущее окно

7. `driver.manage().window().minimize();`

Сворачивает текущее окно

## TITLE

Заголовок текущей страницы

    String title = driver.getTitle();
        
    System.out.println("title = " + title);

## switchTo

1. `driver.switchTo().window(String nameOrHandle);`

`switchTo` - Отправляйте будущие команды в другой фрейм или окно.

`window()` - Переключите фокус будущих команд для этого драйвера на окно с заданным именем/дескриптором.

2. `driver.switchTo().alert(); `

Переключается на текущий активный модальный диалог для данного конкретного экземпляра драйвера. Возвращает Дескриптор диалогового окна.

### ALERT 

      изучить!!!!!




3. `driver.switchTo().defaultContent();`

Этот драйвер сосредоточился на верхнем окне/первой рамке.

4. `driver.switchTo().newWindow(WindowType typeHint);`

Создает новое окно браузера и переключает фокус для будущих команд этого драйвера на новое окно.

`WindowType typeHint` - тип нового окна

5. `driver.switchTo().frame(String nameOrId);`

Выбери рамку по его имени или идентификатору. Фокус драйвера на эту рамку.

6. `driver.switchTo().frame(WebElement frameElement);`

Выбери рамку, используя его ранее расположенный веб-элемент. Фокус драйвера на эту рамку.

7. `driver.switchTo().parentFrame(); `

Этот драйвер сфокусирован на родительском фрейме

## iFrame

https://www.selenium.dev/documentation/webdriver/interactions/frames/

## getLocation()

Метод getLocation() используется для определения местоположения элемента на веб-странице.

Объявление метода – Point getLocation();

Что он делает? – Он получит местоположение верхнего левого угла указанного вебэлемента.

Что он возвращает? – Он вернет объект Point, обозначающий местоположение элемента. Мы можем использовать метод getX() или getY(), предоставляемый классом Point, чтобы получить координаты x и y элемента.

Note: The location of any element on the webpage is calculated by considering the top left-hand corner of the webpage to be at (0,0) coordinates.

![img.png](img/fromMD/getLocation().png)

Now, let’s try to get the location of the 1st text field on this page using the getLocation() method. getLocation() will get the top left-hand point location of the specified web element.

![img_1.png](img/fromMD/getLocation()2.png)

As getLocation() returns a Point class object, we can use the getX() and getY() to get the x and y coordinates of the web element.

      import org.openqa.selenium.By;
      import org.openqa.selenium.Point;
      import org.openqa.selenium.WebDriver;
      import org.openqa.selenium.WebElement;
      import org.openqa.selenium.chrome.ChromeDriver;
      import org.testng.annotations.Test;
      
      public class CodekruTest {
      
          @Test
          public void test() {
       
              // pass the path of the chromedriver location in the second argument
              System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
              WebDriver driver = new ChromeDriver();
       
              // opening the url
              driver.get("https://testkru.com/Elements/TextFields");
       
              WebElement element = driver.findElement(By.id("firstName"));
       
              Point point = element.getLocation();
              System.out.println("x location: " + point.getX());
              System.out.println("y location: " + point.getY());
       
          }
      }

Output –

x location: 532

y location: 427

Similarly, we can find the location of any element on the webpage.

## What if we use the getLocation() method on a null WebElement?

We will get a NullPointerException as illustrated by the below program.


      public class CodekruTest {
      
          @Test
          public void test() {
       
              // pass the path of the chromedriver location in the second argument
              System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
              WebDriver driver = new ChromeDriver();
       
              // opening the url
              driver.get("https://testkru.com/Elements/TextFields");
       
              WebElement element = null;
              Point point = element.getLocation();
       
          }
      }

Output –

`java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebElement.getLocation()" because "element" is null`



