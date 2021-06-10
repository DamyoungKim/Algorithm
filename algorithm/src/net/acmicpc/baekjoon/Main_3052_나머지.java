package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_3052_나머지 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean[] check = new boolean[42];
		for(int i = 0; i < 10; i++) {
			check[sc.nextInt() % 42] = true;
		}
		
		int cnt = 0;
		for(int i = 0; i < 42; i++) {
			if(check[i]) cnt++;
		}
		System.out.println(cnt);
	}

}