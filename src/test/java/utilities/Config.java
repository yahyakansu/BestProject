package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static String path="configuration.properties";
    private static Properties properties = new Properties();
    static {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}
