package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {

	PreparedStatement ps = null;
	String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
	Connection con = null;

	//Restaurant_idからrestaurantテーブルを取得する
	public String[] findRestaurant(String restaurant_name) {

		String restaurantArr[] = new String[3];

		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			String sql = "select restaurant_address,restaurant_mail_address,restaurant_tel_num from restaurant where restaurant_name = ?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, restaurant_name);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
                restaurantArr[0] = rs.getString("restaurant_address");
                restaurantArr[1] = rs.getString("restaurant_mail_address");
                restaurantArr[2] = rs.getString("restaurant_tel_num");
           }
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
		return restaurantArr;
	}


	//部分検索処理
	public List<String> restaurantSearch(String restaurantName) {

		List<String> restaurantList = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(url,"root","admin");

			//前方部分が一致する処理
			String sql = "select restaurant_name from restaurant where restaurant_name = ? ";
			ps = con.prepareStatement(sql);

			ps.setString(1,restaurantName);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				restaurantList.add(rs.getString("restaurant_name"));

			}
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
		return restaurantList;
	}
	//レストラン情報一覧
	public  boolean restaurantInfo(String restaurantName) {

		RestaurantDto dto = new RestaurantDto();

		try {
			con = DriverManager.getConnection(url,"root","admin");
			Statement stm = con.createStatement();
			String sql = "select * from restaurant where restaurant_name = " + restaurantName;
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				dto.setName(rs.getString("restaurant_name"));
				dto.setAddress(rs.getString("restaurant_address"));
				dto.setMailaddress(rs.getString("restaurant_mail_address"));
				dto.setPhonenumber(rs.getInt("restaurant_tel_num"));
				dto.setCategoryId(rs.getString("category_id"));
			}

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
		return true;
	}

}