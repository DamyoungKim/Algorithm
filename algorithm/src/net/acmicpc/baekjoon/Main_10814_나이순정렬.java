package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_10814_나이순정렬 {
	static class User implements Comparable<User>{
		int age;
		String name;
		public User(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<User> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(new User(sc.nextInt(), sc.next()));
		}
		
		Collections.sort(list);
		
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}
	}

}