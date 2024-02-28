package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.opentestfactory.util.ParameterService;

public class ConfProperties {
    public static final Logger logger = LogManager.getLogger(ConfProperties.class);

    protected static Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        // load common properties
        loadProperties("src/test/resources/conf.properties");

        // load API authentication token from a specific separate file
        loadProperties("src/test/resources/auth.properties");
    }

    private static void loadProperties(String name) {
        try {
            try (FileInputStream fileInputStream = new FileInputStream(name)) {
                Properties properties = new Properties();
                properties.load(fileInputStream);

                PROPERTIES.putAll(properties);
            }
        } catch (IOException e) {
            logger.error("Error during loading properties from file {}", name, e);
        }
    }

    public static String getProperty(String key) {
        return ParameterService.INSTANCE.getString("DS_" + key, PROPERTIES.getProperty(key));
    }
}