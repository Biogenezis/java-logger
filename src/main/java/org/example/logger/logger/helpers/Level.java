package org.example.logger.logger.helpers;

public enum Level {
    ERROR(4, "ERROR"),
    WARN(3, "WARN"),
    INFO(2, "INFO"),
    DEBUG(1, "DEBUG"),
    ALL(0, "TRACE");

    private final int levelCode;
    private final String levelName;

    private Level(int code, String name) {
        this.levelCode = code;
        this.levelName = name;
    }

    public int toInt() {
        return this.levelCode;
    }

    public String toString() {
        return this.levelName;
    }
}
