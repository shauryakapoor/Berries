package com.berries.berries.Repository;

import com.berries.berries.Entity.ChatRoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoomEntity, String> {
    Optional<ChatRoomEntity> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
