package org.example.logger.logger.appender;


import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

//Абстракция для аппендера (определение полей и методов для детей)
public abstract class AbstractAppender implements Appender{

    private Formatter formatter;

    private Level level;

    public AbstractAppender() {
    }

    public AbstractAppender(Formatter formatter, Level level) {
        this.formatter = formatter;
        this.level = level;
    }

    public AbstractAppender(Formatter formatter) {
        this(formatter, Level.ALL);
    }

    public Formatter getFormatter() {
        return formatter;
    }


    @Override
    public Level getLevel() {
        return level;
    }


    @Override
    public String toString() {
        return "Appender type: " + String.format("Report level: %s, ", this.getLevel()).toString() +
                "Messages appended: ";
    }


}
