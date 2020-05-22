package dao;

import java.sql.Date;

public class ReservationDto {
	private String resId;
    private Date resTime;
    private int persons;
    private String restaurantName;
    private int userId;

	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public Date getTime() {
		return resTime;
	}
	public void setTime(Date resTime) {
		this.resTime = resTime;
	}
	public int getPerson() {
		return persons;
	}
	public void setPerson(int persons) {
		this.persons = persons;
	}
	public String getName() {
		return restaurantName;
	}
	public void setName(String restaurantName) {
		this.restaurantName= restaurantName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
