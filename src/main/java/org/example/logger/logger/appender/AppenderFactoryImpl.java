package org.example.logger.logger.appender;


//Имплементация СОЗДАНИЯ аппендера

import org.example.logger.logger.appender.enums.AppenderType;
import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;
import org.example.logger.logger.props.PropertiesLoader;
import org.example.logger.logger.props.Resources;

import java.util.List;
import java.util.Objects;

public class AppenderFactoryImpl implements AppenderFactory {


    private static final Resources resources = new PropertiesLoader();

    private Level level;

    //TODO: Убрать мисскаст
    private AppenderType appenderType = AppenderType.valueOf(resources.getValue("logger.writer.type"));


    @Override
    public Appender produce(Level level, Formatter formatter) {
        if (Objects.isNull(appenderType)) {
            appenderType = AppenderType.CONSOLE;
        }
        return getAppender(appenderType, level, formatter);
    }


    public Appender produce(AppenderType appenderType, Level level, Formatter formatter) {
        return getAppender(appenderType, level, formatter);
    }

    private Appender getAppender(AppenderType appenderType, Level level, Formatter formatter) {
        return switch (appenderType) {
            case FILE -> new FileAppender(formatter, level);
            case CONSOLE -> new ConsoleAppender(formatter, level);
            default -> throw new IllegalStateException("Invalid type - " + appenderType);
        };
    }
}
