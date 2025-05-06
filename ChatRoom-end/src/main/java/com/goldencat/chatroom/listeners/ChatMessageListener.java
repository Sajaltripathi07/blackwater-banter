package com.goldencat.chatroom.listeners;

import com.goldencat.chatroom.events.ChatMessageEvent;
import com.goldencat.chatroom.model.ChatMessage;
import com.goldencat.chatroom.model.ChatMessageEntity;
import com.goldencat.chatroom.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @EventListener
    public void onChatMessage(ChatMessageEvent event) {
        ChatMessage message = event.getMessage();

        // Save message
        chatMessageRepository.save(new ChatMessageEntity(message.getUsername(), message.getContent()));

        // Broadcast message
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
