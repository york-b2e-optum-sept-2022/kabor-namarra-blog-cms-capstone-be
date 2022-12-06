package net.yorksolutions.kabornamarrablogcmscapstone.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    private Set<Account> messenger;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> messages;

    public Chat() {
    }

//    public Chat(Set<Account> messenger) {
//        this.messenger = messenger;
//    }


    public Chat(Set<Account> messenger, Set<Message> messages) {
        this.messenger = messenger;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public Set<Account> getMessenger() {
        return messenger;
    }

    public void setMessenger(Set<Account> messenger) {
        this.messenger = messenger;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
