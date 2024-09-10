package org.mehtor._00_JDBC_Baslangic;

import javax.xml.transform.Result;
import java.sql.*;


public class Runner {
	public static void main(String[] args) throws SQLException {
//		adresEkle(3,"İzmir","Bornova");
//		adresEklePrepared(6,"Ankara","Mamak");
//		adresEklePrepared(7,"Antalya","Manavgat");
//		adresEklePrepared(8,"Isparta","Eğirdir");
		
		// adresSil(1007);
		
		//adresGuncelle(1006,"Muğla","Marmaris");
		
		adresListele("Ankara");
	}
	
	private static void adresListele(String ilArg) {
		String ADRES_SELECT_SQL= "SELECT * FROM tbladres WHERE il ILIKE ? ";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret?user=postgres&password=root";
		
		try(Connection connection = DriverManager.getConnection(connectionString);
		    PreparedStatement preparedStatement = connection.prepareStatement(ADRES_SELECT_SQL)){
			preparedStatement.setString(1,"%"+ilArg+"%");
			//
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
//				int musteriId = resultSet.getInt("musteri_id");
//				String il =resultSet.getString("il");
//				String ilce = resultSet.getString("ilce");
				
				int musteriId = resultSet.getInt(1);
				String il =resultSet.getString(2);
				String ilce = resultSet.getString(3);
				System.out.println("Musteri id: "+musteriId+ " il: "+il+ " ilce: "+ilce);
			}
			System.out.println("While dongusu bitti");
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
		
		private static void adresGuncelle(int id, String yeniIl, String yeniIlce) {
		String ADRES_UPDATE_SQL= "UPDATE public.tbladres SET  il=?, ilce=? WHERE id=?;";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username="postgres";
		String password="root";
		
		try(Connection connection = DriverManager.getConnection(connectionString, username, password);
		    PreparedStatement preparedStatement = connection.prepareStatement(ADRES_UPDATE_SQL)){
			
			preparedStatement.setString( 1,yeniIl);
			preparedStatement.setString( 2,yeniIlce);
			preparedStatement.setInt( 3, id);
			
			int etkilenenSatirSayisi = preparedStatement.executeUpdate();
			if(etkilenenSatirSayisi>0){
				System.out.println("KAyıt basaarıyla guncellendi");
			}else {
				System.out.println("KAyıt guncellenemedi");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void adresSil(int idArg) {
		String ADRES_DELETE_SQL= "DELETE FROM tbladres WHERE id=?";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username="postgres";
		String password="root";
		try(Connection connection = DriverManager.getConnection(connectionString, username, password);
		    PreparedStatement preparedStatement = connection.prepareStatement(ADRES_DELETE_SQL)){
			preparedStatement.setInt(1, idArg);
			int etkilenenSatirSayisi = preparedStatement.executeUpdate();
			if(etkilenenSatirSayisi>0){
				System.out.println("KAyıt basaarıyla silindi");
			}else {
				System.out.println("KAyıt silinemedi");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void adresEkle(int musteri_id, String il, String ilce) throws SQLException {
		String ADRES_INSERT_SQL="INSERT INTO tbladres(musteri_id, il, ilce) VALUES ("+musteri_id+", '"+il+"', '"+ilce+"')";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username="postgres";
		String password="root";
		
		Connection connection = DriverManager.getConnection(connectionString, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
		int etkilenenSatirSayisi = preparedStatement.executeUpdate();
		if(etkilenenSatirSayisi>0){
			System.out.println("KAyıt basaarıyla gertcekleşti");
		}else {
			System.out.println("KAyıt gercekleşmedi");
		}
		connection.close();
	}
	
	private static void adresEklePrepared(int musteri_id, String il, String ilce){
		String ADRES_INSERT_SQL="INSERT INTO tbladres(musteri_id, il, ilce) VALUES (?,?,?)";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username="postgres";
		String password="root";
		try(Connection connection = DriverManager.getConnection(connectionString, username, password);
		    PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);){
			preparedStatement.setInt(1,musteri_id);
			preparedStatement.setString(2,il);
			preparedStatement.setString(3,ilce);
			
			int etkilenenSatirSayisi = preparedStatement.executeUpdate();
			if(etkilenenSatirSayisi>0){
				System.out.println("Kayıt basarıyla gercekleşti");
			}else {
				System.out.println("Kayıt gercekleşmedi");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}