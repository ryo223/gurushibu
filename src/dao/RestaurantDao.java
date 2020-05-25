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
	String url = "jdbc:mysql://localhost:3306/gurushibu";
	Connection con = null;

	//Restaurant_idからrestaurantテーブルを取得する
	public  RestaurantDto findRestaurant(int restaurantId) {

		RestaurantDto dto = new RestaurantDto();

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


	//部分検索処理
	public List<String> restaurantSearch(String restaurantName) {

		List<String> restaurantList = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(url,"root","ryo223124830");

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
