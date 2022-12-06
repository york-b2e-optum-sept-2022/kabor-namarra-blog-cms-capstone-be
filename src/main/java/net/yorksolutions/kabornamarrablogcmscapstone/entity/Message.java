package net.yorksolutions.kabornamarrablogcmscapstone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String messageText;

    private Date createdDate;

    @ManyToOne
    private Account messenger;

//    @ManyToOne
//    private Chat chat;

    public Message() {
    }

//    public Message(String messageText, Date createdDate, Chat chat) {
//        this.messageText = messageText;
//        this.createdDate = createdDate;
//        this.chat = chat;
//    }


    public Message(String messageText, Date createdDate, Account messenger) {
        this.messageText = messageText;
        this.createdDate = createdDate;
        this.messenger = messenger;
    }

    public Long getId() {
        return id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Account getMessenger() {
        return messenger;
    }

    public void setMessenger(Account messenger) {
        this.messenger = messenger;
    }

    //    public Chat getChat() {
//        return chat;
//    }
//
//    public void setChat(Chat chat) {
//        this.chat = chat;
//    }
}
