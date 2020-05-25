package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RestaurantDao {
	Connection con = null;
	PreparedStatement ps = null;

	String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";

	//Restaurant_idからrestaurantテーブルを取得する
	public  RestaurantDto findRestaurant(int restaurantId) {
		RestaurantDto dto = new RestaurantDto();
		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from restaurant where restaurant_id = " + restaurantId;
			ResultSet rs = stm.executeQuery(sql);
			//while(rs.next()) {
			dto.setName("restaurant_name");
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
	//部分検索処理
	public  ArrayList<RestaurantDto> getRestaurantList(String restaurantName) {
		ArrayList<RestaurantDto> list = new ArrayList<RestaurantDto>();

		try {
			con = DriverManager.getConnection(url,"root","admin");
			Statement stm = con.createStatement();
			//前方部分が一致する処理
			String sql = "select * from restaurant where restaurant_name like /* @prefix(restaurant_name) */'smith' escape '$' ";
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				RestaurantDto rd = new RestaurantDto();
				rd.setName(rs.getString("restaurant_name"));
				list.add(rd);
			}
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
		return list;
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
		return true;
	}

}
