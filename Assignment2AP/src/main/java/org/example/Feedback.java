package org.example;

public class Feedback {
    private String visitorName;
    private String message;

    public Feedback(String visitorName, String message) {
        this.visitorName = visitorName;
        this.message = message;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getMessage() {
        return message;
    }
}