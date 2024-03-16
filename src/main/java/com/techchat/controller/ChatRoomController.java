package com.techchat.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.techchat.dto.ChatRoomDTO;
import com.techchat.dto.MessageDTO;
import com.techchat.dto.UserDTO;
import com.techchat.model.ChatRoom;
import com.techchat.model.Message;
import com.techchat.model.User;
import com.techchat.service.MessageService;
import com.techchat.service.RoomService;
import com.techchat.service.UserService;

@Controller
//@RequestMapping("/chatrooms")
public class ChatRoomController {
	
	 @Autowired
	    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private RoomService chatRoomService;
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;
    @GetMapping("/")
    public String listChatRooms(Model model) {
    	
        List<ChatRoom> chatRooms = chatRoomService.getChatRooms();
        ChatRoom room1 = new ChatRoom();
//        room1.setChat_name("Room 1");
//        room1.setChat_image("image1.jpg");
//        room1.setRoomId("room1");
//        room1.setIs_group(false);
////        room1.setCreated_by(user1);
//        chatRooms.add(room1);
        model.addAttribute("chatRooms", chatRooms);
        return "index"; // Display the list of chat rooms
    }
    @GetMapping("/private")
    public String privateIndex(Model model) {
    	
        List<ChatRoom> rooms = chatRoomService.getChatRooms();
        List<ChatRoom> chatRooms = rooms.subList(8, rooms.size());
        ChatRoom room1 = new ChatRoom();
//        room1.setChat_name("Room 1");
//        room1.setChat_image("image1.jpg");
//        room1.setRoomId("room1");
//        room1.setIs_group(false);
////        room1.setCreated_by(user1);
//        chatRooms.add(room1);
        model.addAttribute("chatRooms", chatRooms);
        System.out.println("chatroom ka pehla admi"+chatRooms.get(0).getRoomId());
        return "privateIndex"; // Display the list of chat rooms
    }
    @GetMapping("/chatroom/join/{roomId}")
    public String joinChatRoom(@PathVariable String roomId,Model model) {
    	System.out.println("Pehle join se pehle Id ->"+ roomId);
    	
//    	System.out.println("Model KI VALUE ->"+model.getAttribute("jwtToken"));
    	MessageDTO messageDTO = new MessageDTO();
    	ChatRoom chatRoom = chatRoomService.findByRoomId(roomId);
    	System.out.println("Pehle join kai baad Id ->"+ chatRoom.getRoomId());
    	System.out.println("Yhe kaam kr gya");
    	 List<Message> messages = new ArrayList<>();
    	    // Check if the chatRoom is not null
    	    if (chatRoom != null) {
    	        // If the chatRoom is valid, fetch messages for the ro
    	    	 messages =  messageService.fetchMessagesRoomId(chatRoom);
    	        // Iterate through the messages
    	        for (Message message : messages) {
    	            System.out.println("Message: " + message.getContent());
    	        }
    	    } else {
    	        // Handle the case where the chatRoom is null (not found)
//    	    	return "redirect:/home"
    	        System.out.println("ChatRoom not found for roomId: " + roomId);
    	    }
    	    
    	model.addAttribute("roomId",roomId);
    	String chat_name = chatRoom.getChat_name();
    	model.addAttribute("chat_name",chat_name);
    	chatRoom.getChat_name();   
    	model.addAttribute("messages",messages);
    	model.addAttribute("messageDTO",messageDTO);
//    	model.addAttribute("messages",messages);
        // Add logic to join the chat room based on the provided room ID
        // Assuming you want to redirect to a URL like /chatroom/{roomId}
    	System.out.println("YGet hai bhaii");
        return "joinedRoom" ; // Redirect to the chat room page after joining
    }
    @MessageMapping("/chatroom/{roomId}/sendMessage")
    @SendTo("/topic/chatroom/{roomId}")
    public Message sendMessage(@ModelAttribute MessageDTO messageDTO, @DestinationVariable String roomId,@ModelAttribute("chatRoomDTO") ChatRoomDTO chatRoomDTO) {
    	System.out.println("MESSAGEDTO KI VALUE ->"+messageDTO.toString());
//    	System.out.println("Model KI VALUE ->"+model.getAttribute("roomId"));
//    	System.out.println("JWT TOKEN KI VALUE ->"+jwtToken);
    	Message message = messageDTO.toMessage();
    	System.out.println("MESSAGE KI VALUE ->"+message.toString());
    	ChatRoom chatRoom = chatRoomService.findByRoomId(roomId);
    	System.out.println("chatroommmm KI VALUE ->"+chatRoom.toString());
    	System.out.println("IDDDD KI VALUE ->"+roomId);
//    	chatRoomService.saveChatRoom(chatRoom);
//    	ChatRoom chatRoom = chatRoomService.findByRoomId(roomId);
    	message.setChatRoom(chatRoom);
    	System.out.println("MESSAGEDTO KI VALUE ->"+message.toString());
    	messageService.saveMessage(message);
    	  System.out.println("Sending message...");
    	  System.out.println("Sending message..." + message.toString());
    	  System.out.println("Details-> "+ message.toString());
        return message;
    }
    @GetMapping("/chatroom/create-room")
    public String showCreateRoomForm(Model model) {
//    	System.out.println("User ki VALUEEE ->"+user.toString());
//    	User user = userDTO.toUser();
    	ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
//    	chatRoomDTO.setCreatedByUserId(user.getId());
//    	userService.saveUser(user);
        model.addAttribute("chatRoomDTO",chatRoomDTO);
        System.out.println("PehleeId->"+chatRoomDTO.getRoomId());
        return "createRoomForm";
    }
   
    @PostMapping("/chatroom/create-room")
    public String createRoom(@ModelAttribute("chatRoomDTO") ChatRoomDTO chatRoomDTO) {
    	System.out.println("Post k andar chatRoomDTO ->"+ chatRoomDTO.toString());
    	ChatRoom chatRoom = chatRoomDTO.toChatRoom();
//    	chatRoom.setCreated_by(UserService.findByUserId(chatRoomDTO.getCreatedByUserId()));
//    	System.out.println("chatRoom.setCreated_by"+ UserService.findByUserId(chatRoomDTO.getCreatedByUserId()));
    	System.out.println("RoomId(ROom banake)->"+chatRoom.getRoomId());
    	System.out.println("Id->"+chatRoom.getRoomId());
    	System.out.println("Id->"+chatRoom.getId());
    	
    	System.out.println("Name->"+chatRoom.getChat_name());
    	chatRoomService.createRoom(chatRoom);
    	System.out.println("Id->"+chatRoom.getId());
//        return "redirect:/chatroom/join/"+chatRoom.getRoomId();
    	return "redirect:/private";
    }
    @GetMapping("/chatroom/delete/{roomId}")
    public String deleteChatRoom(@PathVariable String roomId) {
    	ChatRoom chatRoom = chatRoomService.findByRoomId(roomId);
        chatRoomService.deleteChatRoom(chatRoom);
        return "redirect:/private"; // Redirect to list of chat rooms after deleting chat room
    }
//
//    @GetMapping("/chatroom/create")
//    public String showCreateChatRoomForm(Model model) {
//    	ChatRoom chatRoom = new ChatRoom();
//        model.addAttribute("chatRoom", chatRoom);
//        return "createChatRoom"; // Return the HTML template for creating a chat room
//    }
//
//    @PostMapping("/chatroom/create")
//    public String createChatRoom(@ModelAttribute("chatRoom") ChatRoom chatRoom) {
////        chatRoomService.createSingleChatRoom(chatRoom);
//        return "redirect:/"; // Redirect to list of chat rooms after creating chat room
//    }

   
//    @Message
  
//    @PostMapping("/chatroom/{roomId}/sendMessage")
//    public String sendMessage(@PathVariable String roomId, @RequestParam("message") String message, Model model) {
//        // Process the received message (e.g., save it to the database)
//        // You can add more logic here as needed
//        System.out.println("Sending message...");
//
//        // Save the message to the database
//        Message content = new Message();
//        content.setContent(message);
//        messageService.saveMessage(content);
//
//        // Retrieve the updated list of messages for the room
//        List<Message> messages = messageService.findByRoomId(roomId);
//        model.addAttribute("message", messages);
//
//        // Send the message to the specified room ID
//        messagingTemplate.convertAndSend("/topic/chat/" + roomId, message);
//
//        // Redirect back to the chat room page after sending the message
//        return "redirect:/chatroom/join/" + roomId;
//    }

//    @GetMapping("/chatroom/leave/{roomId}/{userId}")
//    public String leaveChatRoom(@PathVariable String roomId, @PathVariable Long userId) {
//        // Add logic to leave the chat room based on the provided room ID
//    	ChatRoom chatRoom = chatRoomService.getChatRoomById(roomId);
////    	chatRoomService.removeUserFromChatRoom(roomId, userId);
//        return "redirect:/"; // Redirect to list of chat rooms after leaving chat room
//    }
//
//    @GetMapping("/chatroom/update/{roomId}")
//    public String showUpdateChatRoomForm(@PathVariable String roomId, Model model) {
//        // Retrieve the chat room details from the service based on the provided room ID
//        ChatRoom chatRoom = chatRoomService.getChatRoomById(roomId);
//
//        // Add the chat room object to the model for rendering in the update form
//        model.addAttribute("chatRoom", chatRoom);
//
//        // Return the name of the HTML template (Thymeleaf) used for updating chat rooms
//        return "updateChatRoom"; // Update this to the appropriate HTML template name
//    }
//
//    @PostMapping("/chatroom/update")
//    public String updateChatRoom(@ModelAttribute("chatRoom") ChatRoom updatedChatRoom) {
//        chatRoomService.updateChatRoom(updatedChatRoom);
//        return "redirect:/chatrooms/list"; // Redirect to the list of chat rooms after updating
//    }
    // Other methods for managing chat rooms
}

