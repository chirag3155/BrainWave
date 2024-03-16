//package com.techchat.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.techlopedia.model.ChatRoom;
//import com.techlopedia.model.Message;
//import com.techlopedia.model.User;
//import com.techlopedia.service.MessageService;
//
//import ch.qos.logback.core.model.Model;
//
//@Controller
//@RequestMapping("/chatRoom/{roomId}/messages")
//public class MessageController {
//
//    @Autowired
//    private MessageService messageService;
//
//    @PostMapping("/send")
//    public String sendMessage(@PathVariable("roomId") Long roomId, @RequestParam("content") String content) {
//        // Add logic to send a message to the specified room
//        User currentUser = userService.getCurrentUser(); // Assuming you have a method to get the current user
//        ChatRoom chatRoom = chatRoomService.getChatRoomById(roomId);
//        if (chatRoom != null) {
//            Message message = new Message(currentUser, content);
//            chatRoomService.sendMessage(chatRoom, message);
//        }
//        return "redirect:/chatRoom/" + roomId; // Redirect to the chat room page
//    }
//    @PostMapping("/{messageId}/update")
//    public String updateMessage(@PathVariable("roomId") Long roomId, @PathVariable("messageId") Long messageId, @RequestParam("content") String content) {
//        // Add logic to update the message content
//        messageService.updateMessageContent(messageId, content);
//        return "redirect:/chatRoom/" + roomId; // Redirect to the chat room page
//    }
//    @GetMapping("/search")
//    public String searchMessages(@PathVariable("roomId") Long roomId, @RequestParam("query") String query, Model model) {
//        ChatRoom chatRoom = chatRoomService.getChatRoomById(roomId);
//        if (chatRoom != null) {
//            List<Message> messages = messageService.searchMessages(chatRoom, query);
//            model.addAttribute("messages", messages);
//            return "messageList"; // Display the list of messages in the chat room
//        } else {
//            return "redirect:/"; // Redirect to the homepage if the room doesn't exist
//        }
//
//    // Other methods for managing messages in a specific chat room
//}
