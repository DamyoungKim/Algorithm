package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1309_동물원 {
	static int[] arr = new int[100001];
	static int[][] dp = new int[100001][3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
			
			dp[i][0] %= 9901;
			dp[i][1] %= 9901;
			dp[i][2] %= 9901;
		}
		
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
	}

}
