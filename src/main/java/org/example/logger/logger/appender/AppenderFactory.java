package org.example.logger.logger.appender;


import org.example.logger.logger.appender.enums.AppenderType;
import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

//Как аппендер должен создаваться?
public interface AppenderFactory {

    Appender produce(Level level, Formatter formatter);

    Appender produce(AppenderType appenderType, Level level, Formatter formatter);



}
