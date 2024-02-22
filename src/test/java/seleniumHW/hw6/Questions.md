# 1. Основные сущности в Selenium

Ответ: 

* WebDriver
* WebElement
* Locator

# 2. Каким образом можно инициализировать driver?

### WebDriver:

        System.setProperty(chrome, chromePath);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(urlYantra);

### WebDriverManager:

        WebDriver driver = WebDriverManager.getInstance("chrome").create();

# 3. Способы открыть страницу

### JS

    JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.open('https://button-one.ru/')");

интерфейс


### get()

    driver.get("https://store.steampowered.com/");

# 4. В чем разница close() / quit() ?

`close()` - Закроет текущее окно, завершив работу браузера, если это последнее окно, открытое в данный момент.

`quit()` - Завершает работу данного драйвера.Закрывая все связанные с ним окна.

# 5. Как сделать Screenshot?

    driver.switchTo().newWindow(WINDOW);
    driver.get(src);
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File("C:\\Users\\HANNYA\\IdeaProjects\\BUTTON-ONE\\Selenium_hw1\\src\\main\\resources\\scrn.png"));


# 6. Статический импорт

С помощью статического импорта мы можем обращаться к статическим членам класса напрямую, без имени класса или какого-либо объекта.

      // without static import
      class Geeks {
         public static void main(String[] args)
      {
            System.out.println(Math.sqrt(4));
            System.out.println(Math.pow(2, 2));
            System.out.println(Math.abs(6.3));
         }
      }


      // with static import
      class Geeks {
         public static void main(String[] args)
      {
            System.out.println(sqrt(4));
            System.out.println(pow(2, 2));
            System.out.println(abs(6.3));
         }
      }

# 7. проверить цвет элемента

Взять атрибут нашего элемента или (css value) вытащить код цвета и сравнить с ожидаемым.

`getCssValue("color")` - вызвать метод у нашего элемента

      @Test(description = "Тест на соответствие цвета элемента: Выпадающий список по кнопке 'Категории'")
      public static void categoryPullDownButtonGetColor() {
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      Assert.assertEquals(wait.until(visibilityOfElementLocated(By
         .xpath("//div//a[@class='pulldown_desktop' and text() = 'Категории']")))
         .getCssValue("color")
         , "rgba(229, 229, 229, 1)"
         , "Цвет Элемента не соответствует");
      }

выдаст цвет в виде строки типа: rgba(229, 229, 229, 1)

Цветовая схема RGB, На сайте схема может отличаться (HEX: #e5e5e5), можно перевести через конвектор

# 8. Клик

        driver.findElement(By.id("gbqfb")).click();
JS:

        WebElement element = driver.findElement(By.id("gbqfd"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

9. Expected Conditions - примеры конкретных

Ожидает появления определенного количества окон в браузере. ждет пока загрузится окно.

        static ExpectedCondition<Boolean>
        numberOfWindowsToBe(int expectedNumberOfWindows)

Ожидается, что URL текущей страницы будет определенным URL.

        static ExpectedCondition<Boolean>
        urlToBe(String url)

Ожидание для проверки того, что все элементы, присутствующие на веб-странице, которые соответствуют локатору, видны.

        static ExpectedCondition<List<WebElement>>
        visibilityOfAllElements(WebElement... elements)

Ожидание для проверки того, что все элементы, присутствующие на веб-странице, которые соответствуют локатору, видны.

        static ExpectedCondition<List<WebElement>>
        visibilityOfAllElementsLocatedBy(By locator)


10. Виды ожидания

    Implicit waits

Это глобальная настройка, которая применяется к каждому вызову определения местоположения элемента в течение всего сеанса. 
Значение по умолчанию равно 0, что означает, что если элемент не найден, он немедленно вернет сообщение об ошибке. 
Если задано неявное ожидание, драйвер будет ждать в течение заданного значения, прежде чем возвращать сообщение об ошибке.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

ОСОБЕННОСТИ:

/Работает для всех элементов

/ожидает только появления

/в любой момент можем поменять таймаут

/если по истечению таймаута не нашли элемент, то кидает ElementNotFoundEx...

Explicit waits

Явные ожидания - это циклы, добавленные в код, которые запрашивают у приложения определенное условие для оценки как истинное, 
прежде чем оно выйдет из цикла и перейдет к следующей команде в коде. 
Если условие не будет выполнено до заданного значения тайм-аута, код выдаст ошибку тайм-аута.

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

Customization

Класс Wait может быть создан с различными параметрами, которые изменят способ вычисления условий.

Это может включать в себя:

Изменение частоты вычисления кода (интервал опроса)
Указание того, какие исключения должны обрабатываться автоматически
Изменение общей продолжительности тайм-аута
Настройка сообщения о тайм-ауте
Например, если ошибка element not interactable повторяется по умолчанию, то мы можем добавить действие к методу внутри выполняемого кода (нам просто нужно убедиться, что код возвращает true при успешном выполнении).:

Самый простой способ настроить ожидания в Java - это использовать класс FluentWait:

    Wait<WebDriver> wait =
    new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(300))
    .ignoring(ElementNotInteractableException.class);
    
        wait.until(
            d -> {
              revealed.sendKeys("Displayed");
              return true;
            });

11. как проскролить Actions and JS

JS:
        private static void scrollJS(int scroll) {
        JavascriptExecutor js = (JavascriptExecutor) DRIVER_MANAGER.getDriver();
        js.executeScript("window.scrollBy(0, " + scroll + ");");
        }

Actions:

        private final Actions actionWithYourFrame = new Actions(DRIVER_MANAGER.getDriver());
        public void clickGamersBorderButtonOnFilterParam() {
        try {
        actionWithYourFrame.scrollToElement(wait.until(visibilityOfElementLocated(gamersBorderButtonOnFilterParam))).build().perform();
        } catch (NoSuchElementException noSuchElementException) {
        System.err.println("Кнопка 'Игроки'->'Фильтр' не найдена");
        throw noSuchElementException;
        }
        }

12. `release():`                                                      
Отпускает текущее удерживание клавиши или мыши.

13. `moveToElement(WebElement target):`                               
Перемещает указатель к центру указанного элемента.

14. `contextClick():`                                                
Выполняет контекстное (правой кнопкой мыши) меню в текущей позиции указателя.

15. как очистить строку 
`clear`

16. как понять что наш лого в верхнем левом углу 

`getLocation` у элемента, `getSize`, `getPozition` 

        driver.manage().window().getSize();

17. как проверить скачался ли файл при выполнении теста? 
по пути куда сохраняем, и с помощью теста мы проверяем методом Exist Files 
путь прописываем в опшенсах при инит драйвера
    Override default download folder:

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePref = new HashMap<>();
        chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
        options.setExperimentalOption("prefs", chromePref);
        WebDriver driver = new ChromeDriver(options);


        WebDriverWait wait = new WebDriverWait(driver, 5);
        String tmpFolderPath = System.getProperty("java.io.tmpdir");
        String expectedFileName = "Some_file_name.ext";
        File file = new File(tmpFolderPath + expectedFileName);
        if (file.exists())
        file.delete();
        wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());

18. какие элементы Selenium считает невидимыми
если у элемента или родителя установлены `display:non` и `visibility:`

19. как проверить видимость эл-та 
`isDisplayed`

20. оси xPath

21. какой локатор лучше?

22. в чем отличие xPath 
есть оси. можно двигаться по осям вверх и вниз 

23. типы локаторов

* 1/ class name -Locates elements whose class name contains the search value (compound class names are not permitted)
    
* 2/css selector -Locates elements matching a CSS selector

* 3/id -Locates elements whose ID attribute matches the search value
    
* 4/name -Locates elements whose NAME attribute matches the search value
    
* 5/link text -Locates anchor elements whose visible text matches the search value
    
* 6/partial link text -Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.
    
* 7/tag name -Locates elements whose tag name matches the search value
    
* 8/xpath -Locates elements matching an XPath expression

24. классы НЕпроверяемых исключений Exeptions повторить
25. что такое Selenium?

26. рассказать про сущности Selenium
driver - управление браузером, весь тест завязан на драйвере
element -  елементы на странице сайта
locator - указатель на элемент . класс-By .   абстракция над локатором
27. как долго действует Неявное ожидание по отношению к экземпляру класса
драйвер. до тех пор пока не закроем драйвер
28. переключить на другое окно swichTo().window(.....)  
29. получить данные страницы HTML
getPageSource
getAttribute*
JS
30. установить директорию загрузки
options experimental
31. явные и неявные ожидания вместе можно ли 
32. transient
33. StaleElementReferenceException - ссылка на устаревший элемент
34. ALERT
35. iFrame
36. открывается долго страничка, что делать, ведь дальнейшее тестирование переходит туда.
    numberOfWindowsToBe(int expectedNumberOfWindows) ДЗ сделать
37. @DataProvider: Обозначает метод, который предоставляет данные для тестовых методов.
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
    // Код, предоставляющий данные для тестовых методов
    }
38. Тестировать конструктор как?
    Создать экземпляр, объект, принять параметры, и сверить
    reflectionApi
39. 100% покрытие unit тестами не гарантирует работоспособность продукта почему?
40. иерархия аннотаций тестНГ
41. почему нельзя возвращать NULL
42. Array от List отличия
43. неразрывный пробел Alt+0160 (&nbsp)
44. normilize-space 