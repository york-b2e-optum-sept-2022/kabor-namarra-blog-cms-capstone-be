package net.yorksolutions.kabornamarrablogcmscapstone.service;

import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewChatRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewMessageRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Chat;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Message;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.AccountRepository;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.ChatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ChatService {

    ChatRepository chatRepository;
    AccountRepository accountRepository;

    public ChatService(ChatRepository chatRepository, AccountRepository accountRepository) {
        this.chatRepository = chatRepository;
        this.accountRepository = accountRepository;
    }

    public Chat createChat(NewChatRequestDTO chatRequestDTO){
        Optional<Account> accountOptional1 = this.accountRepository.findById(chatRequestDTO.messengerID);
        if (accountOptional1.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<Account> accountOptional2 = this.accountRepository.findById(chatRequestDTO.receiverID);
        if (accountOptional2.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Set<Account> accounts = new HashSet<Account>();

        Message message = new Message(chatRequestDTO.messageText, new Date(), accountOptional1.get());

        Set<Message> messages = new HashSet<Message>();

        messages.add(message);

        accounts.add(accountOptional1.get());
        accounts.add(accountOptional2.get());

        Chat chat = new Chat(accounts,messages);

        return this.chatRepository.save(chat);
    }

    public Iterable<Chat> getAllAccountChats(Long id){
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return this.chatRepository.findAllByMessenger(accountOptional.get());
    }

    public Chat getChat(Long id){
        Optional<Chat> chatOptional = this.chatRepository.findById(id);
        if (chatOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return chatOptional.get();
    }

    public Chat updateChat(NewMessageRequestDTO newMessageRequestDTO){
        Optional<Chat> chatOptional = this.chatRepository.findById(newMessageRequestDTO.chatID);
        if (chatOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<Account> accountOptional = this.accountRepository.findById(newMessageRequestDTO.messengerID);
        if (accountOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        //Figure out new messages ID problem
        Message message = new Message(newMessageRequestDTO.messageText,new Date(),accountOptional.get());

        Chat updatedChat = chatOptional.get();
        updatedChat.getMessages().add(message);

        return this.chatRepository.save(updatedChat);
    }
}
