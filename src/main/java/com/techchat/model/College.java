package com.techchat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String college_name;
	private String college_image;
	private Long affiliation_number;
	
	@OneToMany
	@JsonIgnore
	private List<User> user;

	@OneToMany(mappedBy="college")
	@JsonIgnore
	private List<ChatRoom> chatRoom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getCollege_image() {
		return college_image;
	}

	public void setCollege_image(String college_image) {
		this.college_image = college_image;
	}

	public Long getAffiliation_number() {
		return affiliation_number;
	}

	public void setAffiliation_number(Long affiliation_number) {
		this.affiliation_number = affiliation_number;
	}

	

	

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<ChatRoom> getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(List<ChatRoom> chatRoom) {
		this.chatRoom = chatRoom;
	}

	public College() {
		
	}

	
	public College(Long id, String college_name, String college_image, Long affiliation_number, List<User> user,
			List<ChatRoom> chatRoom) {
		super();
		this.id = id;
		this.college_name = college_name;
		this.college_image = college_image;
		this.affiliation_number = affiliation_number;
		this.user = user;
		this.chatRoom = chatRoom;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", college_name=" + college_name + ", college_image=" + college_image
				+ ", affiliation_number=" + affiliation_number + ", user=" + user + ", chatRoom=" + chatRoom + "]";
	}


	

}
