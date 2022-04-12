package org.example.logger.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ContextLoader {

    public static String filePath;

    public static String loggerLevel;

    public static String loggerType;


    public static void loadProperties() throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        filePath = appProps.getProperty("logger.file.path");

        loggerLevel = appProps.getProperty("logger.writer.level");

        loggerType = appProps.getProperty("logger.writer.type");

    }

}
