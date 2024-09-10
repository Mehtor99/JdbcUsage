package org.mehtor._02_JDBC_Forum;

import org.mehtor._02_JDBC_Forum.entity.User;
import org.mehtor._02_JDBC_Forum.repository.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Runner {
	static Scanner sc = new Scanner(System.in);
	static UserRepository userRepository = new UserRepository();
	
	public static void main(String[] args) {
		//userRepository.findAll().forEach(System.out::println);
		menu();
		/*User user = new User("Burak","Bilek","bb","12345");
		userRepository.save(user);
	*/
	}
	private static void menu() {
		int userInput = -1;
		do {
			System.out.println("**** Foruma Hosgeldiniz ****");
			System.out.println("1- Kayıt Ol");
			System.out.println("2- Giriş Yap");
			System.out.println("0- Çıkış Yap");
			System.out.print("Seçiminiz: ");
			userInput = sc.nextInt();sc.nextLine();
			menuOptions(userInput);
			
		} while (userInput != 0);
	}
	
	private static void menuOptions(int userInput) {
		
		switch (userInput) {
			case 1: {
				kayitOl();
				break;
			}
			case 2: {
				girisYap();
				break;
			}
			case 0: {
				System.out.println("Çıkış yapılıyor");
				break;
			}
			default: {
				System.out.println("Geçerli bir seçim yapiniz !!!");
				break;
			}
		}
		
		
	}
	
	private static void girisYap() {
		System.out.println("kullanıcı adınızı giriniz: ");
		String username = sc.nextLine();
		System.out.println("şifrenizi giriniz: ");
		String password = sc.nextLine();
		
		Optional<User> user = userRepository.doLogin(username, password);
		
		if (user.isPresent()) {
			System.out.println("Giriş başarılı hosgeldin "+user.get().getAd() + " " +user.get().getSoyad());
		}
		else {
			System.out.println("Girdiğiniz bilgiler hatalı !!!");
		}
		
	}
	
	private static void kayitOl() {
		System.out.println("***** Kullanici Kayit Formu *****");
		System.out.print("Adınız: ");
		String ad = sc.nextLine();
		System.out.print("Soyadiniz: ");
		String soyad = sc.nextLine();
		String username = getUsername();
		System.out.print("Password giriniz: ");
		String password = sc.nextLine();
		
		User user = new User(ad,soyad,username,password);
		userRepository.save(user);
	}
	
	private static String getUsername() {
		while (true) {
			System.out.println("Username giriniz: ");
			String username = sc.nextLine();
			
			// Kullanıcı adı veritabanında var mı kontrol et
			boolean exists = userRepository.existsByUserName(username);
			
			// Eğer kullanıcı adı mevcutsa uyarı ver
			if (exists) {
				System.out.println("Username zaten kullanılıyor, tekrar deneyiniz !!!");
			} else {
				return username;  // Kullanıcı adı kullanılabilir, döndür
			}
		}
	}
	
	
	
}