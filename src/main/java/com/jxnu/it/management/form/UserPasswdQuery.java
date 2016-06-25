package com.jxnu.it.management.form;

/**
 * Date: 2016-02-21
 * PackageName: com.yunva.channel.admin.management.form
 */
//修改秘密查询
public class UserPasswdQuery {
	private String password;          //原始密码
	private String newPassword;       //新密码
	private String affirmPassword;    //确认密码

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getAffirmPassword() {
		return affirmPassword;
	}

	public void setAffirmPassword(String affirmPassword) {
		this.affirmPassword = affirmPassword;
	}

	@Override
	public String toString() {
		return "UserPasswdQuery{" +
				"password='" + password + '\'' +
				", newPassword='" + newPassword + '\'' +
				", affirmPassword='" + affirmPassword + '\'' +
				'}';
	}
}

