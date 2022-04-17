package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {

	/**
	 * Bottom-Up
	 */
	/*
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
	*/
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
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
//		int[][] dp = new int[N][3];
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		dp[0][0] = arr[0];
//		dp[0][1] = arr[0];
//		for (int i = 1; i < N; i++) {
//			dp[i][0] = dp[i - 1][2] + arr[i];
//			dp[i][1] = arr[i] + dp[i - 1][0];
//			dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
//		}
//		int ans = 0;
//		for (int i = 0; i < 3; i++) {
//			ans = Math.max(ans, dp[N - 1][i]);
//		}
//		System.out.println(ans);
//	}
	
	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][2] + arr[i];
			dp[i][1] = arr[i] + dp[i - 1][0];
			dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
		}
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			ans = Math.max(ans, dp[N - 1][i]);
		}
		System.out.println(ans);
	}
	
	*/
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N + 1];
		dp[1] = arr[1];
		if (N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], Math.max(arr[i] + dp[i - 2], dp[i - 1]));
		}
		System.out.println(dp[N]);
	}
	

}
