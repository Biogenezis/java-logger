package org.example.logger.logger.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class LogFileNotFound extends RuntimeException {

    public LogFileNotFound() {
        super();
    }

    public LogFileNotFound(String message) {
        super(message);
    }


}
