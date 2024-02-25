package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Logger logger= LogManager.getLogger(ConfigManager.class);

    private static final Properties properties=new Properties();

    static{

            InputStream inputStream=ConfigManager.class.getClassLoader()
                    .getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
            logger.info("Application properties loaded successfully.");
        } catch (IOException e) {
            logger.error("Could not load application properties.", e);
            throw new RuntimeException(e);
        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
