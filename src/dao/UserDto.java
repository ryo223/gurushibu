package dao;

public class UserDto {
	private String userId;
    private String userName;
    private String mailAddress;
    private String password;
    private int phoneNumber;

	public UserDto(String userId,String userName, String mailAddress, String pass) {
		this.userId = userId;

		this.mailAddress = mailAddress;
		this.userName = userName;
		this.mailAddress = mailAddress;
	}
	public String getId() {
		return userId;
	}
	public void setId(String id) {
		this.userId = id;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public String getMailaddress() {
		return mailAddress;
	}
	public void setMailaddress(String address) {
		this.mailAddress = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password= pass;
	}
	public int getPhonenumber() {
		return phoneNumber;
	}
	public void setPhonenumber(int phone) {
		this.phoneNumber = phone;
	}

}
