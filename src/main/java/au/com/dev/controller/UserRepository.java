package au.com.dev.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import au.com.dev.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT usr FROM User usr where usr.username = :username and usr.password = :password") 
    User validateLogin(@Param("username") String username, @Param("password") String password);
}
