package com.techchat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchat.model.ChatRoom;
import com.techchat.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

//	Message save(String message);
//	Message findByRoomId(String roomId);

	List<Message> findByChatRoom(ChatRoom chatRoom);

	List<Message> findByChatRoom(String roomId);

	
}
