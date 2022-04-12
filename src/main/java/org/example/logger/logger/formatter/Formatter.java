package org.example.logger.logger.formatter;

import org.example.logger.logger.helpers.Level;

import java.time.LocalDateTime;

public interface Formatter {

    String format(LocalDateTime localDateTime, Level level, String message);

    String format(LocalDateTime localDateTime, Level level, String string, Object... args);


}
