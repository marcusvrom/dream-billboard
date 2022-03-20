package kiskadee.dreambillboard.dream.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kiskadee.dreambillboard.dream.DTO.DreamDTO;
import kiskadee.dreambillboard.dream.form.DreamForm;
import kiskadee.dreambillboard.dream.service.DreamService;

@RestController
@RequestMapping(path = "/v1/dreams", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
public class DreamResource {

	@Autowired
	private DreamService dreamService;
	
	@GetMapping
	public ResponseEntity<Page<DreamDTO>> findAllDreams(@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable) {
		return this.dreamService.findAll(pageable);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<DreamDTO> findDreamById(@PathVariable Long id) {
		return this.dreamService.findById(id);
	}
	
	@GetMapping(path = "/user/{userId}")
	public ResponseEntity<Page<DreamDTO>> findAllDreamsByUserId(Pageable pageable, @PathVariable Long userId) {
		return this.dreamService.findByUser(pageable, userId);
	}
	
	@PostMapping
	public ResponseEntity<DreamDTO> createDream(@RequestBody DreamForm dreamForm) {
		return this.dreamService.createDream(dreamForm);
	}
	
	@PutMapping(path = "/likes/{id}")
	public ResponseEntity<DreamDTO> likeDream(@PathVariable Long id) {
		return this.dreamService.likeDream(id);
	}
}
