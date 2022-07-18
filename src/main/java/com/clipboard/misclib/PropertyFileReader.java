package com.clipboard.misclib;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author jitendra.pisal
 */
public final class PropertyFileReader {

    Properties properties;

    public PropertyFileReader(){}

    public String readPropertyFile(String fileName, String parameter) throws IOException {
        this.properties = new Properties();

        try {
            this.properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/" + fileName), StandardCharsets.UTF_8));
        } catch (Exception var4) {
            this.properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/properties/" + fileName), StandardCharsets.UTF_8));
        }
        return this.properties.getProperty(parameter);
    }
}
