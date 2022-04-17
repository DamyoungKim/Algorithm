package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1699_제곱수의합 {
	/*
	 static int N;
	static int[] dp = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (j * j == i) dp[i] = 1;
				else dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
	*/
	
	/*
	static int N;
	static int[] dp = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				if (j * j == i) dp[i] = 1;
				else dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
	*/
	
	static int N;
	static int[] dp = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
	
	
}
