package com.spring.reader.csvreader.message;

/**
 * @author Sanjay
 * <p>
 * This class is used to send Response to the CLient used in the Controller and Exception Handler.
 */
public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
