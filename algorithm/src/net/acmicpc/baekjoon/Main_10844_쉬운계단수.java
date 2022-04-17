package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_10844_쉬운계단수 {
	static int[][] dp = new int[101][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % 1000000000;
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1] % 1000000000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans = (ans + dp[N][i]) % 1000000000;
		}
		System.out.println(ans);
	}

}
