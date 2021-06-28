package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2616_소형기관차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
		}

		int K = Integer.parseInt(br.readLine());

		int[][] dp = new int[4][N + 1];

		for (int i = 1; i < 4; i++) {
			for (int j = i * K; j < N + 1; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + Math.abs(arr[j] - arr[j - K]));
			}
		}
		System.out.println(dp[3][N]);
	}

}
