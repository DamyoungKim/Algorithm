package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_1100_하얀말 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		char[][] arr = new char[8][8];
		
		for(int i = 0; i < 8; i++) {
			String s = sc.next();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i % 2 == 0 && j % 2 == 0 && arr[i][j] == 'F') cnt++;
				if(i % 2 == 1 && j % 2 == 1 && arr[i][j] == 'F') cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
