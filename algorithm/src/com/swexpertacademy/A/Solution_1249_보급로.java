package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로 {
	static int N;
	static int[][] arr, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			result = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					result[i][j] = Integer.MAX_VALUE;
				}
			}
			result[0][0] = 0;
			bfs();
			System.out.println("#" + t + " " + result[N - 1][N - 1]);
		}
	}


	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0});
		int dx[] = { 0, 1, 0, -1 }, dy[] = { -1, 0, 1, 0 };
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= N || nx >= N || ny < 0 || nx < 0)
					continue;
				int temp = result[y][x] + arr[ny][nx];
				if (result[ny][nx] > temp) {
					q.offer(new int[] { ny, nx, i});
					result[ny][nx] = temp;
				}
			}
		}
	}
}
