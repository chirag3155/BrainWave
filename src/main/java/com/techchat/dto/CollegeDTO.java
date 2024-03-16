package com.techchat.dto;

import java.util.List;

import com.techchat.model.College;

public class CollegeDTO {
    private String collegeName;
    private String collegeImage;
    private Long affiliationNumber;
    private List<String> chatRoomIds;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeImage() {
        return collegeImage;
    }

    public void setCollegeImage(String collegeImage) {
        this.collegeImage = collegeImage;
    }

    public Long getAffiliationNumber() {
        return affiliationNumber;
    }

    public void setAffiliationNumber(Long affiliationNumber) {
        this.affiliationNumber = affiliationNumber;
    }
    
  
	public List<String> getChatRoomIds() {
		return chatRoomIds;
	}

	public void setChatRoomIds(List<String> chatRoomIds) {
		this.chatRoomIds = chatRoomIds;
	}

	public CollegeDTO() {
    	
    }
    public College toCollege() {
        College college = new College();
        college.setCollege_name(collegeName);
        college.setCollege_image(collegeImage);
        college.setAffiliation_number(affiliationNumber);
        // If you have any relationships with other entities, you need to handle them here

        return college;
    }
}
