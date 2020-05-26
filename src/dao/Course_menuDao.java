package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Course_menuDao {
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
	
	//course_idからcourse_menuテーブルを取得する
	public  String getCourseMenu(int courseId) {
		String course = null;
		
		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from course_menu where course_id = " + courseId;
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("SQLを実行");
			//while(rs.next()) {
			rs.next();
			//int  id = rs.getInt("category_id");
			course = rs.getString("restaurant_name");
			course = rs.getString("course_name");
			//System.out.println("取得結果 ->" + id ":" + category);

//					}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e ) {
//						System.out.println("JDBCドライバのロードに失敗しました。");
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
		return course;
	}

}
