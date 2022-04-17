package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_11057_오르막수 {
	static int[][] dp = new int[1001][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k <= 9; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i];
			ans %= 10007;
		}
		System.out.println(ans);
	}

}
