package org.example.logger.logger.formatter;

import org.example.logger.logger.helpers.Level;

import java.time.LocalDateTime;
import java.util.Arrays;

public class FormatterImpl implements Formatter {


    public FormatterImpl() {
    }

    @Override
    public String format(LocalDateTime localDateTime, Level level, String message) {
         //Что он должен делать без аргументов?
        return String.format("%s Level is %s, message: %s\n", localDateTime, level, message);
    }

    @Override
    public String format(LocalDateTime localDateTime, Level level, String message, Object... args) {
        return String.format("%s Level is %s, message: %s%s\n", localDateTime, level, message, Arrays.toString(args));
    }
}
