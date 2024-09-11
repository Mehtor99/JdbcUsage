package org.mehtor._02_JDBC_Forum.controller;

import org.mehtor._02_JDBC_Forum.entity.User;
import org.mehtor._02_JDBC_Forum.repository.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	static UserRepository userRepository = new UserRepository();
	static int activeUserId;
	
	public void registerUser(){
		System.out.println("***** Kullanici Kayit Formu *****");
		System.out.print("Adınız: ");
		String ad = sc.nextLine();
		System.out.print("Soyadiniz: ");
		String soyad = sc.nextLine();
		
		String userName;
		boolean isRegisteredUser; //default olarak false gelir.
		
		while (true){
			System.out.print("Username giriniz: ");
			userName = sc.nextLine();
			isRegisteredUser = userRepository.existByUserName(userName);
			
			if (isRegisteredUser){
				System.out.println("Bu kullanıcı adı daha önce alınmış...");
			}
			else {
				break;
			}
		}
		
		System.out.print("Password giriniz: ");
		String password = sc.nextLine();
		
		User user = new User(ad, soyad, userName, password);
		userRepository.save(user);
		System.out.println("\nKullanıcı Başarılı Şekilde Kaydedildi.\n");
	}
	
	
	public static boolean girisYap() {
		System.out.print("kullanıcı adınızı giriniz: ");
		String username = sc.nextLine();
		System.out.print("şifrenizi giriniz: ");
		String password = sc.nextLine();
		
		Optional<User> user = userRepository.doLogin(username, password);
		
		if (user.isPresent()) {
			System.out.println("\nGiriş başarılı hosgeldin "+user.get().getAd() + " " +user.get().getSoyad()+ "\n");
			activeUserId = user.get().getId();
			return true;
		}
		else {
			System.out.println("Girdiğiniz bilgiler hatalı !!!");
			return false;
		}
		
	}
}