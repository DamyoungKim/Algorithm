package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {
	static int N;
	static long result;
	static int[] arr;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		dp = new long[N][21];
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1][arr[1]] = 1;
		for(int i = 2; i < N; i++) {
			for(int j = 0; j < 21; j++) {
				int a = j + arr[i];
				int b = j - arr[i];
				if(a <= 20) dp[i][j] += dp[i - 1][a];
				if(b >= 0) dp[i][j] += dp[i - 1][b];
			}
		}
		System.out.println(dp[N - 1][arr[N]]);
	}
}
