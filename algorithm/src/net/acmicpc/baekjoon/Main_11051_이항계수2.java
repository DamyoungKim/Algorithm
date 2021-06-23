package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_11051_이항계수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] arr = new int[N + 1][N + 1];
		
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= Math.min(i, K); j++) {
				
				if(i == 0 || j == 0) arr[i][j] = 1;
				else arr[i][j] = ( arr[i - 1][j] + arr[i - 1][j - 1] ) % 10007;
			}
		}
		System.out.println(arr[N][K]);
	}
}
