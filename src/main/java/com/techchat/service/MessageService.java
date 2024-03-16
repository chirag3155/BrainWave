package com.techchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchat.model.ChatRoom;
import com.techchat.model.Message;
import com.techchat.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}
//	public List<Message> findByRoomId(String roomId) {
//		return messageRepository.findByChatRoom(roomId);
//	}
	public List<Message> fetchMessagesRoomId(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return messageRepository.findByChatRoom(chatRoom);
	}
	public List<Message> getMessagesRoomId(String roomId) {
		// TODO Auto-generated method stub
		return messageRepository.findByChatRoom(roomId);
	}
//	public List<Message> getMessagesRoomId(String roomId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
