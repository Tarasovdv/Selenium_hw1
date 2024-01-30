package sandbox;

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
}
