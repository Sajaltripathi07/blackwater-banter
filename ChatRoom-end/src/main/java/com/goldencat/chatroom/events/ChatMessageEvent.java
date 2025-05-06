package com.goldencat.chatroom.events;

import com.goldencat.chatroom.model.ChatMessage;
import org.springframework.context.ApplicationEvent;

public class ChatMessageEvent extends ApplicationEvent {

    private final ChatMessage message;

    public ChatMessageEvent(Object source, ChatMessage message) {
        super(source);
        this.message = message;
    }

    public ChatMessage getMessage() {
        return message;
    }
}
