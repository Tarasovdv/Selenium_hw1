package seleniumHW;

import java.io.*;

public class Properties {

    public static InputStream readPropFile(String nameFile) {
        return Properties.class.getClassLoader().getResourceAsStream(nameFile);
    }

    public static String selectParams(InputStream fileProps, String key) {
        java.util.Properties props = new java.util.Properties();
        try {
            props.load(fileProps);
        } catch (IOException e) {
            System.out.println("Файл properties отсутствует");
            throw new RuntimeException(e);
        }
        return props.getProperty(key);
    }
}
