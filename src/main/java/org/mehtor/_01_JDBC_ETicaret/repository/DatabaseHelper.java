package org.mehtor._01_JDBC_ETicaret.repository;

import java.sql.*;
import java.util.Optional;

import static org.mehtor._01_JDBC_ETicaret.utility.Constants.*;

public class DatabaseHelper {
	private Connection conn;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private boolean openConnection(){
		try {
			conn=DriverManager.getConnection("jdbc:postgresql://"+ DB_HOSTNAME+":"+DB_PORT+"/"+DB_NAME, DB_USERNAME, DB_PASSWORD);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Bağlantı Hatası..."+e.getMessage());
			return false;
		}
	}
	private void closeConnection(){
		try {
			if(!conn.isClosed()) //eğer bağlantı kapalı değilse, yani açıksa
				conn.close(); //bağlantıyı kapat.
		}
		catch (SQLException e) {
			System.out.println("Bağlantı kapatma Hatası..."+e.getMessage());
		}
	}
	
	public boolean executeUpdate(String sql){
		try {
			if(openConnection()){
				conn.prepareStatement(sql).executeUpdate();
				closeConnection();
				return true;
			}else{
				System.out.println("Bağlantı açmada hata meydana geldi.");
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("Sorgu çalıştırmada hata! SQL kodunuzda bir hata olabilir..."+e.getMessage());
			return false;
		}
	}
	
	
	public Optional<ResultSet> executeQuery(String sql){
		try {
			if(openConnection()){
				ResultSet rs = conn.prepareStatement(sql).executeQuery();
				closeConnection();
				return Optional.ofNullable(rs);
			}else{
				System.out.println("Bağlantı açmada hata meydana geldi.");
				return Optional.empty();
			}
		}
		catch (SQLException e) {
			System.out.println("Sorgu çalıştırmada hata! SQL kodunuzda bir hata olabilir..."+e.getMessage());
			return Optional.empty();
		}
	}
}