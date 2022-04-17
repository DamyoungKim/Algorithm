package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2133_타일채우기 {
	static int N;
	static int[] dp = new int[31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp[0] = 1;
		if (N >= 2) {
			dp[2] = 3;
		}
		for (int i = 2; i <= N; i += 2) {
			dp[i] = 3 * dp[i - 2];
			for (int j = 4; j <= i; j += 2) {
				dp[i] += 2 * dp[i - j];
			}
		}
		System.out.println(dp[N]);
	}
}
