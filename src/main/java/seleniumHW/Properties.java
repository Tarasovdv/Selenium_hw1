package seleniumHW;

import java.io.*;

public class Properties {

    public static InputStream readPropFile(String name_file) {
        ClassLoader classLoader = Properties.class.getClassLoader();
        return classLoader.getResourceAsStream(name_file);
    }

    public static String selectParams(InputStream file_props, String key) {
        java.util.Properties props = new java.util.Properties();
        try {
            props.load(file_props);
        } catch (IOException e) {
            System.out.println("Файл properties отсутствует");
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }


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
