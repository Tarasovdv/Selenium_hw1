# Keyboard actions

## Designated Element

    new Actions(driver)
    .sendKeys(textField, "Selenium!")
    .perform();

Example:

    @Test
    public void sendKeysToDesignatedElement() {
    driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");
    driver.findElement(By.tagName("body")).click();
    
            WebElement textField = driver.findElement(By.id("textInput"));
            new Actions(driver)
                    .sendKeys(textField, "Selenium!")
                    .perform();
    
            Assertions.assertEquals("Selenium!", textField.getAttribute("value"));
        }

## Mouse actions

### Click and hold

This method combines moving the mouse to the center of an element with pressing the left mouse button. This is useful for focusing a specific element:

        WebElement clickable = driver.findElement(By.id("clickable"));
        new Actions(driver)
        .clickAndHold(clickable)
        .perform();

Example:

    @Test
    public void clickAndHold() {
    driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
    
            WebElement clickable = driver.findElement(By.id("clickable"));
            new Actions(driver)
                    .clickAndHold(clickable)
                    .perform();
    
            Assertions.assertEquals("focused", driver.findElement(By.id("click-status")).getText());
        }

### Click and release

This method combines moving to the center of an element with pressing and releasing the left mouse button. This is otherwise known as “clicking”:

        WebElement clickable = driver.findElement(By.id("click"));
        new Actions(driver)
        .click(clickable)
        .perform();

## Alternate Button Clicks

There are a total of 5 defined buttons for a Mouse:

0 — Left Button (the default)

1 — Middle Button (currently unsupported)

2 — Right Button

3 — X1 (Back) Button

4 — X2 (Forward) Button

### Context Click 

This method combines moving to the center of an element with pressing and releasing the right mouse button (button 2). This is otherwise known as “right-clicking”:

    WebElement clickable = driver.findElement(By.id("clickable"));
    new Actions(driver)
    .contextClick(clickable)
    .perform();

### Back Click

There is no convenience method for this, it is just pressing and releasing mouse button 3

    PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerDown(PointerInput.MouseButton.BACK.asArg()))
                .addAction(mouse.createPointerUp(PointerInput.MouseButton.BACK.asArg()));

        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));

### Forward Click

There is no convenience method for this, it is just pressing and releasing mouse button 4

    PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerDown(PointerInput.MouseButton.FORWARD.asArg()))
                .addAction(mouse.createPointerUp(PointerInput.MouseButton.FORWARD.asArg()));

        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));

## Double click

This method combines moving to the center of an element with pressing and releasing the left mouse button twice.

    WebElement clickable = driver.findElement(By.id("clickable"));
    new Actions(driver)
    .doubleClick(clickable)
    .perform();

## Move to element

This method moves the mouse to the in-view center point of the element. This is otherwise known as “hovering.” Note that the element must be in the viewport or else the command will error.

    WebElement hoverable = driver.findElement(By.id("hover"));
    new Actions(driver)
    .moveToElement(hoverable)
    .perform();

## Move by offset

These methods first move the mouse to the designated origin and then by the number of pixels in the provided offset. Note that the position of the mouse must be in the viewport or else the command will error.

### Offset from Element 

This method moves the mouse to the in-view center point of the element, then moves by the provided offset.

    WebElement tracker = driver.findElement(By.id("mouse-tracker"));
    new Actions(driver)
    .moveToElement(tracker, 8, 0)
    .perform();

### Offset from Viewport

This method moves the mouse from the upper left corner of the current viewport by the provided offset.

    PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 8, 12));

        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));


### Offset from Current Pointer Location

This method moves the mouse from its current position by the offset provided by the user. 
If the mouse has not previously been moved, the position will be in the upper left corner of the viewport. 
Note that the pointer position does not change when the page is scrolled.

Note that the first argument X specifies to move right when positive, while the second argument Y specifies to move down when positive. 
So moveByOffset(30, -10) moves right 30 and up 10 from the current mouse position.

    new Actions(driver)
    .moveByOffset(13, 15)
    .perform();

## Drag and Drop on Element

This method firstly performs a click-and-hold on the source element, moves to the location of the target element and then releases the mouse.

    WebElement draggable = driver.findElement(By.id("draggable"));
    WebElement droppable = driver.findElement(By.id("droppable"));
    new Actions(driver)
    .dragAndDrop(draggable, droppable)
    .perform();

## Drag and Drop by Offset

This method firstly performs a click-and-hold on the source element, moves to the given offset and then releases the mouse.

    WebElement draggable = driver.findElement(By.id("draggable"));
    Rectangle start = draggable.getRect();
    Rectangle finish = driver.findElement(By.id("droppable")).getRect();
    new Actions(driver)
    .dragAndDropBy(draggable, finish.getX() - start.getX(), finish.getY() - start.getY())
    .perform();

# Сжатый список методов:

* `build():`                                                        Метод создает и возвращает действие (Action), которое можно использовать для построения последовательности действий.
* `click():`                                                       Выполняет клик левой кнопкой мыши в текущей позиции указателя.
* `click(WebElement target):`                                    Выполняет клик левой кнопкой мыши по указанному элементу.
* `clickAndHold():`                                                Нажимает и удерживает левую кнопку мыши.
* `clickAndHold(WebElement target):`                               Нажимает и удерживает левую кнопку мыши на указанном элементе.
* `contextClick():`                                                Выполняет контекстное (правой кнопкой мыши) меню в текущей позиции указателя.
* `contextClick(WebElement target): `                              Выполняет контекстное меню для указанного элемента.
* `doubleClick():`                                               Выполняет двойной клик левой кнопкой мыши в текущей позиции указателя.
* `doubleClick(WebElement target):`                                 Выполняет двойной клик левой кнопкой мыши по указанному элементу.
* `dragAndDrop(WebElement source, WebElement target):`            Выполняет перетаскивание элемента от источника к цели.
* `dragAndDropBy(WebElement source, int xOffset, int yOffset):`     Перетаскивает элемент на указанный сдвиг по осям X и Y.
* `getActiveKeyboard():`                                            Возвращает текущий активный объект клавиатуры.
* `getActivePointer():`                                             Возвращает текущий активный указатель.
* `getActiveWheel():`                                               Возвращает текущий активный объект колеса.
* `getSequences():`                                                 Возвращает последовательности действий, добавленные в действие Actions.
* `keyDown(CharSequence key):`                                      Нажимает клавишу на клавиатуре.
* `keyDown(WebElement target, CharSequence key):`                   Нажимает клавишу на клавиатуре с фокусом на указанный элемент.
* `keyUp(CharSequence key):`                                        Отпускает клавишу на клавиатуре.
* `keyUp(WebElement target, CharSequence key):`                     Отпускает клавишу на клавиатуре с фокусом на указанный элемент.
* `moveByOffset(int xOffset, int yOffset):`                         Перемещает указатель относительно текущей позиции.
* `moveToElement(WebElement target):`                               Перемещает указатель к центру указанного элемента.
* `moveToElement(WebElement target, int xOffset, int yOffset):`     Перемещает указатель к указанному элементу с заданным смещением.
* `moveToLocation(int xCoordinate, int yCoordinate):`               Перемещает указатель в абсолютные координаты на экране.
* `pause(long pause):`                                              Делает паузу в миллисекундах.
* `pause(Duration duration):`                                       Делает паузу в соответствии с заданной длительностью.
* `perform():`                                                      Выполняет все добавленные в Actions действия.
* `release():`                                                      Отпускает текущее удерживание клавиши или мыши.
* `release(WebElement target):`                                     Отпускает удерживание клавиши или мыши на указанном элементе.
* `scrollByAmount(int deltaX, int deltaY):`                         Прокручивает страницу на указанное количество пикселей.
* `scrollFromOrigin(WheelInput.ScrollOrigin scrollOrigin,int deltaX, int deltaY):`          Прокручивает страницу относительно указанного источника.
* `scrollToElement(WebElement element):`                            Прокручивает страницу так, чтобы элемент был видимым.
* `sendKeys(CharSequence... keys):`                                 Отправляет последовательность клавиш.
* `sendKeys(WebElement target, CharSequence... keys):`              Отправляет последовательность клавиш с фокусом на указанный элемент.
* `setActiveKeyboard(String name):`                                 Устанавливает активную клавиатуру по имени.
* `setActivePointer(PointerInput.Kind kind, String name):`          Устанавливает активный указатель по имени и виду.
* `setActiveWheel(String name):`                                    Устанавливает активное колесо по имени.
* `tick(Interaction... actions):`                                   Выполняет действия в заданной последовательности (в том числе созданные через Sequence.Builder).