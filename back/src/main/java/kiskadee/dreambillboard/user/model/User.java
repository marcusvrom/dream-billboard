package kiskadee.dreambillboard.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import kiskadee.dreambillboard.user.form.UserForm;


@Entity
@Table(schema = "public", name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "twitter_user")
	@Size(max = 15, message = "The field twitterUser supports up to {max} characters!")
	private String twitterUser;
	
	public User() {}
	
	public User(Long id, String twitterUser) {
		this.id = id;
		this.twitterUser = twitterUser;
	}
	
	public User(UserForm userForm) {
		this.twitterUser = userForm.getTwitterUser();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTwitterUser() {
		return twitterUser;
	}

	public void setTwitterUser(String twitterUser) {
		this.twitterUser = twitterUser;
	}

}
