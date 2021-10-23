package com.berries.berries.Service;

import com.berries.berries.DTO.ChatMessageDTO;
import com.berries.berries.Entity.ChatMessageEntity;
import com.berries.berries.Enum.MessageStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    public ChatMessageDTO save(ChatMessageDTO chatMessageDTO) {
        ChatMessageEntity chatMessageEntity = new ChatMessageEntity();
        BeanUtils.copyProperties(chatMessageDTO, chatMessageEntity);
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }
}
