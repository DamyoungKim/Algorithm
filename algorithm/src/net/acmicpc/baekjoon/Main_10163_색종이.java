package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_10163_색종이 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[101][101];
		int[] num = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int i = y; i < y + w; i++) {
				for (int j = x; j < x + h; j++) {
					arr[i][j] = n;
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[i][j] == 0)
					continue;
				num[arr[i][j]]++;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}
}