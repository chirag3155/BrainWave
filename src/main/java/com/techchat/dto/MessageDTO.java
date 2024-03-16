package com.techchat.dto;

import java.time.LocalDateTime;

import com.techchat.model.Message;

public class MessageDTO {
   
	private String content;
    private LocalDateTime timeStamp;
    private Boolean isRead;
    private Long userId;
    private String chatRoomId;

    public MessageDTO() {
    }

    // Getters and setters for all fields

  

    public String getContent() {
        return content;
    }

   
	

	@Override
	public String toString() {
		return "MessageDTO [content=" + content + ", timeStamp=" + timeStamp + ", isRead=" + isRead + ", userId="
				+ userId + ", chatRoomId=" + chatRoomId + "]";
	}

	public MessageDTO(String content, LocalDateTime timeStamp, Boolean isRead, Long userId, String chatRoomId) {
		super();
		this.content = content;
		this.timeStamp = timeStamp;
		this.isRead = isRead;
		this.userId = userId;
		this.chatRoomId = chatRoomId;
	}

	public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
    
    public Message toMessage() {
        Message message = new Message();
       
        message.setContent(content);
        message.setTimeStamp(timeStamp);
        message.setIs_read(isRead);

        // You should handle setting the User and ChatRoom entities here
        // Assuming you have appropriate services to retrieve them
        
        return message;
    }
}

