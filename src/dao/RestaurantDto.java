package dao;

public class RestaurantDto {
	private String restaurantId;
    private String restaurantName;
    private String address;
    private String mailAddress;
    private int phoneNumber;
    private String categoryId;

	public String getId() {
		return restaurantId;
	}
	public void setId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return restaurantName;
	}
	public void setName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailaddress() {
		return mailAddress;
	}
	public void setMailaddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public int getPhonenumber() {
		return phoneNumber;
	}
	public void setPhonenumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
