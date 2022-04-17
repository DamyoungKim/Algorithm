package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_11726_2xn타일링 {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		
//		int[] dp = new int[n + 1];
//		
//		dp[1] = 1;
//		if(n >= 2) {
//			dp[2] = 2;
//		}
//		
//		for(int i = 3; i < n + 1; i++) {
//			dp[i] = ( dp[i - 1] + dp[i - 2] ) % 10007;
//		}
//		System.out.println(dp[n]);
//	}
	
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		System.out.println(solve(N));
	}
	private static int solve(int N) {
		if (dp[N] > 0) return dp[N];
		return dp[N] = (solve(N - 1) + solve(N - 2)) % 10007;
	}
}
