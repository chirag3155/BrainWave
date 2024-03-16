package com.techchat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//RoomService.java



import org.springframework.stereotype.Service;

import com.techchat.model.ChatRoom;
import com.techchat.model.User;
import com.techchat.repository.ChatRoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private ChatRoomRepository chatRoomRepo;
	@Autowired
	private UserService userService;
	
	

 public List<ChatRoom> getChatRooms() {
     return chatRoomRepo.findAll();
 }
// public ChatRoom createSingleChatRoom(User reqUser, Long userId2) {
//		
////		User reqUser=userService.findUserById(userId);
//		User user2 = userService.findUserById(userId2);
//		
////		System.out.println("before isChatExist");
//		
//		ChatRoom isChatExist = chatRoomRepo.findSingleChatByUsersId(user2, reqUser);
//		
////		System.out.println("isChatExist ----------------------------- "+isChatExist);
//		
//		if(isChatExist!=null) {
//			return isChatExist;
//		}
//		
//		ChatRoom chatRoom=new ChatRoom();
//		
//		chatRoom.setCreated_by(reqUser);
//		chatRoom.getUsers().add(reqUser);
//		chatRoom.getUsers().add(user2);
//		chatRoom.setIs_group(false);
//		
////		System.out.println("chat ----------------------------- "+chat);
//		ChatRoom createdChat = chatRoomRepo.save(chatRoom);
//		
////		
//		
//		return createdChat;
//}
//// public ChatRoom createGroupChatRoom(GroupChatRequest req, Long reqUser) {
////     return chatRoomRepo.save(req.getChat_name());
//// }
// public ChatRoom getChatRoomById(String roomId) {
//     // TODO: Implement the logic to retrieve a ChatRoom by its ID
//	 return chatRoomRepo.findByRoomId(roomId);
//     // If no ChatRoom with the specified ID is found, you may return null or throw an exception
// }
//
//public void deleteChatRoom(String roomId) {
//	// TODO Auto-generated method stub
//	chatRoomRepo.deleteByRoomId(roomId);
//	
//}

//public void removeUserFromChatRoom(String roomId, Long userId,Long reqUser) {
//    ChatRoom chatRoom = chatRoomRepo.getByRoomId(roomId);
//    if (chatRoom != null) {
//        User user = userRepo.getById(userId);
//        if (user != null) {
//            chatRoom.getUsers().remove(user);
//            chatRoomRepo.save(chatRoom);
//        } else {
//            // Handle the case where the user doesn't exist
//            throw new IllegalArgumentException("User with ID " + userId + " does not exist");
//        }
//    } else {
//        // Handle the case where the chat room doesn't exist
//        throw new IllegalArgumentException("Chat room with ID " + roomId + " does not exist");
//    }
//    
//}

public void updateChatRoom(ChatRoom updatedChatRoom) {
    // Retrieve the existing chat room from the database
    ChatRoom existingChatRoom = chatRoomRepo.findById(updatedChatRoom.getId())
            .orElseThrow(() -> new IllegalArgumentException("Chat room not found with ID: " + updatedChatRoom.getId()));

    // Update the existing chat room with the new information
    existingChatRoom.setChat_name(updatedChatRoom.getChat_name());
//    existingChatRoom.setDescription(updatedChatRoom.getDescription());
//    existingChatRoom.setType(updatedChatRoom.getType());
    // Add other fields to update as needed

    // Save the updated chat room back to the database
    chatRoomRepo.save(existingChatRoom);
}
 // Other methods for joining rooms, sending messages, etc.

public ChatRoom findByRoomId(String roomId) {
	// TODO Auto-generated method stub
	return chatRoomRepo.findByRoomId(roomId);
}
public ChatRoom saveChatRoom(ChatRoom chatRoom) {
	// TODO Auto-generated method stub
	return chatRoomRepo.save(chatRoom);
}
//public ChatRoom findByRoomId(String roomId) {
//	// TODO Auto-generated method stub
//	return null;
//}

public ChatRoom createRoom(ChatRoom chatRoom) {
	return chatRoomRepo.save(chatRoom);
	
}

public void deleteChatRoom(ChatRoom chatRoom) {
	 chatRoomRepo.delete(chatRoom);
	
}

}
