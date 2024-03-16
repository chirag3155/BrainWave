package com.techchat.dto;

import java.util.List;
import java.util.UUID;

import com.techchat.model.ChatRoom;

public class ChatRoomDTO {
   
	 private String chatName;
	    private String chatImage;
	    private String roomId;
	    private Boolean isGroup;
	    private List<Long> messageIds;
	    private Long createdByUserId;
	    private List<Long> adminUserIds;
	    private List<Long> userIds;

    public ChatRoomDTO() {
    	this.roomId = UUID.randomUUID().toString();
    }

    


    public ChatRoomDTO(String chatName, String chatImage, String roomId, Boolean isGroup, List<Long> messageIds,
			Long createdByUserId, List<Long> adminUserIds, List<Long> userIds) {
		super();
		this.chatName = chatName;
		this.chatImage = chatImage;
		this.roomId = roomId;
		this.isGroup = isGroup;
		this.messageIds = messageIds;
		this.createdByUserId = createdByUserId;
		this.adminUserIds = adminUserIds;
		this.userIds = userIds;
	}




	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public List<Long> getAdminUserIds() {
		return adminUserIds;
	}

	public void setAdminUserIds(List<Long> adminUserIds) {
		this.adminUserIds = adminUserIds;
	}

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

	public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatImage() {
        return chatImage;
    }

    public void setChatImage(String chatImage) {
        this.chatImage = chatImage;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Boolean isGroup) {
        this.isGroup = isGroup;
    }

    public List<Long> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<Long> messageIds) {
        this.messageIds = messageIds;
    }

    public ChatRoom toChatRoom() {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setChat_name(chatName);
        chatRoom.setChat_image(chatImage);
        chatRoom.setRoomId(roomId);
        chatRoom.setIs_group(isGroup);
        // Set other properties of ChatRoom entity as needed

        return chatRoom;
    }
}
