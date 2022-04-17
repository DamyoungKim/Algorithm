package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_11727_2xn타일링2 {
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[1] = 1;
		dp[2] = 3;
		System.out.println(solve(N));
	}
	private static int solve(int N) {
		if (dp[N] > 0) return dp[N];
		return dp[N] = (solve(N - 1) + solve(N - 2) * 2) % 10007;
	}
	
//	public static void main(String[] args) {
//		int[] arr= new int[1001];
//		arr[1] = 1;
//		arr[2] = 3;
//		
//		for(int i = 3; i < 1001; i++) {
//			arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
//		}
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println(arr[sc.nextInt()]);
//	}
}
