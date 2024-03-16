package com.techchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techchat.config.CustomUserDetailsService;
import com.techchat.dto.UserDTO;
import com.techchat.model.User;
import com.techchat.repository.UserRepository;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @GetMapping("/signup")
    public String doSignUp(Model model) {
    	UserDTO userDTO = new UserDTO();
    	model.addAttribute("userDTO",userDTO);
        return "signup";  
    }
    @PostMapping("/signup")
    public String createUserHandler(@ModelAttribute("userDTO") UserDTO userDTO,Model model)  {
    	User savedUser = null;
    	System.out.println("Model ki valuee->>>"+model.getAttribute("userDTO"));
        ResponseEntity<String> response = null;
        User user = userDTO.toUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	savedUser = userRepository.save(user);
            if (savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given"+ user.getUsername()+"_>" + user.getFirstName()+"->" + user.getEmail()+" details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        model.addAttribute("response",response);
        model.addAttribute("user",user);
        model.addAttribute("text",user.getUsername()+ "have succesfully registered!");
        return "redirect:/";
    }
    
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//    @PostMapping("/login")
//    public String login(@RequestParam("email") String email,
//                        @RequestParam("password") String password) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            // Authentication successful, set the user in the security context
//            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword(), user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return "redirect:/";
//        } else {
//            // Authentication failed, handle it appropriately
//            return "redirect:/auth/login?error";
//        }
//    }
//
//
//
//    @GetMapping("/admin")
//    public String getAdmin() {
//        return "Hello Admin";
//    }
}

