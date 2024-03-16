package com.techchat.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ChatRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String chat_name;
	private String chat_image;
	@Column(unique = true) // Ensures roomId is unique
    private String roomId;
	@ManyToMany( fetch = FetchType.EAGER)
	private Set<User> admins=new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private  College college;
	private Boolean is_group;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User created_by;
//	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		    name = "chatroom_users",
		    joinColumns = @JoinColumn(name = "chat_id"),
		    inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private Set<User> users = new HashSet<>();

	@OneToMany(mappedBy="chatRoom",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Message> messages=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChat_name() {
		return chat_name;
	}

	public void setChat_name(String chat_name) {
		this.chat_name = chat_name;
	}

	public String getChat_image() {
		return chat_image;
	}

	public void setChat_image(String chat_image) {
		this.chat_image = chat_image;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Set<User> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<User> admins) {
		this.admins = admins;
	}

	public Boolean getIs_group() {
		return is_group;
	}

	public void setIs_group(Boolean is_group) {
		this.is_group = is_group;
	}

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}


	public ChatRoom(Long id, String chat_name, String chat_image, String roomId, Set<User> admins, College college,
			Boolean is_group, User created_by, Set<User> users, List<Message> messages) {
		super();
		this.id = id;
		this.chat_name = chat_name;
		this.chat_image = chat_image;
		this.roomId = roomId;
		this.admins = admins;
		this.college = college;
		this.is_group = is_group;
		this.created_by = created_by;
		this.users = users;
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "ChatRoom [id=" + id + ", chat_name=" + chat_name + ", chat_image=" + chat_image + ", roomId=" + roomId
				+ ", admins=" + admins + ", is_group=" + is_group + ", created_by=" + created_by + ", users=" + users
				+ ", messages=" + messages + "]";
	}
	

public ChatRoom() {
	
}

}
