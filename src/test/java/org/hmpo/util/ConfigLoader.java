package org.hmpo.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * loads properties based on environment passed in maven profiles.
 */
public class ConfigLoader {
    public static Properties loadProperties() {
        String profile = System.getProperty("active.profile", "dev"); // Defaulted to dev in pom.xml properties
        String propName = profile + ".properties";
        System.out.println("profile activated is - " + profile);

        Properties prop = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(propName)) {
            if (input == null) {
                throw new FileNotFoundException("Unable to find " + propName);
            }
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static String getBitCoinApiBaseUrl() {
        return loadProperties().getProperty("api.baseUrl");
    }
}
