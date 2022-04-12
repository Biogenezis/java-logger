package org.example.logger.logger.appender;


import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

//Как аппендер должен создаваться?
public interface AppenderFactory {

    Appender produce(String appenderType, Level level, Formatter formatter);

}
