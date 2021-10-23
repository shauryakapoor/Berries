package com.berries.berries.Controller;

import com.berries.berries.DTO.ChatMessageDTO;
import com.berries.berries.DTO.ChatNotificationDTO;
import com.berries.berries.Service.ChatMessageService;
import com.berries.berries.Service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired private ChatMessageService chatMessageService;
    @Autowired private ChatRoomService chatRoomService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDTO chatMessageDTO) {
        var chatId = chatRoomService
                .getChatId(chatMessageDTO.getSenderId(), chatMessageDTO.getRecipientId());
        chatMessageDTO.setChatId(chatId.get());

        ChatMessageDTO saved = chatMessageService.save(chatMessageDTO);

        messagingTemplate.convertAndSendToUser(
                chatMessageDTO.getRecipientId(),"/queue/messages",
                new ChatNotificationDTO(
                        saved.getId(),
                        saved.getSenderId(),
                        saved.getSenderName()));
    }
}
