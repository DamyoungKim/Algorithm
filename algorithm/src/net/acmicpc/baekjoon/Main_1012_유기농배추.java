package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_1012_유기농배추 {
	static int N, M, cnt;
	static int[][] arr;
	static int[] dx = {0, 1, 0 , -1}, dy = {-1, 0, 1, 0}; 
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		int K = sc.nextInt();
		for(int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
				arr[y][x] = 1;
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				cnt = 0;
				if(arr[i][j] == 0 || visited[i][j]) continue;
				result++;
				dfs(i, j);
			}
		}
		
		System.out.println(result);

		}
	}
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		cnt++;

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 0) continue;
			dfs(ny, nx);
		}
	}

}