package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reservation_courseDao {
	//Reservationとcourseは多対多の関係で処理を行う
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/blog?serverTimezone=JST";
	//1 ReservationDaoから予約idを取得する

	//2 reservation_idからreservation_courseテーブルを引く
	public int getReservationCourse(int reservationId) {
		int reservation_course = 0;

		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from reservation_course  where reservation_id =" + reservationId;
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("SQLを実行");
			//while(rs.next()) {
			rs.next();
			reservation_course = rs.getInt("post_id");
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
		return reservation_course;
	}

	//３．コースのidでコーステーブルを引く
	public  String getCourse(int courseId) {
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
			course = rs.getString("course_name");

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
		return course;
	}

}
