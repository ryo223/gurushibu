package dao;

public class MenuDto {
	private int menuId;
	private String restaurantName;
	private String menu;
	private int courseId;


	public MenuDto() {}

	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return restaurantName;
	}
	public void setName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
