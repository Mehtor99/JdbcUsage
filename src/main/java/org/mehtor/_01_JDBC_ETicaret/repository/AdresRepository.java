package org.mehtor._01_JDBC_ETicaret.repository;

import org.mehtor._01_JDBC_ETicaret.entity.Adres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdresRepository implements ICrud<Adres> {
	String sql;
	private final DatabaseHelper databaseHelper;
	
	public AdresRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Adres adres) {
		sql = "INSERT INTO tbladres(musteri_id,il,ilce,mahalle,adres) VALUES (%d,'%s','%s','%s','%s')"
				.formatted(adres.getMusteri_id(),adres.getIl(),adres.getIlce(),adres.getMahalle(),adres.getAdres());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void delete(int silinecekAdresId) {
		sql = "DELETE FROM tbladres WHERE id=" + silinecekAdresId;
		databaseHelper.executeUpdate(sql);
	}
	
	
	@Override
	public void update(Adres adres) {
		sql = "UPDATE tbladres SET musteri_id= %d, il= '%s', ilce= '%s', mahalle='%s', adres= '%s' WHERE id= %d"
				.formatted(adres.getMusteri_id(),adres.getIl(), adres.getIlce(), adres.getMahalle(), adres.getAdres()
						,adres.getId());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<Adres> findAll() {
		sql="SELECT * FROM tblAdres ORDER BY id DESC";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<Adres> adresList = new ArrayList<>();
		if(resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			try {
				while (rs.next()) {
					adresList.add(getValueFromResultSet(rs));
				}
			}
			catch (SQLException e) {
				System.out.println("Adres Listesi getirirken bir sorun yaşandı. " + e.getMessage());
			}
		}
		return adresList;
	}
	
	@Override
	public Optional<Adres> findById(int bulunacakAdresId) {
		sql = "SELECT * FROM tbladres WHERE id =" + bulunacakAdresId;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				if (rs.next()) {
					return Optional.of(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Adres bulmada sorun yasandi...." + e.getMessage());
			
		}
		return Optional.empty();
	}
	
	private Adres getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		int musteri_id = rs.getInt("musteri_id");
		String il = rs.getString("il");
		String ilce = rs.getString("ilce");
		String mahalle = rs.getString("mahalle");
		String adres = rs.getString("adres");
		int state=rs.getInt("state");
		long createat = rs.getLong("createat");
		long updateat = rs.getLong("updateat");
		return new Adres(id, musteri_id, il, ilce, mahalle, adres, state, createat, updateat);
	}
	
	
}