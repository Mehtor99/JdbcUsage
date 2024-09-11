package org.mehtor._02_JDBC_Forum.modules;

import org.mehtor._02_JDBC_Forum.controller.PostController;

import java.util.Scanner;

public class PostMenu {
	static Scanner sc = new Scanner(System.in);
	/*
	1- Postları Görüntüle
2- Post Paylaş 
3- Kendi postlarını görüntüle 
4- Kullanıcıları Listele(user-findAll) 
5- Çıkış Yap
	 */
	
	public static void postMenu() {
		
		int userInput = -1;
		do {
			System.out.println(" Post Menüsüne Hosgeldiniz ");
			System.out.println("1- Postlari Goruntule");
			System.out.println("2- Post Paylas");
			System.out.println("3- Kendi postlarını görüntüle ");
			System.out.println("4- Kullanıcıları Listele ");
			System.out.println("0- Geri Don ");
			System.out.print("Seçiminiz: ");
			userInput = sc.nextInt();
			sc.nextLine();
			postMenuOptions(userInput);
			
		} while (userInput != 0);
	}
	
	private static void postMenuOptions(int userInput) {
		PostController postController = new PostController();
		switch (userInput) {
			case 1: {
				
				break;
			}
			case 2: {
				postController.createPost();
				break;
			}
			case 3: {
				
				break;
			}
			case 4: {
				
				break;
			}
			case 0: {
				System.out.println("\nAna menuye donuluyor :)");
				break;
			}
			default: {
				System.out.println("\n Gecerli bir secim yapiniz!!!");
				break;
			}
		}
	}
}