package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;
public class Main_1890_점프 {
	static int N;
	static int[][] arr;
	static long[][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		solve(0, 0);
		System.out.println(dp[0][0]);
	}
	private static long solve(int y, int x) {
		if (y == N - 1 && x == N - 1) {
			return 1L;
		}
		
		if (dp[y][x] != -1) return dp[y][x];
		dp[y][x] = 0;
		
		for (int i = 0; i < 2; i++) {
			int ny = y + dy[i] * arr[y][x];
			int nx = x + dx[i] * arr[y][x];
			
			if (ny >= N || nx >= N || ny < 0 || nx < 0) {
				continue;
			}
			
			dp[y][x] += solve(ny, nx);
		}
		
		return dp[y][x];
	}
}
