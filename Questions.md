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


