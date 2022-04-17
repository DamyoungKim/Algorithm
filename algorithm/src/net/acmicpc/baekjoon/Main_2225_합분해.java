package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2225_합분해 {
	static int N, K;
	static int[][] dp = new int[201][201];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp[0][0] = 1;
	
		for (int k = 1; k <= K; k++) {
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= i; j++) {
					dp[i][k] += dp[i - j][k - 1];
					dp[i][k] %= 1000000000;
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
