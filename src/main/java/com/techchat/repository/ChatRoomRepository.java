package com.techchat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchat.model.ChatRoom;
import com.techchat.model.User;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>{

	ChatRoom findByRoomId(String roomId);

//	public ChatRoom findByRoomId(String roomId);
//	public ChatRoom deleteByRoomId(String roomId);
	
//	public List<ChatRoom> findChatByUserId(Long userId);
	
//	public ChatRoom findSingleChatByUsersId(User user2, User reqUser);
}
