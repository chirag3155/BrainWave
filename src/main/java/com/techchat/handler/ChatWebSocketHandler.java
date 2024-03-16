package com.techchat.handler;

//ChatWebSocketHandler.java


import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

 @Override
 protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
     // Handle incoming messages from clients
 }
}
