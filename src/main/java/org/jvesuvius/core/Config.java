package org.jvesuvius.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Config {
    /**
    * Returns database credentials from .properties file.
    * @return HashMap with "dbUsername" key and "dbPassword" key.
    */
    public HashMap<String, String> getDbCredentials() {
        HashMap<String, String> map = new HashMap<String, String>();
        Properties conf = new Properties();
        try {
            conf.load(this.getClass().getResourceAsStream("/dbCredentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("dbUsername", conf.getProperty("dbUsername"));
        map.put("dbPassword", conf.getProperty("dbPassword"));
        return map;
    }
}
