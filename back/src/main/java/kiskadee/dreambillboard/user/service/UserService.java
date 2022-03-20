package kiskadee.dreambillboard.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kiskadee.dreambillboard.user.DTO.UserDTO;
import kiskadee.dreambillboard.user.form.UserForm;
import kiskadee.dreambillboard.user.model.User;
import kiskadee.dreambillboard.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public ResponseEntity<UserDTO> findById(Long id) {
		Optional<User> userOptional = this.userRepository.findById(id);
		if(!userOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		UserDTO userDTO = new UserDTO(userOptional.get());
		return ResponseEntity.ok().body(userDTO);
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<UserDTO> findByTwitterUser(String twitterUser) {
		Optional<User> userOptional = this.userRepository.findByTwitterUser(twitterUser);
		if(!userOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		UserDTO userDTO = new UserDTO(userOptional.get());
		return ResponseEntity.ok().body(userDTO);
	}
	
	@Transactional
	public ResponseEntity<User> createUser(UserForm userForm) {
		if(this.userRepository.findByTwitterUser(userForm.getTwitterUser()).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		User newUser = new User(userForm);
		newUser = this.userRepository.save(newUser);		
		return ResponseEntity.ok().body(newUser);
	}

}
