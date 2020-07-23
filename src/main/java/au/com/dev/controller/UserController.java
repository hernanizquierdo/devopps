package au.com.dev.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.dev.dto.User;

//@CrossOrigin(origins = "*")
@RestController
//@RequestMapping({ "/users" })
public class UserController  {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(produces = "application/json")
	public List<User> getUsers() throws Exception {
		try {
			return (List<User>) userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
		} catch (Exception ex) {
			throw new Exception("Users.", ex);
		}
	}

	@PostMapping
	void addUser(@RequestBody User user) throws Exception {
		try {
			userRepository.save(user);
		} catch (Exception ex) {
			throw new Exception("Users.", ex);
		}

	}

	@DeleteMapping(path = { "/{id}" })
	public Boolean delete(@PathVariable("id") Long id) {
		System.out.println("Delete id: " + id);
		try {
			userRepository.deleteById(id);
			System.out.println("Successfuly removed [User.id] : " + id);
			return true;
		} catch (Exception e) {
			System.err.println("Error deleting DTO [User.id] : " + id);
			return false;
		}
	}
	
}
