package com.techchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchat.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	User findByEmail(String email);

	User findUserByEmailAndPassword(String email, String password);

//	@Query("select c from Chat c join c.users u where u.id=:userId")
//	public List<ChatRoom> findChatByUserId(Integer userId);
//	
//	@Query("select c from Chat c Where c.is_group=false And :user Member of c.users And :reqUser Member of c.users")
//	public ChatRoom findSingleChatByUsersId(@Param("user")User user, @Param("reqUser")User reqUser);
}
