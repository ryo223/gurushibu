package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReservationDao {
	String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";

	Connection con = null;
	PreparedStatement ps = null;

	//res_idからreservationテーブルを取得する
	public  ReservationDto findReservation(int resId) {
		ReservationDto res = new ReservationDto();
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

	//予約の追加
	public boolean addReservation(String date, String time, String restaurantName, String persons, String userId) {

        try {
        	con = DriverManager.getConnection(url,"root","ryo223124830");

        	con.setAutoCommit(false);
        	String sql = "INSERT INTO reservation values(?, ?, ?, ?, ?)" ;
        	ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, time);
            ps.setString(3, restaurantName);
            ps.setString(4, persons);
            ps.setString(5, userId);

          //INSERT文を実行する
            ps.executeUpdate();
            //コミット
            con.commit();

        } catch (SQLException e) {
        	System.out.println("MySQLに接続できませんでした。");
        	return false;
        } finally {
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

	//予約の追加
		/*public boolean addReservationCourse() {

	        try {
	        	con = DriverManager.getConnection(url,"root","ryo223124830");

	        	con.setAutoCommit(false);
	        	String sql = "INSERT INTO reservation values(?, ?, ?, ?, ?)" ;
	        	ps = con.prepareStatement(sql);
	            ps.setString(1, date);
	            ps.setString(2, time);
	            ps.setString(3, restaurantName);
	            ps.setString(4, persons);
	            ps.setString(5, userId);

	          //INSERT文を実行する
	            ps.executeUpdate();
	            //コミット
	            con.commit();

	        } catch (SQLException e) {
	        	System.out.println("MySQLに接続できませんでした。");
	        	return false;
	        } finally {
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
	    }*/

}
