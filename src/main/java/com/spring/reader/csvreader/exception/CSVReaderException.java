package com.spring.reader.csvreader.exception;

/**
 * @author : Sanjay
 */
public class CSVReaderException extends RuntimeException {
    private String message;

    public CSVReaderException(String message) {
        this.message = message;
    }

    public CSVReaderException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public CSVReaderException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public CSVReaderException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public CSVReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
