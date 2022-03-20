package kiskadee.dreambillboard.dream.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import kiskadee.dreambillboard.dream.model.Dream;
import kiskadee.dreambillboard.user.model.User;

public class DreamDTO {
	
	private Long id;

	private User user;
	
	private Long likes;

	private String title;
	
	private String details;

	private LocalDate dreamDate;

	private LocalDateTime postDate;
	
	public DreamDTO(Dream dream) {
		id = dream.getId();
		user = dream.getUser();
		likes = dream.getLikes();
		title = dream.getTitle();
		details = dream.getDetails();
		dreamDate = dream.getDreamDate();
		postDate = dream.getPostDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getDreamDate() {
		return dreamDate;
	}

	public void setDreamDate(LocalDate dreamDate) {
		this.dreamDate = dreamDate;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

}
