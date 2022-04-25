package org.example.logger.logger;


import org.example.logger.logger.appender.Appender;
import org.example.logger.logger.helpers.Level;

public interface Logger {

    void addAppender(Appender appender);

    void log(String message);

    void log(String message, Object... args);

    void log(Level level, String message, Object... args);

    void info(String message);

    void info(String message, Object... args);

    void error(String message);

    void error(String message, Object... args);

    void debug(String message);

    void debug(String message, Object... args);



}
