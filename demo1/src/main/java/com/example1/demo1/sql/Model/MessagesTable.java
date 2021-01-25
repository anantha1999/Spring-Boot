package com.example1.demo1.sql.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessagesTable implements Serializable {

    
    /**
     *
     */
    private static final long serialVersionUID = 5751388729435074607L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "message")
    private String message;

    public long getId() {
        return this.id;
    }

    public MessagesTable(String message) {
        this.message = message;
    }


    public MessagesTable(){

    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
