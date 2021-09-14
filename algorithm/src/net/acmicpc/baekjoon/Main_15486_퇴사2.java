package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15486_퇴사2 {
	static int N, max;
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N + 2];
		solve(N);
		System.out.println(dp[1]);
	}
	private static void solve(int now) {
		if(now == 0) return;
		if(now + arr[now][0] <= N + 1 ) dp[now] = Math.max(arr[now][1] + dp[now + arr[now][0]], dp[now + 1]);
		else dp[now] = dp[now + 1];
		solve(now - 1);
	}
}
