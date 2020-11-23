package dto;

public class memberDTO {
	String userId1;
	String userPw;
	String userName;
	String userBirth;
	String userGender;
	String userEmail;
	
	@Override
	public String toString() {
		return "memberDTO [userId1=" + userId1 + ", userPw=" + userPw + ", userName=" + userName + ", userBirth="
				+ userBirth + ", userGender=" + userGender + ", userEmail=" + userEmail + "]";
	}
	
	
	
	public String getUserId1() {
		return userId1;
	}
	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
