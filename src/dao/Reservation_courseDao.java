package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Reservation_courseDao {
	//Reservationとcourseは多対多の関係で処理を行う
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
	PreparedStatement ps = null;

	public boolean addReservationCourse(String res_date,String res_time,String restaurant_name,int course_id) {

		try {
        	con = DriverManager.getConnection(url,"root","ryo223124830");

        	con.setAutoCommit(false);
        	String sql = "INSERT INTO reservation_course values(?, ?, ?, ?)" ;
        	ps = con.prepareStatement(sql);
            ps.setString(1, res_date);
            ps.setString(2, res_time);
            ps.setString(3, restaurant_name);
            ps.setInt(4, course_id);

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

	//３．コース名でコーステーブルを引く
	public List<String> getCourse(String restaurant_name) {

		List<String> courseList = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(url,"root","ryo223124830");
			String sql = "select course_name from course_menu where restaurant_name = ?;";
			ps = con.prepareStatement(sql);
            ps.setString(1, restaurant_name);

            //ps.executeUpdate();
            //コミット
            //con.commit();

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                courseList.add(rs.getString("course_name"));
                System.out.println(courseList.get(0));
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
		return courseList;
	}

}
