package org.mehtor._02_JDBC_Forum.controller;

import org.mehtor._02_JDBC_Forum.entity.Post;
import org.mehtor._02_JDBC_Forum.entity.User;
import org.mehtor._02_JDBC_Forum.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class PostController {
	String sql;
	static Scanner sc = new Scanner(System.in);
	static PostRepository postRepository = new PostRepository();
	
	
	public void createPost() {
		System.out.println("****** Post Olusturma Sayfasi *******");
		System.out.print("Post basligini giriniz: ");
		String baslik = sc.nextLine();
		System.out.print("Post İcerigini giriniz");
		String icerik = sc.nextLine();
		
		Post post = new Post(UserController.activeUserId, baslik, icerik);
		postRepository.save(post);
		
	}
	
	public void getMyPostList() {
		postRepository.activeUserPostList().forEach(System.out::println);
		
	}
}