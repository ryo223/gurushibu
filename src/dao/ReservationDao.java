package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReservationDao {
	//res_idからreservationテーブルを取得する
	public  ReservationDto findReservation(int resId) {
		Connection con = null;
		ReservationDto res = new ReservationDto();
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from reservation where res_id = " + resId;
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("SQLを実行");
			//while(rs.next()) {
			rs.next();
			res.setTime(rs.getDate("res_time"));
			res.setPerson(rs.getInt("persons"));
			res.setName(rs.getString("restaurant_name"));
			res.setUserId(rs.getInt("user_id"));
			//System.out.println("取得結果 ->" + id ":" + category);

//				}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e ) {
//					System.out.println("JDBCドライバのロードに失敗しました。");
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
