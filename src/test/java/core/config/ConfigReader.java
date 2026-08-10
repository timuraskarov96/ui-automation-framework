package core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Класс-читалка конфигурационных файлов (Config Reader). Он загружает настройки из файла config.properties
public class ConfigReader {
    private static final Properties properties = new Properties();


    // Статический блок — выполняется один раз при загрузке класса (до создания объектов)
    static {

        // Загружает файл config.properties из папки resources/
        try (InputStream inputStream = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties"))
        {
            // Если файл не найден — выбрасывает исключение с сообщением
            if(inputStream == null){
                throw new RuntimeException("Файл config.properties не найден");
            }
            // Загружает все пары ключ=значение из файла в объект properties
            properties.load(inputStream);
        }
        // Ловит ошибки ввода-вывода и выбрасывает новое исключение
        catch (IOException e){
            throw new RuntimeException("Ошибка загрузки config.properties", e);
        }
    }

    public static String getBrowser(){
        return properties.getProperty("browser");
    }

    public static String getUrlAutomationexercise(){
        return properties.getProperty("urlAutomationexercise");
    }

    public static String getUrlAviakassa(){
        return properties.getProperty("urlAviakassa");
    }

    public static int getTimeout(){
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public static String getEmail(){
        return properties.getProperty("email");
    }

    public static String getPassword(){
        return properties.getProperty("password");
    }
}
