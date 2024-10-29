package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Utility class for reading properties from a configuration file
public class PropertyReader {
    // Properties object to store key-value pairs from the file
    private final Properties properties;

    // Constructor that accepts a file name and loads the properties
    public PropertyReader(String fileName) {
        properties = new Properties();
        this.load(fileName);
    }

    // Loads the properties file into the Properties object
    private void load(String fileName) {
        try {
            // Get the properties file as an input stream from the classpath
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

            // Load the properties from the input stream
            properties.load(inputStream);
        } catch (IOException e) {
            // Print stack trace if there’s an issue loading the file
            e.printStackTrace();
        }
    }

    // Retrieves the value for a specified key from the properties
    public String get(String key) {
        return properties.getProperty(key);
    }
}
