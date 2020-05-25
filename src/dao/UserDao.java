package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDao {

	//ログインアカウントを探す
	public UserDto findUser(String id) {
		UserDto user = null;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
		try {
			con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	Statement stm = con.createStatement();
        	String sql = "select * from users where user_id =" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (!rs.next()) { return null; }

            String userId = rs.getString("user_id");
            String password = rs.getString("password");
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
		return user;
	}

	//新規登録
	public UserDto getUser(String id, String name, String email, String password) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
    	UserDto user = null;

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	Statement stm = con.createStatement();
        	String sql = "insert * into users values(?, ?, ?, ?)" ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
    			String userId = rs.getString("user_id");
    			String userName = rs.getString("user_name");
    			String mailAddress = rs.getString("mail_address");
    			String pass = rs.getString("password");
    			user = new UserDto(userId,userName,mailAddress,pass);
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
        return user;
    }

	//ログイン処理
	public int regUser(String id, String password) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
    	int result = 0;

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
            String sql  = "select * from users (user_id, password) VALUES (?, ?)";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, password);

            int r = ps.executeUpdate();

            if(r != 0) {
                System.out.println("ログイン成功！");
            } else {
                System.out.println("ログイン失敗( ﾉД`)ｼｸｼｸ…");
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
        return result;
    }


}
