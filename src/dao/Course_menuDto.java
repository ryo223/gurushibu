package dao;

public class Course_menuDto {
	private int courseId;
	private String restaurantName;
	private String courseName;


	public Course_menuDto() {}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return restaurantName;
	}
	public void setName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



}
