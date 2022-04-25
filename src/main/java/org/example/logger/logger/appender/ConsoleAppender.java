package org.example.logger.logger.appender;

import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

import java.time.LocalDateTime;

public class ConsoleAppender extends AbstractAppender {

    public ConsoleAppender(Formatter formatter) {
        this(formatter, Level.TRACE);
    }

    public ConsoleAppender(Formatter formatter, Level level) {
        super(formatter, level);
    }

    @Override
    public void append(LocalDateTime localDateTime, String message, Level level) {
        System.out.println(this.getFormatter().format(localDateTime, level, message));
    }

    @Override
    public void append(LocalDateTime localDateTime, String message, Level level, Object... args) {
        System.out.println(this.getFormatter().format(localDateTime, level, message, args));
    }
}
