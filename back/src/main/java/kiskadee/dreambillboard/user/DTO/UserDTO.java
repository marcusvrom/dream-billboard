package kiskadee.dreambillboard.user.DTO;

import kiskadee.dreambillboard.user.model.User;

public class UserDTO {

	private Long id;

	private String twitterUser;
	
	public UserDTO(User user) {
		id = user.getId();
		twitterUser = user.getTwitterUser();
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
