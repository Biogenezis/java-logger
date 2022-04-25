package org.example.logger.logger.model;

import org.example.logger.logger.helpers.Level;

import java.util.Objects;

public class LoggerModel {

    private long timestamp;
    private Level loggerLevel;
    private String logMessage;

    public LoggerModel(Level loggerLevel, String logMessage) {
        this.loggerLevel = loggerLevel;
        this.logMessage = logMessage;
    }

    public LoggerModel() {

    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, loggerLevel, logMessage);
    }

    public Level getLoggerLevel() {
        return loggerLevel;
    }

    public void setLoggerLevel(Level loggerLevel) {
        this.loggerLevel = loggerLevel;
    }


    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoggerModel that = (LoggerModel) o;
        return timestamp == that.timestamp && loggerLevel == that.loggerLevel && Objects.equals(logMessage, that.logMessage);
    }

    @Override
    public String toString() {
        return
                "timestamp=" + timestamp +
                        ", loggerLevel=" + loggerLevel +
                        ", logMessage='" + logMessage + '\'';
    }
}
