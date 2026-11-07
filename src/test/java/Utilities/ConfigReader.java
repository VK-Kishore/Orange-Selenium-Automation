package Utilities;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream input =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties not found"
                );
            }

            properties.load(input);

        } catch (IOException e) {

            throw new ExceptionInInitializerError(e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing configuration: " + key
            );
        }

        return value.trim();
    }
}