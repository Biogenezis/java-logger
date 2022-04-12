package org.example.logger.logger.appender;

import org.example.logger.logger.formatter.Formatter;
import org.example.logger.logger.helpers.Level;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class FileAppender extends AbstractAppender {

    private final String pathFile = "C:\\Users\\Vladimir_Zimin\\testFile.txt";

    private String appenderLogs;

    public FileAppender(Formatter formatter) {
        super(formatter, Level.ALL);
    }

    public FileAppender(Formatter formatter, Level level) {
        super(formatter, level);
    }

    @Override
    public void append(LocalDateTime localDateTime, String message, Level level) throws IOException {
        String bufferMsg = appenderLogs.concat(message);
        String formatted = this.getFormatter().format(localDateTime, level, bufferMsg);
        writeFile(formatted);

    }

    @Override
    public void append(LocalDateTime localDateTime, String message, Level level, Object... args) throws IOException {
        String formatted = this.getFormatter().format(localDateTime, level, message, args);
        writeFile(formatted);
    }

    private void writeFile(String formatted) throws IOException {
        File file = new File(pathFile);
        if (!file.createNewFile()) {
            try(FileWriter myWriter = new FileWriter(file, true)) {
                myWriter.append(formatted);
                myWriter.flush();
            }
        } else {
            try(FileWriter myWriter = new FileWriter(pathFile, true)) {
                myWriter.append(formatted);
                myWriter.flush();
            }
        }
    }
}
