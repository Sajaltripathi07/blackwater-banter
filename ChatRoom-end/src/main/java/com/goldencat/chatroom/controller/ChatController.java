package com.goldencat.chatroom.controller;

import com.goldencat.chatroom.events.ChatMessageEvent;
import com.goldencat.chatroom.model.ChatMessage;
import com.goldencat.chatroom.model.ChatMessageEntity;
import com.goldencat.chatroom.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    // ✅ Handles message sending (event-driven)
    @MessageMapping("/chat")
    public void handleMessage(@Payload ChatMessage message) {
        String username = HtmlUtils.htmlEscape(message.getUsername());
        String content = HtmlUtils.htmlEscape(message.getContent());

        // Publish the sanitized message as an event
        eventPublisher.publishEvent(new ChatMessageEvent(this, new ChatMessage(username, content)));
    }

    // ✅ Handles user leaving the chat
    @MessageMapping("/leave")
    @SendTo("/topic/messages")
    public ChatMessage leave(ChatMessage message) {
        String username = HtmlUtils.htmlEscape(message.getUsername());
        return new ChatMessage(username, username + " has left the chat");
    }

    // ✅ Loads login page
    @GetMapping("/")
    public String login() {
        return "login";
    }

    // ✅ Loads chat UI with username param
    @GetMapping("/chat")
    public String chat(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "chat";
    }

    // ✅ REST endpoint to return previous messages
    @GetMapping("/api/messages")
    @ResponseBody
    public List<ChatMessage> getPreviousMessages() {
        return chatMessageRepository.findAll()
                .stream()
                .map(entity -> new ChatMessage(entity.getUsername(), entity.getContent()))
                .collect(Collectors.toList());
    }
}
