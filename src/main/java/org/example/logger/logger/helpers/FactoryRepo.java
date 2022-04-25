package org.example.logger.logger.helpers;


import org.example.logger.logger.appender.AppenderFactory;
import org.example.logger.logger.appender.AppenderFactoryImpl;
import org.example.logger.logger.formatter.FormatterFactory;
import org.example.logger.logger.formatter.FormatterFactoryImpl;

//Как эти фабрики вызвать?
public final class FactoryRepo {

    private static final AppenderFactory appenderFactory = new AppenderFactoryImpl();

    private static final FormatterFactory formatterFactory = new FormatterFactoryImpl();

}
