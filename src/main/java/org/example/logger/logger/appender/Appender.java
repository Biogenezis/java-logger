package org.example.logger.logger.appender;

import org.example.logger.logger.helpers.Level;

import java.io.IOException;
import java.time.LocalDateTime;


//Что аппендер должен делать?

public interface Appender {

        void append(LocalDateTime localDateTime, String message, Level level) throws IOException;

        void append(LocalDateTime localDateTime,String message, Level level, Object... args) throws IOException;

        Level getLevel();
}
