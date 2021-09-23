package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;
public class Main_1520_내리막길 {
	static int N, M;
	static int[][] arr, dp;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		solve(0, 0);
		System.out.println(dp[0][0]);
	}
	private static int solve(int y, int x) {
		visited[y][x] = true;
		if (y == N - 1 && x == M - 1) {
			return 1;
		}
		
		if (dp[y][x] > -1) {
			return dp[y][x];
		}
		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= M || ny < 0  || nx < 0 || arr[y][x] <= arr[ny][nx]) continue;
			dp[y][x] += solve(ny, nx);
		}
		return dp[y][x];
	}
}
