package org.mehtor._02_JDBC_Forum.repository;

import org.mehtor._01_JDBC_ETicaret.entity.Adres;
import org.mehtor._02_JDBC_Forum.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements ICrud<User>{
	private final DatabaseHelper databaseHelper;
	private String sql;
	
	public UserRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	
	@Override
	public void save(User user) {
		sql = "INSERT INTO tbluser(ad, soyad, username, password) VALUES ('%s','%s','%s','%s')"
				.formatted(user.getAd(), user.getSoyad(), user.getUsername(), user.getPassword());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void delete(int id) {
		sql ="DELETE FROM tbluser WHERE id="+id;
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(User user) {
	sql = "UPDATE tbluser SET ad='%s', soyad='%s', username='%s', password='%s' WHERE id=%d"
			.formatted(user.getAd(), user.getSoyad(), user.getUsername(), user.getPassword(), user.getId());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<User> findAll() {
		sql = "SELECT * FROM tbluser ORDER BY id DESC";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<User> userList = new ArrayList<>();
		try{
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				while (rs.next()) {
					userList.add(getValueFromResultSet(rs));
				}
			}
		}
		catch(SQLException e){
			System.out.println("Kullanıcıları listelerken bir hata oluştu.. "+e.getMessage());
		}
		return userList;
	}
	
	@Override
	public Optional<User> findById(int id) {
		sql = "SELECT * FROM tbluser WHERE id="+id;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try{
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				if (rs.next()) {
					return Optional.of(getValueFromResultSet(rs));
				}
			}
		}catch (SQLException e){
			System.out.println("Kullanıcı bulmada bir sorun oluştu.. "+e.getMessage());
		}
		return Optional.empty();
	}
	
	private User getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String ad = rs.getString("ad");
		String soyad = rs.getString("soyad");
		String username = rs.getString("username");
		String password = rs.getString("password");
		int state=rs.getInt("state");
		long createat = rs.getLong("createat");
		long updateat = rs.getLong("updateat");
		return new User(id, ad, soyad, username, password, state, createat, updateat);
	}
}