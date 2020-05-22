package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantDao {
	//Restaurant_idからrestaurantテーブルを取得する
	public  RestaurantDto findRestaurant(int restaurantId) {
		Connection con = null;
		RestaurantDto dto = new RestaurantDto();
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from restaurant where restaurant_id = " + restaurantId;
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("SQLを実行");
			//while(rs.next()) {
			rs.next();
			dto.setName(rs.getString("restaurant_name"));
			dto.setAddress(rs.getString("restaurant_address"));
			dto.setMailaddress(rs.getString("restaurant_mail_address"));
			dto.setPhonenumber(rs.getInt("restaurant_tel_num"));
			dto.setCategoryId(rs.getString("category_id"));
			//System.out.println("取得結果 ->" + id ":" + category);

//			}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e ) {
//				System.out.println("JDBCドライバのロードに失敗しました。");
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
		return dto;
	}

}
