package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2156_포도주시식 {
	/**
	 * Bottom-Up
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[1] = arr[1];
		if(N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i = 3; i < N + 1; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1] + arr[i] , dp[i - 2] + arr[i]));
		}
		
		System.out.println(dp[N]);
	}
	
	/**
	 * Top-Down
	 */
	/*
	 static int[] arr, dp;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N + 1];
		dp = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = sc.nextInt();
			dp[i] = -1;
		}
		System.out.println(solve(N));
	}

	private static int solve(int N) {
		if(N == 0) {
			return 0;
		}
		if(N == 1) {
			return dp[1] = arr[1];
		}
		
		if(N == 2) {
			return dp[2] = arr[1] + arr[2];
		}
		if(dp[N] == -1) {
			int a = solve(N - 3);
			int b = solve(N - 2);
			int c = solve(N - 1);
			dp[N] = Math.max(c, Math.max(a + arr[N - 1] + arr[N], b + arr[N]));
		}
		
		return dp[N];
	}
	 */
}
