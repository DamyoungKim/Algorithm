package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	static int T, N, K, result;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(arr[i][j], max);
				}
			}
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max) {
						solve(i, j, 1, 1);
						visited[i][j] = false;
					}
				}
			}
			System.out.println("#" + t + " " + result);
			
		}
	}
	private static void solve(int y, int x, int k, int cnt) {
		visited[y][x] =true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx]) continue;
			if (arr[ny][nx] >= arr[y][x]) {
				if (k != 1 || arr[ny][nx] - arr[y][x] >= K) continue;
				int temp = arr[ny][nx];
				arr[ny][nx] = arr[y][x] - 1;
				solve(ny, nx, 0, cnt + 1);
				arr[ny][nx] = temp;
			} else {
				solve(ny, nx, k, cnt + 1);
			}
			visited[ny][nx] = false;
		}
		result = Math.max(result, cnt);
	}

}
