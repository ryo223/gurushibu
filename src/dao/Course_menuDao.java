package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course_menuDao {

	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/gurushibu";
	PreparedStatement ps = null;

	//course_nameとrestaurant_nameからcourse_idを取得する
	public int getCourseMenu(String restaurant_name, String course_name) {

		int res = 0;
		try {
			con = DriverManager.getConnection(url,"root","ryo223124830");
			String sql = "select course_id from course_menu where restaurant_name = ? AND course_name = ?;";

			ps = con.prepareStatement(sql);
            ps.setString(1, restaurant_name);
            ps.setString(2, course_name);

            ResultSet rs = ps.executeQuery();
			rs.next();

			res = rs.getInt(1);
			return res;
		}catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

}