package net.yorksolutions.kabornamarrablogcmscapstone.service;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Message;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

//    public Message createMessage(){
//
//    }
}
