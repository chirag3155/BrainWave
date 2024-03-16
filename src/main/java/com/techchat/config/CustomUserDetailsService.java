package com.techchat.config;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techchat.repository.UserRepository;




@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		
		   this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		String userName, password;
		List<GrantedAuthority> authorities;
		        com.techchat.model.User user = userRepository.findByEmail(email);
		        
		        if (user==null) {
		            throw new UsernameNotFoundException("User not found with username: " + email);
		        }
		        else{
		            userName = user.getEmail();
		            password = user.getPassword();
		            authorities = new ArrayList<>();
		        }
		       
		        
		        return new User(user.getEmail(), user.getPassword(), authorities);
		    }
		

	}


