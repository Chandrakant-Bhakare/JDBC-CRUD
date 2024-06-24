package StudentCrude.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtility {
	final static String DB_name= "School";
	final static String DB_Driver="com.mysql.cj.jdbc.Driver";
	final static String DB_URL ="jdbc:mysql://localhost:3306/"+DB_name;
	final static String User_name="root";
	final static String password ="cdac";
	static Statement stmt;
	static Connection conn;
	public static void Db_connection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_Driver);
		conn = DriverManager.getConnection(DB_URL, User_name, password);
		stmt = conn.createStatement();
	}
	public static int insert(String qry) throws SQLException {
		int result =-1;
		if(qry!="") {
			result = stmt.executeUpdate(qry);
		}
		return result;
		
	}
	public static int update(String qry)throws SQLException {
		int result =-1;
		if(qry!="") {
			result = stmt.executeUpdate(qry);
		}
		return result;
	}
	public static int delete(String qry) throws SQLException {
		int result=-1; 
		if(qry!="") {
		result = stmt.executeUpdate(qry);
		}
		return result;
		
	}
	public static ResultSet fetch(String qry) throws SQLException {
		ResultSet rs=null;
		if(qry!="") {
			rs = stmt.executeQuery(qry);
		}
		
		return rs;
		
	}
	public static void close() throws SQLException {
		if(stmt!=null||conn!=null) {
			stmt.close();
			conn.close();
		}
	}

}
