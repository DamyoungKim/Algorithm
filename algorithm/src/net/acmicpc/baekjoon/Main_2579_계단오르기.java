package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {
	/*
	public static void main(String[] args) {
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
			int a = dp[i - 3] + arr[i - 1] + arr[i];
			int b = dp[i - 2] + arr[i];
		
				dp[i] = Math.max(a,b);
			
		}
		System.out.println(dp[N]);
	}
	*/
	static int N;
	static int[] arr = new int[10001];
	static int[][] dp = new int[10001][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1][0] = arr[1];
		dp[1][1] = arr[1];
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
			dp[i][1] = dp[i - 1][0] + arr[i];
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}
	
	
}
