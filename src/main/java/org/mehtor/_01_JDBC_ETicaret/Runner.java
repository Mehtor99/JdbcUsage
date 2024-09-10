package org.mehtor._01_JDBC_ETicaret;

import org.mehtor._01_JDBC_ETicaret.entity.Adres;
import org.mehtor._01_JDBC_ETicaret.entity.Musteri;
import org.mehtor._01_JDBC_ETicaret.repository.AdresRepository;
import org.mehtor._01_JDBC_ETicaret.repository.MusteriRepository;

import java.time.LocalDate;
import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
		MusteriRepository musteriRepository=new MusteriRepository();
		//public Musteri(String ad, String soyad, String cinsiyet, LocalDate dtarih, String tel, String email, String sehir)
//		Musteri
//				m1=new Musteri("Selim", "Sarı", "E", LocalDate.of(2000, 5, 15), "5553332211", "selimsari@gmail.com", "Ankara");
//		musteriRepository.save(m1);

//		musteriRepository.delete(1000);
//		musteriRepository.findAll().forEach(System.out::println);

//		musteriRepository.findById(500).ifPresent(System.out::println);
//		musteriRepository.findById(1999)
//		                 .ifPresentOrElse(System.out::println,
//		                                  ()-> System.out.println("Aradığınız musteriid'li müşteri bulunamadı."));
//
//		// 999 id li müşterinin soyadını değiştirelim.
//		Optional<Musteri> guncellenecekMusteri = musteriRepository.findById(999);
//		if(guncellenecekMusteri.isPresent()){
//			guncellenecekMusteri.get().setSoyad("YeniSarı");
//			guncellenecekMusteri.get().setEmail("selimyenisari@gmail.com");
//			musteriRepository.update(guncellenecekMusteri.get());
//		}else {
//			System.out.println("Güncellenecek müşteri bulunamadı.");
//		}
//
//
//		musteriRepository.findById(1002)
//		                 .ifPresentOrElse(System.out::println,
//		                                  ()-> System.out.println("Aradığınız musteriid'li müşteri bulunamadı."));
		
		AdresRepository adresRepository=new AdresRepository();
		//public Adres(Integer musteri_id, String il, String ilce, String mahalle, String adres) {
//		adresRepository.save(new Adres(100, "Ankara", "Çankaya", "Hürriyet", "Gençlik cad. Ordu sk. 10"));
//		adresRepository.findById(1010).ifPresentOrElse(System.out::println,()->{
//			System.out.println("Aranılan idli adres bulunamadı");
//		});
//		adresRepository.findById(2028).ifPresentOrElse(System.out::println,()->{
//			System.out.println("Aranılan idli adres bulunamadı");
//		});
//		adresRepository.findAll().forEach(System.out::println);
//		Optional<Adres> guncellenecekAdres = adresRepository.findById(1009);
//		if(guncellenecekAdres.isPresent()){
//			Adres adres = guncellenecekAdres.get();
//			adres.setAdres("Lunapark cad.");
//			adresRepository.update(adres);
//		}
		adresRepository.delete(997);
		
	}
}