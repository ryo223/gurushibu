package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuDao {
	//menu_idからmenuテーブルを取得する
	public  MenuDto findMenu(int menuId) {
		Connection con = null;
		MenuDto menu = new MenuDto();
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from menu where menu_id = " + menuId;
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("SQLを実行");
			//while(rs.next()) {
			rs.next();
			//int  id = rs.getInt("category_id");
			menu.setName(rs.getString("restaurant_name"));
			menu.setMenu(rs.getString("menu"));
			menu.setCourseId(rs.getInt("course_id"));
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
		return menu;
	}

}
