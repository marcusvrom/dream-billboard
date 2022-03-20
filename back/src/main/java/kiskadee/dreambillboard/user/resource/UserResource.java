package kiskadee.dreambillboard.user.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kiskadee.dreambillboard.user.DTO.UserDTO;
import kiskadee.dreambillboard.user.form.UserForm;
import kiskadee.dreambillboard.user.model.User;
import kiskadee.dreambillboard.user.service.UserService;

@RestController
@RequestMapping(path = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
		return this.userService.findById(id);
	}
	
	@GetMapping(path = "/user/{twitterUser}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable String twitterUser) {
		return this.userService.findByTwitterUser(twitterUser);
	}
	
	@PutMapping
	public ResponseEntity<User> createUser(@RequestBody UserForm userForm) {
		return this.userService.createUser(userForm);
	}

}
