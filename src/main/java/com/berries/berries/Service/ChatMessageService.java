package com.berries.berries.Service;

import com.berries.berries.DTO.ChatMessageDTO;
import com.berries.berries.Entity.ChatMessageEntity;
import com.berries.berries.Enum.MessageStatus;
import com.berries.berries.Repository.ChatMessageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    ChatMessageRepository repository;

    public ChatMessageDTO save(ChatMessageDTO chatMessageDTO) {
        ChatMessageEntity chatMessageEntity = new ChatMessageEntity();
        BeanUtils.copyProperties(chatMessageDTO, chatMessageEntity);
        chatMessageEntity.setStatus(MessageStatus.RECEIVED);
        ChatMessageEntity chatMessageEntityResult = repository.save(chatMessageEntity);
        ChatMessageDTO chatMessageDTOResult = new ChatMessageDTO();
        BeanUtils.copyProperties(chatMessageEntityResult, chatMessageDTOResult);
        return chatMessageDTOResult;
    }
}
