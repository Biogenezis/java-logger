package org.example.logger.logger.appender;


import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

//Абстракция для аппендера (определение полей и методов для детей)
public abstract class AbstractAppender implements Appender{

    private Formatter formatter;

    private Level level;

    public AbstractAppender(Formatter formatter, Level level) {
        this.formatter = formatter;
        this.level = level;
    }

    public Formatter getFormatter() {
        return formatter;
    }


    @Override
    public Level getLevel() {
        return level;
    }



}
