package org.example.logger.logger.model;

import org.example.logger.logger.formatter.FileModel;

public class LogFileModel implements FileModel {
    private StringBuilder builder;

    public LogFileModel() {
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.builder.append(text);

    }

    @Override
    public int getSize() {

        int sum = 0;

        for (int i = 0; i < this.builder.length() ; i++) {

            char symbol = this.builder.charAt(i);
            if (Character.isAlphabetic(symbol)) {
                sum += symbol;
            }

        }

        return sum;
    }
}
