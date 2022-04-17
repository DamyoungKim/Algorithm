package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463_1로만들기3 {
	static int[] dp = new int[1000001];
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		Arrays.fill(dp, Integer.MAX_VALUE);
//		int N = sc.nextInt();
//		int cnt = 0;
//		solve(N, cnt);
//		System.out.println(dp[1]);
//	}
//
//	private static void solve(int N, int cnt) {
//		if (dp[N] <= cnt) return;
//		dp[N] = cnt;
//		if (N % 3 == 0) solve (N / 3, cnt + 1);
//		
//		if (N % 2 == 0 && dp[N / 2] > cnt + 1) solve (N / 2, cnt + 1);
//		
//		if (N > 1) solve(N - 1, cnt + 1);
//	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		int N = sc.nextInt();
		System.out.println(solve(N));
	}

	private static int solve(int N) {
		
		if (dp[N] != Integer.MAX_VALUE) return dp[N];
		if (N % 3 == 0) {
			dp[N] = Math.min(solve(N / 3) + 1, dp[N]);
		}
		
		if (N % 2 == 0) {
			dp[N] = Math.min(solve(N / 2) + 1, dp[N]);
		}
		
		if (N > 1) {
			dp[N] = Math.min(solve(N - 1) + 1, dp[N]);
		}
		
		return dp[N];

	}
}
