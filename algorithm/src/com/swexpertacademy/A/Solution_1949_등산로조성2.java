package com.swexpertacademy.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1949_등산로조성2 {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int K = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = sc.nextInt();
					arr[i][j] = temp;
					max = max > temp ? max : temp;
				}
			}

			List<int[]> maxList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max)
						maxList.add(new int[] { i, j, K });
				}
			}
			int size = maxList.size();
			for (int i = 0; i < size; i++) {
				int y = maxList.get(i)[0];
				int x = maxList.get(i)[1];
				visited[y][x] = true;
				solve(y, x, maxList.get(i)[2], 1);
				visited[y][x] = false;
			}

			System.out.println("#" + t + " " + result);
			result = 0;
		}
	}

	private static void solve(int y, int x, int K, int d) {

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] - arr[y][x] >= K)
				continue;

			int temp = -1;
			if (arr[ny][nx] >= arr[y][x]) {
				temp = arr[ny][nx] - arr[y][x];
				K = K - temp - 1;
				arr[ny][nx] = arr[y][x] - 1;
			}
			visited[ny][nx] = true;
			solve(ny, nx, K, d + 1);
			if (temp != -1) {
				arr[ny][nx] = arr[ny][nx] + 1;
				K = K + temp + 1;
			}
			visited[ny][nx] = false;
		}
		result = result > d ? result : d;
	}
}
