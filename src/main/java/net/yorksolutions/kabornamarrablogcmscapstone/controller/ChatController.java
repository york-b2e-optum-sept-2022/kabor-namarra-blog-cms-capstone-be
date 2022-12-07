package net.yorksolutions.kabornamarrablogcmscapstone.controller;

import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewChatRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewMessageRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Chat;
import net.yorksolutions.kabornamarrablogcmscapstone.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Chat createChat(@RequestBody NewChatRequestDTO chatRequestDTO){
        return this.chatService.createChat(chatRequestDTO);
    }

    @GetMapping("/accounts")
    public Iterable<Chat> getAllAccountChats(@RequestParam Long id){
        return this.chatService.getAllAccountChats(id);
    }

    @GetMapping
    public Chat getChat(@RequestParam Long id){
        return this.chatService.getChat(id);
    }

    @PutMapping
    public Chat updateChat(@RequestBody NewMessageRequestDTO messageRequestDTO){
        return this.chatService.updateChat(messageRequestDTO);
    }
}
