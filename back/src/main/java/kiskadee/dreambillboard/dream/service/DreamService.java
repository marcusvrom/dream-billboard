package kiskadee.dreambillboard.dream.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kiskadee.dreambillboard.dream.DTO.DreamDTO;
import kiskadee.dreambillboard.dream.form.DreamForm;
import kiskadee.dreambillboard.dream.model.Dream;
import kiskadee.dreambillboard.dream.repository.DreamRepository;
import kiskadee.dreambillboard.user.model.User;
import kiskadee.dreambillboard.user.repository.UserRepository;

@Service
public class DreamService {
	
	@Autowired
	private DreamRepository dreamRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	public ResponseEntity<Page<DreamDTO>> findAll(Pageable pageable) {
		Page<Dream> dreams = this.dreamRepository.findAll(pageable);
		Page<DreamDTO> dreamsDTO = this.convertDTO(dreams);
		return ResponseEntity.ok().body(dreamsDTO);
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<DreamDTO> findById(Long id) {
		Optional<Dream> dreamOptional = this.dreamRepository.findById(id);
		if(!dreamOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		DreamDTO dreamDTO = new DreamDTO(dreamOptional.get());
		return ResponseEntity.ok().body(dreamDTO);
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<Page<DreamDTO>> findByUser(Pageable pageable, Long userId) {
		Page<Dream> dreams = this.dreamRepository.findAllByUserId(pageable, userId);
		Page<DreamDTO> dreamsDTO = this.convertDTO(dreams);
		return ResponseEntity.ok().body(dreamsDTO);
	}
	
	@Transactional
	public ResponseEntity<DreamDTO> createDream(DreamForm dreamForm) {
		Dream newDream = new Dream(dreamForm);
		if(dreamForm.getUser() != null) {
			Optional<User> userOptional = this.userRepository.findById(dreamForm.getUser());
			if(!userOptional.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			newDream.setUser(userOptional.get());
		}
		newDream.setLikes(0L);
		newDream = this.dreamRepository.save(newDream);
		return ResponseEntity.ok().body(new DreamDTO(newDream));
	}
	
	@Transactional
	public ResponseEntity<DreamDTO> likeDream(Long id) {
		Dream dream = this.dreamRepository.getById(id);
		dream.setLikes(dream.getLikes() + 1);
		dream = this.dreamRepository.save(dream);
		return ResponseEntity.ok().body(new DreamDTO(dream));
	}
	
	public Page<DreamDTO> convertDTO(Page<Dream> dreams) {
		Page<DreamDTO> dreamsDTO = dreams.map(d -> new DreamDTO(d));
		return dreamsDTO;
	}

}
