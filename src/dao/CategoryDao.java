package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDao {
	//カテゴリーとレストランは一対多の関係で処理を行う

	//RestaurantDaoからレストランのidを取得する

	//カテゴリーidからカテゴリーを引く
	public  String getCategory(String categoryId) {
		Connection con = null;
		String category = null;
		String url = "jdbc:mysql://localhost:3306/gurushibu?serverTimezone=JST";
		try {
			con = DriverManager.getConnection(url,"root","admin");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from categorys where category_id = " + categoryId;
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("SQLを実行");
			//while(rs.next()) {
			rs.next();
			//int  id = rs.getInt("category_id");
			category = rs.getString("category_name");
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
		return category;
	}

}
