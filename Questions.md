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


6. статический импорт


7. проверить цвет элемента
взять атрибут нашего элемента или (css value) вытащить код цвета и сравнить с ожидаемым. Сделать проверку: ДЗ
   withTheHighestRatingParameterButton.getCssValue("color") = rgba(255, 255, 255, 1)


8. Клик

9. Expected Conditions - примеры конкретных

10. Виды ожидания


11. как проскролить Actions and JS
12. `release():`                                                      Отпускает текущее удерживание клавиши или мыши.
13. * `moveToElement(WebElement target):`                               Перемещает указатель к центру указанного элемента.

14. * `contextClick():`                                                Выполняет контекстное (правой кнопкой мыши) меню в текущей позиции указателя.
15. как очистить строку clear
16. как понять что наш лого в верхнем левом углу getLocation у элемента getSize, getPozition 
driver.manage().window().getSize();
17. как проверить скачался ли файл при выполнении теста? 
по пути куда сохраняем, и с помощью теста мы проверяем методом Exist Files 
путь прописываем в опшенсах при инит драйвера
18. какие элементы Selenium считает невидимыми
если у элемента или родителя установлены display-non и visibility...
19. как проверить видимость эл-та
20. оси xPath
21. какой локатор лучше?
22. в чем отличие xPath есть оси. можно двигаться по осям вверх и вниз 
23. типы локаторов
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