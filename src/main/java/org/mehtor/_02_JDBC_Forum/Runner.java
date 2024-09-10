package org.mehtor._02_JDBC_Forum;

import org.mehtor._02_JDBC_Forum.entity.User;
import org.mehtor._02_JDBC_Forum.repository.UserRepository;

import java.util.Scanner;

public class Runner {
	static Scanner sc = new Scanner(System.in);
	static UserRepository userRepository = new UserRepository();
	
	public static void main(String[] args) {
		//menu();
		User user = new User("Mehmet","Ertop","mehtor","1234");
		userRepository.save(user);
	}
	
	private static void menu() {
		int userInput = -1;
		do {
			System.out.println("**** Foruma Hosgeldiniz ****");
			System.out.println("1- Kayıt Ol");
			System.out.println("2- Giriş Yap");
			System.out.println("0- Çıkış Yap");
			System.out.print("Seçiminiz: ");
			userInput = sc.nextInt();
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
				//girisYap();
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
	
	private static void kayitOl() {
		System.out.println("***** Kullanici Kayit Formu *****");
		System.out.print("Adınız: ");
		String ad = sc.nextLine();sc.next();
		System.out.print("Soyadiniz: ");
		String soyad = sc.nextLine();sc.next();
		getUsername();
		System.out.println("Password giriniz: ");
		String password = sc.nextLine();
	}
	
	private static String getUsername() {
		String username;
		while (true) {
			System.out.println("Username giriniz: ");
			username = sc.nextLine();
			if (userRepository.findAll().contains(username)){
				System.out.println("Nu kullanıcı adı daha önce alınmış, farklı bir kullanıcı adı giriniz.");
			}else{
				return username;
			}
		}
	}
}