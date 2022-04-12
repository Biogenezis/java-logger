package org.example.logger.logger.formatter;

public class FormatterFactoryImpl implements FormatterFactory {


    @Override
    //Можно их типизировать в зависимости от параметров?
    public Formatter produce() {
        return new FormatterImpl();
    }
}
