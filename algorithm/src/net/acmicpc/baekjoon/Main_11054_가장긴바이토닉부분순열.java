package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11054_가장긴바이토닉부분순열 {
	static int N;
	static int[] arr = new int[1001];
	static int[][] dp = new int[1001][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && dp[j][0] + 1 > dp[i][0]) {
					dp[i][0] = dp[j][0] + 1;
				}
			}
			
		}
		
		for (int i = N; i >= 0; i--) {
			dp[i][1] = 1;
			for (int j = N; j > i; j--) {
				if (arr[i] > arr[j] && dp[j][1] + 1 > dp[i][1]) {
					dp[i][1] = dp[j][1] + 1;
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i][0] + dp[i][1] - 1);
		}
		
		System.out.println(max);
	}
}
