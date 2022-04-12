package org.example.logger.logger.helpers;


import org.example.logger.logger.appender.AppenderFactory;
import org.example.logger.logger.appender.AppenderFactoryImpl;
import org.example.logger.logger.formatter.FormatterFactory;
import org.example.logger.logger.formatter.FormatterFactoryImpl;

//Как эти фабрики вызвать?
public class FactoryRepo {

    private static AppenderFactory appenderFactory;

    private static FormatterFactory formatterFactory;

    private FactoryRepo() {

    }

    public static AppenderFactory getAppenderFactory() {
        if (appenderFactory == null) {
            return appenderFactory = new AppenderFactoryImpl();
        }
        return appenderFactory;
    }

    public static FormatterFactory getLayoutFactory() {
        if (formatterFactory == null) {
            return formatterFactory = new FormatterFactoryImpl();
        }
        return formatterFactory;
    }

}
