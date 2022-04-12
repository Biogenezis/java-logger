package org.example.logger.logger;


import org.example.logger.logger.appender.Appender;
import org.example.logger.logger.helpers.Level;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoggerImpl implements Logger{

    private final List<Appender> appenderList;


    public LoggerImpl(Appender... appenderList) {
        this.appenderList = new ArrayList<>(Arrays.asList(appenderList));
    }

    @Override
    public void log(String message) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.ALL, message);
    }

    @Override
    public void log(String message, Object... args) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.ALL, message, args);

    }

    @Override
    public void log(Level level, String message, Object... args) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.ALL, message, args);
    }

    @Override
    public void info(String message) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.INFO, message);

    }

    @Override
    public void info(String message, Object... args) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.INFO, message, args);
    }

    @Override
    public void error(String message) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.ERROR, message);
    }

    @Override
    public void error(String message, Object... args) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.ERROR, message, args);
    }

    @Override
    public void debug(String message) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.DEBUG, message);
    }

    @Override
    public void debug(String message, Object... args) throws IOException {
        this.callAllAppenderList(LocalDateTime.now(), Level.DEBUG, message, args);
    }


    private void callAllAppenderList(LocalDateTime localDateTime, Level level, String message) throws IOException {
        for (Appender appender : appenderList) {
            if (appender.getLevel().toInt() <= level.toInt()) {
                appender.append(localDateTime, message, level);
            }

        }
    }


    private void callAllAppenderList(LocalDateTime localDateTime, Level level, String message, Object... args) throws IOException {
        for (Appender appender : appenderList) {
            if (appender.getLevel().toInt() <= level.toInt()) {
                appender.append(localDateTime, message, level, args);
            }

        }
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenderList.add(appender);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info").append(System.lineSeparator());
        builder.append(this.appenderList.stream().map(Appender::toString).collect(Collectors.joining(System.lineSeparator())));
        return builder.toString();
    }
}
