# Class ExpectedConditions

0.      static ExpectedCondition<Alert>
             alertIsPresent()

1.      static ExpectedCondition<Boolean> 
            and(ExpectedCondition<?>... conditions)

Математическое ожидание с логическим условием `и` из данного списка условий.

2.      static ExpectedCondition<Boolean> 
            attributeContains(By locator, String attribute, String value)

Ожидание проверки WebElement с заданным локатором имеет атрибут, который содержит определенное значение

3.      static ExpectedCondition<Boolean> 
            attributeContains(WebElement element, String attribute, String value)

Ожидание проверки WebElement с заданным локатором имеет атрибут, который содержит определенное значение

4.      static ExpectedCondition<Boolean> 
            attributeToBe(By locator, String attribute, String value)

Ожидание проверки WebElement с заданным локатором имеет атрибут с определенным значением

5.      static ExpectedCondition<Boolean>
            attributeToBe(WebElement element, String attribute, String value)
Ожидание проверки данного WebElement имеет атрибут с определенным значением

6.      static ExpectedCondition<Boolean> 
            attributeToBeNotEmpty(WebElement element, String attribute)
Ожидание проверки WebElement любого непустого значения для данного атрибута

7.      static ExpectedCondition<Boolean>
            domAttributeToBe(WebElement element, String attribute, String value)
Ожидание проверки данного WebElement имеет атрибут DOM с определенным значением

8.      static ExpectedCondition<Boolean>
            domPropertyToBe(WebElement element, String property, String value)
Ожидание проверки данного WebElement имеет свойство DOM с определенным значением

9.      static ExpectedCondition<Boolean>
            elementSelectionStateToBe(By locator, boolean selected)

Ожидаемое значение для проверки, выбран ли данный элемент.

10.         static ExpectedCondition<WebElement>
                elementToBeClickable(By locator)
Ожидание проверки элемента отображается и включено таким образом, что вы можете щелкнуть по нему.

11.     static ExpectedCondition<WebElement>
            elementToBeClickable(WebElement element)
Ожидание проверки элемента отображается и включено таким образом, что вы можете щелкнуть по нему.

12.      static ExpectedCondition<Boolean>
            elementToBeSelected(By locator)
Ожидаемое значение для проверки, выбран ли данный элемент.

13.     static ExpectedCondition<WebDriver>
            frameToBeAvailableAndSwitchToIt(int frameLocator)
Ожидание для проверки того, доступен ли данный фрейм для переключения.

14.     static ExpectedCondition<WebDriver>
            frameToBeAvailableAndSwitchToIt(String frameLocator)
Ожидание для проверки того, доступен ли данный фрейм для переключения.

15.     static ExpectedCondition<WebDriver>
            frameToBeAvailableAndSwitchToIt(By locator)
Ожидание для проверки того, доступен ли данный фрейм для переключения.

16.     static ExpectedCondition<WebDriver>
            frameToBeAvailableAndSwitchToIt(WebElement frameLocator)
Ожидание для проверки того, доступен ли данный фрейм для переключения.

17.     static ExpectedCondition<Boolean>
            invisibilityOf(WebElement element)
Ожидание проверки того, что элемент невидим

18.     static ExpectedCondition<Boolean>
            invisibilityOfAllElements(List<WebElement> elements)
Ожидание проверки того, что все элементы из данного списка будут невидимыми

19.     static ExpectedCondition<Boolean>
            invisibilityOfAllElements(WebElement... elements)
Ожидание проверки того, что все элементы из данного списка будут невидимыми

20.     static ExpectedCondition<Boolean>
            invisibilityOfElementLocated(By locator)
Ожидание для проверки того, что элемент либо невидим, либо отсутствует в DOM.

21.     static ExpectedCondition<Boolean>
            invisibilityOfElementWithText(By locator, String text)
Ожидание для проверки того, что элемент с текстом либо невидим, либо отсутствует в DOM.

22.     static ExpectedCondition<Boolean>
            javaScriptThrowsNoExceptions(String javaScript)
Ожидание для проверки, является ли js исполняемым.

23.     static ExpectedCondition<Object>
            jsReturnsValue(String javaScript)
Ожидаемое значение строки из javascript

24.     static ExpectedCondition<Boolean>
            not(ExpectedCondition<?> condition)
Ожидание с логическим условием, противоположным данному условию.

25.     static ExpectedCondition<List<WebElement>>
            numberOfElementsToBe(By locator, Integer number)
Ожидаемое значение для проверки количества WebElements с заданным локатором

26.     static ExpectedCondition<List<WebElement>>
            numberOfElementsToBeLessThan(By locator, Integer number)
Ожидаемое количество проверок WebElements с заданным локатором меньше определенного числа

27.     static ExpectedCondition<List<WebElement>>
            numberOfElementsToBeMoreThan(By locator, Integer number)
Ожидаемое количество проверок WebElements с заданным локатором больше определенного числа

28.     static ExpectedCondition<Boolean>
            numberOfWindowsToBe(int expectedNumberOfWindows)

29.     static ExpectedCondition<Boolean>or(ExpectedCondition<?>... conditions)
Математическое ожидание с логическим условием или из данного списка условий.

30.     static ExpectedCondition<List<WebElement>>
            presenceOfAllElementsLocatedBy(By locator)
Ожидание для проверки наличия хотя бы одного элемента на веб-странице.

31.     static ExpectedCondition<WebElement>
            presenceOfElementLocated(By locator)
    Ожидание для проверки присутствия элемента в DOM страницы.
    
32.     static ExpectedCondition<WebElement>
            presenceOfNestedElementLocatedBy(By locator, By childLocator)
    Ожидание проверки дочернего WebElement как части родительского элемента для представления
    
33.     static ExpectedCondition<WebElement>
            presenceOfNestedElementLocatedBy(WebElement element, By childLocator)
    Ожидается, что дочерний WebElement будет проверяться как часть родительского элемента
    
34.     static ExpectedCondition<List<WebElement>>
            presenceOfNestedElementsLocatedBy(By parent, By childLocator)
    Ожидание проверки дочернего WebElement как части родительского элемента для представления
    
35.     static <T> ExpectedCondition<T>
            refreshed(ExpectedCondition<T> condition)
    Оболочка для условия, которая позволяет обновлять элементы путем перерисовки.
    
36.     static ExpectedCondition<Boolean>
            stalenessOf(WebElement element)
    Подождите, пока элемент больше не будет присоединен к DOM.
    
37.     static ExpectedCondition<Boolean>
            textMatches(By locator, Pattern pattern)
    Ожидание проверки WebElement с заданным локатором содержит текст со значением в качестве его части
    
38.     static ExpectedCondition<Boolean>
            textToBe(By locator, String value)
    Ожидание проверки WebElement с заданным локатором имеет определенный текст
    
39.     static ExpectedCondition<Boolean>
            textToBePresentInElement(WebElement element, String text)
    Ожидание для проверки, присутствует ли данный текст в указанном элементе.
    
40.     static ExpectedCondition<Boolean>
            textToBePresentInElementLocated(By locator, String text)
    Ожидание для проверки, присутствует ли данный текст в элементе, который соответствует данному локатору.
    
41.     static ExpectedCondition<Boolean>
            textToBePresentInElementValue(By locator, String text)
    Ожидание для проверки, присутствует ли данный текст в указанном атрибуте elements value.
    
42.     static ExpectedCondition<Boolean>
            textToBePresentInElementValue(WebElement element, String text)
    Ожидание для проверки, присутствует ли данный текст в указанном атрибуте elements value.
    
43.     static ExpectedCondition<Boolean>
            titleContains(String title)
    Ожидание для проверки того, что заголовок содержит подстроку с учетом регистра
    
44.     static ExpectedCondition<Boolean>
            titleIs(String title)
    Ожидание проверки заголовка страницы.
    
45.     static ExpectedCondition<Boolean>
            urlContains(String fraction)
    Ожидается, что URL текущей страницы будет содержать определенный текст.
    
46.     static ExpectedCondition<Boolean>
            urlMatches(String regex)
    Ожидается, что URL-адрес будет соответствовать определенному регулярному выражению
    
47.     static ExpectedCondition<Boolean>
            urlToBe(String url)
    Ожидается, что URL текущей страницы будет определенным URL.
    
48.     static ExpectedCondition<WebElement>
            visibilityOf(WebElement element)
    Ожидание проверки того, что элемент, о котором известно, что он присутствует в DOM страницы, виден.
    
49.     static ExpectedCondition<List<WebElement>>
            visibilityOfAllElements(List<WebElement> elements)
    Ожидание для проверки того, что все элементы, присутствующие на веб-странице, которые соответствуют локатору, видны.
    
50.     static ExpectedCondition<List<WebElement>>
            visibilityOfAllElements(WebElement... elements)
    Ожидание для проверки того, что все элементы, присутствующие на веб-странице, которые соответствуют локатору, видны.
    
51.     static ExpectedCondition<List<WebElement>>
            visibilityOfAllElementsLocatedBy(By locator)
    Ожидание для проверки того, что все элементы, присутствующие на веб-странице, которые соответствуют локатору, видны.
    
52.     static ExpectedCondition<WebElement>
            visibilityOfElementLocated(By locator)
    Ожидание для проверки того, что элемент присутствует в DOM страницы и виден.
    
53.     static ExpectedCondition<List<WebElement>>
            visibilityOfNestedElementsLocatedBy(By parent, By childLocator)
    Ожидается, что дочерний WebElement будет проверен как часть родительского элемента, чтобы быть видимым
    
54.     static ExpectedCondition<List<WebElement>>
            visibilityOfNestedElementsLocatedBy(WebElement element, By childLocator)
    Ожидается, что дочерний WebElement будет проверен как часть родительского элемента, чтобы быть видимым