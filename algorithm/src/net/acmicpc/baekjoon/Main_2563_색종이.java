package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2563_색종이 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[100][100];
		int count = 0;
		for (int t = 1; t <= T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if(arr[i][j] == 1) {
						count++;
						continue;
					}
					arr[i][j] = 1;
				}
			}
			
		}
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(100*T- count);
	}
}