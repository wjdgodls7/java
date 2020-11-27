package Bean;

public class UserInfoBean {
private String memberId;
private String memberPwd;
private String memberName;
private String memberAdd;
private String userGender;
private String memberEmail;
public String getMemberEmail() {
	return memberEmail;
}
public void setMemberEmail(String memberEmail) {
	this.memberEmail = memberEmail;
}
public String getMemberId() {
	return memberId;
}
public void setMemberId(String memberId) {
	this.memberId = memberId;
}
public String getMemberPwd() {
	return memberPwd;
}
public void setMemberPwd(String memberPwd) {
	this.memberPwd = memberPwd;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public String getMemberAdd() {
	return memberAdd;
}
public void setMemberAdd(String memberAdd) {
	this.memberAdd = memberAdd;
}
public String getuserGender() {
	return userGender;
}
public void setuserGender(String gender) {
	userGender = gender;
}

}
