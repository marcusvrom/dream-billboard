package kiskadee.dreambillboard.user.form;

import kiskadee.dreambillboard.user.model.User;

public class UserForm {

	private String twitterUser;
	
	public UserForm() {}
	
	public UserForm(User user) {
		twitterUser = user.getTwitterUser();
	}

	public String getTwitterUser() {
		return twitterUser;
	}

	public void setTwitterUser(String twitterUser) {
		this.twitterUser = twitterUser;
	}
}
