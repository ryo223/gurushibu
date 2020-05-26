package dao;

public class Reservation_courseDto {
	private int reservationCourseId;
	private int resId;
	private int courseId;

	public int getReservationCourseId() {
		return reservationCourseId;
	}
	public void setMenuId(int reservationCourseId) {
		this.reservationCourseId = reservationCourseId;
	}

	public int getRestaurantId() {
		return resId;
	}
	public void setRestaurantId(int resId) {
		this.resId = resId;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
