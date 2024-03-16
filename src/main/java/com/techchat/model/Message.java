package com.techchat.model;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;
	
	private LocalDateTime timeStamp;
	private Boolean is_read;
//	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="chat_id")
	@JsonIgnore
	private ChatRoom chatRoom;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
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

	public Boolean getIs_read() {
		return is_read;
	}

	public void setIs_read(Boolean is_read) {
		this.is_read = is_read;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

	public Message(Long id, String content, LocalDateTime timeStamp, Boolean is_read, ChatRoom chatRoom) {
		super();
		this.id = id;
		this.content = content;
		this.timeStamp = timeStamp;
		this.is_read = is_read;
		this.chatRoom = chatRoom;
	}

	@Override
	public String toString() {
	    return "Message [id=" + id + ", content=" + content + ", timeStamp=" + timeStamp + ", is_read=" + is_read + "]";
	}



	

}


