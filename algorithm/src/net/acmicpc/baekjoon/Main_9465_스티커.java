package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		StringBuffer sb = new StringBuffer();
//		for (int t = 1; t <= T; t++) {
//			int N = Integer.parseInt(br.readLine());
//			int[][] arr = new int[3][N + 1];
//			int[][] dp = new int[3][N + 1];
//			for(int i = 1; i < 3; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				for(int j = 1; j < N + 1; j++) {
//					arr[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			dp[1][1] = arr[1][1];
//			dp[2][1] = arr[2][1];
//			for(int j = 2; j < N + 1; j++) {
//						dp[1][j] = Math.max(Math.max(dp[1][j - 2], dp[2][j - 2]) + arr[1][j], dp[2][j - 1] + arr[1][j]);
//						dp[2][j] = Math.max(Math.max(dp[1][j - 2], dp[2][j - 2]) + arr[2][j], dp[1][j - 1] + arr[2][j]);
//				
//			}
//			sb.append(Math.max(dp[1][N], dp[2][N]));
//			sb.append('\n');
//		}
//		System.out.println(sb);
//	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++ ) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			int[][] dp = new int[3][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			for (int i = 1; i < N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[2][i - 1] + arr[0][i]);
				dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[2][i - 1] + arr[1][i]);
				dp[2][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
			}
			int ans = 0;
			for (int i = 0; i < 3; i++) {
				ans = Math.max(dp[i][N - 1], ans);
			}
			System.out.println(ans);
		}
	}

}
