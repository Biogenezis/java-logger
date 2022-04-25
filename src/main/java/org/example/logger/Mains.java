package org.example.logger;




import org.example.logger.logger.Logger;
import org.example.logger.logger.LoggerImpl;
import org.example.logger.logger.appender.Appender;
import org.example.logger.logger.appender.ConsoleAppender;
import org.example.logger.logger.appender.FileAppender;
import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.formatter.FormatterImpl;
import org.example.logger.logger.helpers.Level;

import java.io.IOException;
import java.util.Scanner;


public class Mains {
    public static void main(String[] args) throws IOException {

        //TODO: refactor
        Formatter simpleLayout = new FormatterImpl();
        Appender consoleAppender = new ConsoleAppender(simpleLayout, Level.DEBUG);
        Appender fileAppender = new FileAppender(simpleLayout, Level.ERROR);
        Logger logger = new LoggerImpl(consoleAppender, fileAppender);

//        Appender consoleAppenderSecond = new ConsoleAppender(simpleLayout, Level.DEBUG);
//        fileAppender.append(LocalDateTime.now(), "Test message", Level.DEBUG);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double firstNumber = scanner.nextDouble();
        logger.debug("Первое полученное число: ", firstNumber);
        System.out.print("Введите второе число: ");
        double secondNumber = scanner.nextDouble();
        logger.error("Первое полученное число: ", secondNumber);
        System.out.print("Введите арифметическую операцию: ");
        scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        logger.log("Полученный оператор: ", operation);
        double result = 0.0;
        switch (operation) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = firstNumber / secondNumber;
            default -> System.out.println("Default case");
        }
        logger.log(Level.TRACE, " result ", result);
    }




}
