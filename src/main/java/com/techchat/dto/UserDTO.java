package com.techchat.dto;

import java.util.List;

import com.techchat.model.User;

public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private List<String> chatRoomIds;
    private List<Long> messageIds;
    
    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        // Set other properties of User entity as needed
        return user;
    }
    // Constructors
    public UserDTO() {
    }

   

    @Override
	public String toString() {
		return "UserDTO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + ", chatRoomIds=" + chatRoomIds + ", messageIds=" + messageIds + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDTO(String username, String firstName, String lastName, String password, String email,
			List<String> chatRoomIds, List<Long> messageIds) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.chatRoomIds = chatRoomIds;
		this.messageIds = messageIds;
	}
	// Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getChatRoomIds() {
        return chatRoomIds;
    }

    public void setChatRoomIds(List<String> chatRoomIds) {
        this.chatRoomIds = chatRoomIds;
    }

    public List<Long> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<Long> messageIds) {
        this.messageIds = messageIds;
    }
}
