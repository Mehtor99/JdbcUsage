package org.mehtor._01_JDBC_ETicaret.entity;

public class Adres extends BaseEntity{
	private Integer id;
	private Integer musteri_id;
	private String il;
	private String ilce;
	private String mahalle;
	private String adres;
	
	public Adres() {
	}
	
	public Adres(Integer musteri_id, String il, String ilce, String mahalle, String adres) {
		this.musteri_id = musteri_id;
		this.il = il;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.adres = adres;
	}
	
	public Adres(Integer id, Integer musteri_id, String il, String ilce, String mahalle, String adres) {
		this.id = id;
		this.musteri_id = musteri_id;
		this.il = il;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.adres = adres;
	}
	
	public Adres( Integer id, Integer musteri_id, String il, String ilce, String mahalle, String adres,Integer state, Long createat, Long updateat) {
		super(state, createat, updateat);
		this.id = id;
		this.musteri_id = musteri_id;
		this.il = il;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.adres = adres;
	}
	
	@Override
	public String toString() {
		return "Adres{" + "id=" + id + ", musteri_id=" + musteri_id + ", il='" + il + '\'' + ", ilce='" + ilce + '\'' + ", mahalle='" + mahalle + '\'' + ", adres='" + adres + '\'' + ", state=" + getState() + ", createat=" + getCreateat() + ", updateat=" + getUpdateat() + '}';
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMusteri_id() {
		return musteri_id;
	}
	
	public void setMusteri_id(Integer musteri_id) {
		this.musteri_id = musteri_id;
	}
	
	public String getIl() {
		return il;
	}
	
	public void setIl(String il) {
		this.il = il;
	}
	
	public String getIlce() {
		return ilce;
	}
	
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	
	public String getMahalle() {
		return mahalle;
	}
	
	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public void setAdres(String adres) {
		this.adres = adres;
	}
}