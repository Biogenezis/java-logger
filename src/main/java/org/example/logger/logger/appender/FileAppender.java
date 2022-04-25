package org.example.logger.logger.appender;

import org.example.logger.logger.exception.LogFileNotFound;
import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;
import org.example.logger.logger.props.PropertiesLoader;
import org.example.logger.logger.props.Resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class FileAppender extends AbstractAppender {

    //Edit this
    private final String pathFile;

    private static final Resources resources = new PropertiesLoader();

    private final ThreadLocal<File> currentFile = new ThreadLocal<>();

    //TODO: how close it with the finish of program
    private File file;


    public FileAppender(Formatter formatter, Level level) {
        super(formatter, level);
        this.pathFile = resources.getValue("logger.file.path");
        this.file = new File(pathFile);
        this.currentFile.set(file);
    }

    @Override
    public void append(LocalDateTime localDateTime, String message, Level level) {
        String formatted = this.getFormatter().format(localDateTime, level, message);
        writeFile(formatted);

    }

    @Override
    public void append(LocalDateTime localDateTime, String message, Level level, Object... args) {
        String formatted = this.getFormatter().format(localDateTime, level, message, args);
        writeFile(formatted);
    }

    private void writeFile(String formattedString) throws LogFileNotFound {
        try {
            FileWriter myWriter = new FileWriter(currentFile.get(), true);
            myWriter.append(formattedString);
            myWriter.flush();
            myWriter.close();
        } catch (IOException logFileNotFound) {
            throw new LogFileNotFound("File not found");
        }
    }


}

