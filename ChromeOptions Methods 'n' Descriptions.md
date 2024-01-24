# ChromeOptions Methods 'n' Descriptions

    ChromeOptions options = new ChromeOptions();

## setBinary

    options.setBinary(File path); 
    options.setBinary(String path);

Задает путь к исполняемому файлу Chrome. 
Этот путь должен существовать на компьютере, на котором будет запущен Chrome. 
Путь должен быть либо абсолютным, либо относительным к местоположению запущенного сервера ChromeDriver

## addArguments

    options.addArguments(String... arguments);  

`arguments` - аргументы, которые будут использоваться при запуске Chrome.

    options.addArguments(List<String> arguments); 

Добавляет дополнительные аргументы командной строки, которые будут использоваться при запуске Chrome. 
Например:

    options.addArguments(
    "load-extension=/path/to/unpacked_extension",
    "allow-outdated-plugins");

[Подробнее о ФЛАГАХ на GitHub](github.com/GoogleChrome/chrome-launcher/blob/main/docs/chrome-flags-for-tools.md)


## addExtensions

    options.addExtensions(List<File> paths); 
    options.addExtensions(File... paths);

Добавляет новое расширение Chrome для установки при запуске браузера. 
В каждом пути должно указываться упакованное расширение Chrome (CRX-файл).

## addEncodedExtensions

    options.addEncodedExtensions(String... encoded); 

`encoded` - данные устанавливаемых расширений, закодированные в Base64.

    options.addEncodedExtensions(List<String> encoded); 

Добавляет новое расширение Chrome для установки при запуске браузера. В каждой строке данных должна указываться строка в кодировке Base64 упакованного расширения Chrome (CRX-файл).

## setExperimentalOption

    options.setExperimentalOption(String name, Object value); 

`name` - Название экспериментальной опции.
`value` - значение экспериментальной опции, которое должно быть преобразовано в JSON.

Устанавливает экспериментальный параметр. 
Полезно для новых опций ChromeDriver, которые еще не доступны через ChromiumOptions API. 

Далее `options` прописываем в параметрах `driver`

    WebDriver driver = new ChromeDriver(options);