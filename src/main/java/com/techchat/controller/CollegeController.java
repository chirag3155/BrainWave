package com.techchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.techchat.dto.CollegeDTO;
import com.techchat.model.College;
import com.techchat.repository.CollegeRepository;

@Controller
public class CollegeController {
	
	@Autowired
	private CollegeRepository collegeRepo;
	
	
	 @GetMapping("/colleges")
	    public String listChatRooms(Model model) {
		 List<College> colleges = collegeRepo.findAll();
		 model.addAttribute("colleges",colleges);
	        return "colleges"; // Display the list of chat rooms
	    }

	 @GetMapping("/colleges/register")
	    public String registerCollege(Model model) {
		  CollegeDTO collegeDTO = new CollegeDTO();
	    model.addAttribute("collegeDTO",collegeDTO);
	        return "collegeRegisterForm"; // Display the list of chat rooms
	    }
	 @PostMapping("/colleges/register")
	    public String createUserHandler(@ModelAttribute("collegeDTO") CollegeDTO collegeDTO,Model model)  {
	    	College savedCollege = null;
	    	System.out.println("Model ki valuee->>>"+model.getAttribute("userDTO"));
	        ResponseEntity<String> response = null;
	        College college = collegeDTO.toCollege();
	      
	        try {
	        	savedCollege = collegeRepo.save(college);
	            if (savedCollege.getId() > 0) {
	                response = ResponseEntity
	                        .status(HttpStatus.CREATED)
	                        .body("Given"+ college.getCollege_name()+"_>" + college.getAffiliation_number()+"->" + college.getChatRoom()+" details are successfully registered");
	            }
	        } catch (Exception ex) {
	            response = ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("An exception occured due to " + ex.getMessage());
	        }
	        model.addAttribute("response",response);
//	        model.addAttribute("user",user);
	        return "redirect:/colleges";
	    }
	 @GetMapping("/college/create-room")
	    public String showCreateRoomForm(Model model) {
//	    	System.out.println("User ki VALUEEE ->"+user.toString());
//	    	User user = userDTO.toUser();
	    	CollegeDTO collegeDTO = new CollegeDTO();
//	    	chatRoomDTO.setCreatedByUserId(user.getId());
//	    	userService.saveUser(user);
	        model.addAttribute("collegeDTO",collegeDTO);
	        System.out.println("PehleeId->"+collegeDTO.getChatRoomIds());
	        return "createRoomForm";
	    }
	   
	    @PostMapping("/college/create-room")
	    public String createRoom(@ModelAttribute("collegeDTO") CollegeDTO collegeDTO) {
	    	System.out.println("Post k andar chatRoomDTO ->"+ collegeDTO.toString());
	    	College college = collegeDTO.toCollege();
//	    	chatRoom.setCreated_by(UserService.findByUserId(chatRoomDTO.getCreatedByUserId()));
//	    	System.out.println("chatRoom.setCreated_by"+ UserService.findByUserId(chatRoomDTO.getCreatedByUserId()));
	    	System.out.println("RoomId(ROom banake)->"+college.getChatRoom().get(0));
//	    	System.out.println("Id->"+chatRoom.getRoomId());
	    	System.out.println("Id->"+college.getId());
//	    	collegeDTO.set
	    	
	    	System.out.println("Name->"+college.getCollege_name());
	    	collegeRepo.save(college);
	    	System.out.println("Id->"+college.getId());
//	        return "redirect:/chatroom/join/"+chatRoom.getRoomId();
	    	return "redirect:/colleges";
	    }

}
