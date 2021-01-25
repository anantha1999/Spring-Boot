package com.example1.demo1.messages;

public class Messages {
    private int id;
    private String message;

    public Messages(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Messages(){

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }
}
