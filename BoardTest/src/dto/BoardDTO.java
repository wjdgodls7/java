package dto;

public class BoardDTO {
	// 필드
	int	bNum;
	String bWriter;
	String bPassword;
	String bTitle;
	String bContent;
	String bDate;
	int bHit;
	String bFile;
	
	// getter, setter
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbPassword() {
		return bPassword;
	}
	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
	
	// toString
	@Override
	public String toString() {
		return "BoardDTO [bNum=" + bNum + ", bWriter=" + bWriter + ", bPassword=" + bPassword + ", bTitle=" + bTitle
				+ ", bContent=" + bContent + ", bDate=" + bDate + ", bHit=" + bHit + ", bFile=" + bFile + "]";
	}
}
