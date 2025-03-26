package runner.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties(); //singleton-паттерн — один экземпляр на приложение

    static {                                             //  Статический блок: выполняется один раз при загрузке класса
        try (InputStream in = Config.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) { // ищет файл в src/test/resources
            if (in == null) {
                throw new RuntimeException("config.properties not found");
            }
            properties.load(in);                             // загружает пары key=value в properties
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    /** Возвращает значение из config.properties по ключу */
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
