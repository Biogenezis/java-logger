package org.example.logger.logger;


import org.example.logger.logger.appender.Appender;
import org.example.logger.logger.helpers.Level;

import java.io.IOException;

public interface Logger {

    void addAppender(Appender appender);

    void log(String message) throws IOException;

    void log(String message, Object... args) throws IOException;

    void log(Level level, String message, Object... args) throws IOException;

    void info(String message) throws IOException;

    void info(String message, Object... args) throws IOException;

    void error(String message) throws IOException;

    void error(String message, Object... args) throws IOException;

    void debug(String message) throws IOException;

    void debug(String message, Object... args) throws IOException;



}
