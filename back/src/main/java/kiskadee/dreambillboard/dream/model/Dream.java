package kiskadee.dreambillboard.dream.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import kiskadee.dreambillboard.dream.form.DreamForm;
import kiskadee.dreambillboard.user.model.User;

@Entity
@Table(schema = "public", name = "tb_dream")
public class Dream {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", unique = true)
	private User user;
	
	private Long likes;
	
	@Column(name = "dream_title")
	@Size(max = 255, message = "The field dream_title supports up to {max} characters!")
	private String title;
	
	@Column(name = "dream_details")
	@Size(max = 255, message = "The field dream_details supports up to {max} characters!")
	private String details;
	
	@Column(name = "dream_date")
	private LocalDate dreamDate;
	
	@Column(name = "post_date")
	private LocalDateTime postDate;
	
	public Dream() {}

	public Dream(Long id, User user, Long likes, String title, String details, LocalDate dreamDate,
			LocalDateTime postDate) {
		this.id = id;
		this.user = user;
		this.likes = likes;
		this.title = title;
		this.details = details;
		this.dreamDate = dreamDate;
		this.postDate = postDate;
	}
	
	public Dream(DreamForm dreamForm) {
		title = dreamForm.getTitle();
		details = dreamForm.getDetails();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dreamDate = LocalDate.parse(dreamForm.getDreamDate(), formatter);
		postDate = LocalDateTime.now().withSecond(0).withNano(0);
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
