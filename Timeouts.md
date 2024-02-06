# Waiting Strategies

## Implicit waits

Selenium имеет встроенный способ автоматического ожидания элементов, называемый неявным ожиданием. 
Значение неявного ожидания может быть установлено либо с помощью функции тайм-аутов в настройках браузера, 
либо с помощью метода драйвера (как показано ниже).

Это глобальная настройка, которая применяется к каждому вызову определения местоположения элемента в течение всего сеанса. 
Значение по умолчанию равно 0, что означает, что если элемент не найден, он немедленно вернет сообщение об ошибке. 
Если задано неявное ожидание, драйвер будет ждать в течение заданного значения, прежде чем возвращать сообщение об ошибке. 
Обратите внимание, что как только элемент будет найден, драйвер вернет ссылку на элемент, и код продолжит выполнение, 
поэтому большее значение неявного ожидания не обязательно увеличит продолжительность сеанса.

Предупреждение: Не смешивайте неявное и явное ожидание. Это может привести к непредсказуемому времени ожидания. 
Например, установка неявного ожидания в 10 секунд и явного ожидания в 15 секунд может привести к тайм-ауту через 20 секунд.

Решение нашего примера с неявным ожиданием выглядит следующим образом:

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

## Explicit waits

Явные ожидания - это циклы, добавленные в код, которые запрашивают у приложения определенное условие для оценки как истинное, 
прежде чем оно выйдет из цикла и перейдет к следующей команде в коде. Если условие не будет выполнено до заданного значения тайм-аута, 
код выдаст ошибку тайм-аута. Поскольку существует множество способов, по которым приложение может не находиться в желаемом состоянии, 
явные ожидания - отличный выбор для указания точного условия ожидания в каждом необходимом месте. Еще одна приятная особенность заключается в том, 
что по умолчанию класс Selenium Wait автоматически ожидает существования указанного элемента.

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> revealed.isDisplayed());

### Customization

Класс Wait может быть создан с различными параметрами, которые изменят способ вычисления условий.

Это может включать в себя:

* Изменение частоты вычисления кода (интервал опроса)
* Указание того, какие исключения должны обрабатываться автоматически
* Изменение общей продолжительности тайм-аута
* Настройка сообщения о тайм-ауте

Например, если ошибка element not interactable повторяется по умолчанию, то мы можем добавить действие к методу внутри 
выполняемого кода (нам просто нужно убедиться, что код возвращает true при успешном выполнении).:

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


# Методы с примерами:

1. `timeoutException(String message, Throwable lastException):`  Этот метод выбрасывает исключение по таймауту.

2. `ignoreAll(Collection types):`                                Игнорирует все исключения, которые содержатся в переданной коллекции.

        ignoreAll(Collection types):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoreAll(Arrays.asList(NoSuchElementException.class, StaleElementReferenceException.class));
3. `ignoring(Class exceptionType):`                              Игнорирует конкретный тип исключения.

        ignoring(Class exceptionType):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoring(NoSuchElementException.class);
4. `pollingEvery(Duration duration):`                            Определяет частоту, с которой FluentWait должен проверять условия.

        pollingEvery(Duration duration):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(Duration.ofMillis(500));
5. `until(Function condition):`                                  Повторяет проверку условия, пока оно не станет истинным или пока не истечет время ожидания.

        until(Function condition):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element_id")));
6. `withMessage(String message):`                                Определяет сообщение, которое должно быть включено в исключение, если время ожидания истекло.

        withMessage(String message):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withMessage("Element was not found within the timeout");
7. `withTimeout(Duration duration):`                             Определяет максимальное время ожидания

        withTimeout(Duration duration):
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withTimeout(Duration.ofSeconds(30));