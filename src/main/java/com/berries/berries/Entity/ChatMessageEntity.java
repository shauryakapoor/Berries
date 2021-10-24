package com.berries.berries.Entity;

import com.berries.berries.Enum.MessageStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class ChatMessageEntity {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String senderName;
    private String recipientName;
    private String content;
    private Date timestamp;
    private MessageStatus status;
}
