# Locator strategies

Способы идентификации одного или нескольких конкретных элементов в DOM.

Локатор - это способ идентификации элементов на странице. Это аргумент, передаваемый методам поиска элементов.

## Traditional Locators

Selenium provides support for these 8 traditional location strategies in WebDriver:

Locator	Description
1. `class name`	        Locates elements whose class name contains the search value (compound class names are not permitted)
2. `css selector`	    Locates elements matching a CSS selector
3. `id`	                Locates elements whose ID attribute matches the search value
4. `name`	            Locates elements whose NAME attribute matches the search value
5. `link text`	        Locates anchor elements whose visible text matches the search value
6. `partial link text`	Locates anchor elements whose visible text contains the search value. 
If multiple elements are matching, only the first one will be selected.
7. `tag name`	        Locates elements whose tag name matches the search value
8. `xpath`	            Locates elements matching an XPath expression