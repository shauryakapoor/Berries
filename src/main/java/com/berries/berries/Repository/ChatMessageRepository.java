package com.berries.berries.Repository;

import com.berries.berries.DTO.ChatMessageDTO;
import com.berries.berries.Entity.ChatMessageEntity;
import com.berries.berries.Enum.MessageStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository
        extends MongoRepository<ChatMessageDTO, String> {

    long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    List<ChatMessageEntity> findByChatId(String chatId);
}
