package org.example.logger.logger.appender;


//Имплементация СОЗДАНИЯ аппендера

import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

public class AppenderFactoryImpl implements AppenderFactory {

    // В зависимости от типа верни имплементацию аппендера
    @Override
    public Appender produce(String appenderType, Level level, Formatter formatter) {
        return switch (appenderType) {
            case "file" -> new FileAppender(formatter, level);
            case "console" -> new ConsoleAppender(formatter, level);
//            case "extra" -> new ExtraAppender(formatter, level);
            default -> throw new IllegalStateException("Invalid type - " + appenderType);
        };
    }
}
