package com.berries.berries.Service;

import com.berries.berries.Entity.ChatRoomEntity;
import com.berries.berries.Repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {
    ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatId(String senderId, String recipientId) {
        Optional<ChatRoomEntity> optionalChatRoomEntity =
                chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);

        return optionalChatRoomEntity.map(ChatRoomEntity::getChatId);
    }
}
