package com.techchat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techchat.model.User;
import com.techchat.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
//	

	@Autowired
	private static UserRepository userRepo;
// public User findUserProfile(String jwt) {
//	 return 
// };
////	
//	public User updateUser(Integer userId, UpdateUserRequest req) {
//		
//	}
	
	public User findUserById(Long userId)  {
		
		Optional<User> opt=userRepo.findById(userId);
		
		if(opt.isPresent()) {
			User user=opt.get();
			
			return user;
		}
	return null;
	}
//	
//	public List<User> searchUser(String query){
//		
//	}

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	public User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findUserByEmailAndPassword(email, password);
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public static  User findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userRepo.getById(userId);
	}

	

	

	

}
