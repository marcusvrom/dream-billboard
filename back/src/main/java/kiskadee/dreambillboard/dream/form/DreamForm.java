package kiskadee.dreambillboard.dream.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import kiskadee.dreambillboard.dream.model.Dream;

public class DreamForm {
	
	private Long user;

	@NotEmpty(message = "The title field can't be empty/null!")
	private String title;

	private String details;
	
	private String dreamDate;
	
	public DreamForm() {}
	
	public DreamForm(Dream dream) {
		user = dream.getUser().getId();
		title = dream.getTitle();
		details = dream.getDetails();
		dreamDate = dream.getDreamDate().toString();
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
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

	public String getDreamDate() {
		return dreamDate;
	}

	public void setDreamDate(String dreamDate) {
		this.dreamDate = dreamDate;
	}
	
}
