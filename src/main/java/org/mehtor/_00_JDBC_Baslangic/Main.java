package org.mehtor._00_JDBC_Baslangic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		//JDBC kullanmak için ilk yapmanız gereken DRIVER'ı devreye almaktır
		//java ...
		//Javada postgresql server'a geçip bağlantı kurmak için gerekli olanlare:
		//hostname:   localhost
		//portname:
		
		
		
		
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username="postgres";
		String password="root";
		
		Connection connection = DriverManager.getConnection(connectionString, username, password);
		// String bir ifade içinde basit bir sql komutu yazalım:
		String sqlkomut = "INSERT INTO tbladres(musteri_id,il, ilce)VALUES (1,'Londra','KoJo')";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlkomut);
		
		preparedStatement.executeUpdate();
		connection.close();
	}
}