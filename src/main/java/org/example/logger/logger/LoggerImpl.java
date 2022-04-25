package org.example.logger.logger;


import org.example.logger.logger.appender.Appender;
import org.example.logger.logger.helpers.Level;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LoggerImpl implements Logger {

    private final List<Appender> appenderList;

    private Supplier<LocalDateTime> time = LocalDateTime::now;

    public LoggerImpl(List<Appender> appenderList, Supplier<LocalDateTime> time) {
        this.appenderList = appenderList;
        this.time = time;
    }

    public LoggerImpl(Appender... appenderList) {
        this.appenderList = Arrays.asList(appenderList);
    }

    @Override
    public void log(String message) {
        this.callAllAppenderList(time.get(), Level.TRACE, message);
    }

    @Override
    public void log(String message, Object... args) {
        this.callAllAppenderList(time.get(), Level.TRACE, message, args);

    }

    @Override
    public void log(Level level, String message, Object... args) {
        this.callAllAppenderList(time.get(), level, message, args);
    }

    @Override
    public void info(String message) {
        this.callAllAppenderList(time.get(), Level.INFO, message);

    }

    @Override
    public void info(String message, Object... args) {
        this.callAllAppenderList(time.get(), Level.INFO, message, args);
    }

    @Override
    public void error(String message)  {
        this.callAllAppenderList(time.get(), Level.ERROR, message);
    }

    @Override
    public void error(String message, Object... args)  {
        this.callAllAppenderList(time.get(), Level.ERROR, message, args);
    }

    @Override
    public void debug(String message)  {
        this.callAllAppenderList(time.get(), Level.DEBUG, message);
    }

    @Override
    public void debug(String message, Object... args) {
        this.callAllAppenderList(time.get(), Level.DEBUG, message, args);
    }


    private void callAllAppenderList(LocalDateTime localDateTime, Level level, String message) {
        for (Appender appender : appenderList) {
            if (appender.getLevel().ordinal() <= level.ordinal()) {
                appender.append(localDateTime, message, level);
            }

        }
    }


    private void callAllAppenderList(LocalDateTime localDateTime, Level level, String message, Object... args) {
        for (Appender appender : appenderList) {
            if (appender.getLevel().ordinal() <= level.ordinal()) {
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
