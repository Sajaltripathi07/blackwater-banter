package com.goldencat.chatroom.model;

/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/

import org.springframework.boot.autoconfigure.web.WebProperties;


public class ChatMessage {

    private String username;
    private String content;

    public ChatMessage() {}

    public ChatMessage(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}