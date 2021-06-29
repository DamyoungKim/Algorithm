package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	static int[] dp = new int[12];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		solve(0);
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

	private static void solve(int n) {
		if (n > 12) {
			return;
		}
		dp[n]++;
		if (n + 1 < 12) {
			solve(n + 1);
		}
		if (n + 2 < 12) {
			solve(n + 2);
		}
		if (n + 3 < 12) {
			solve(n + 3);
		}
	}

}
