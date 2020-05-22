package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDao {

	//ログインアカウントを探す
	public UserDto findUser(String id) {
		UserDto user = new UserDto();
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
		try {
			con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	Statement stm = con.createStatement();
        	String sql = "select * from users where user_id =" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (!rs.next()) { return null; }

            user.setId(rs.getString("user_id"));
            user.setPassword(rs.getString("password"));
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
	public ArrayList<UserDto> getUserList() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
    	ArrayList<UserDto> list = new ArrayList<UserDto>();

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
        	Statement stm = con.createStatement();
        	String sql = "select * from users " ;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                UserDto ud = new UserDto();
                ud.setId(rs.getString("user_id"));
                ud.setName(rs.getString("user_name"));
                ud.setMailaddress(rs.getString("mail_address"));
                ud.setPassword(rs.getString("password"));
                ud.setPhonenumber(rs.getInt("phone_number"));
                list.add(ud);
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
        return list;
    }

	//ログイン処理
	public int regUser(String id, String password) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
    	int result = 0;

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
            String sql  = "INSERT INTO users (user_id, password) VALUES (?, ?)";
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

	//ログアウト処理
	public int delUser(String id, String password) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
    	int result = 0;

        try {
        	con = DriverManager.getConnection(url,"root","admin");
        	System.out.println("MySQLに接続できました。");
            String sql = "DELETE FROM users WHERE userid = ? AND password = ?";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, password);

            int r = ps.executeUpdate();

            if(r != 0) {
                System.out.println("ログアウト成功！");
            } else {
                System.out.println("ログアウト失敗( ﾉД`)ｼｸｼｸ…");
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
