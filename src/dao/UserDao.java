package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";

	Connection con = null;
	PreparedStatement ps = null;
	//アカウントを探す
	public boolean findUser(String id) {

		try {
			//mysqlパスワードは各自書き換えてください。
			con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	String sql = "select user_id from users where user_id = ?;";

            ps = con.prepareStatement(sql);
			ps.setString(1,id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			if(rs.getString(1).equals(id)) {
				return true;
			}

		}catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
			return true;
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
		return false;
	}

	//新規登録
	public void addUser(String id, String name, String email, String password) {

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	con.setAutoCommit(false);
        	String sql = "INSERT INTO users values(?, ?, ?, ?)" ;
        	ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);

          //INSERT文を実行する
            ps.executeUpdate();
            //コミット
            con.commit();

        } catch (SQLException e) {
        	System.out.println("MySQLに接続できませんでした。");
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
    }

	//ログイン処理
	public boolean regUser(String id, String password) {

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	String sql = "select user_id from users where user_id = ? AND password = ?;";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
			rs.next();

			if(rs.getString(1).equals(id)) {
				return true;
			}else {
				return false;
			}
        } catch (SQLException e) {
        	System.out.println("MySQLに接続できませんでした。");
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
        return false;
    }
}