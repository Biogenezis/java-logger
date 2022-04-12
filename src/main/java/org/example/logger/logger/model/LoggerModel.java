package org.example.logger.logger.model;

import org.example.logger.logger.helpers.Level;

public class LoggerModel {

    private long timestamp;
    private Level loggerLevel;
    private String logMessage;

    @Override
    public String toString() {
        return
                "timestamp=" + timestamp +
                ", loggerLevel=" + loggerLevel +
                ", logMessage='" + logMessage + '\'' ;
    }

    public LoggerModel(Level loggerLevel, String logMessage) {
        this.loggerLevel = loggerLevel;
        this.logMessage = logMessage;
    }

    public LoggerModel() {

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
}
