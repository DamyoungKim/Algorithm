package com.swexpertacademy.A;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] pipes = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			visited = new boolean[N][M];
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			bfs();
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						result++;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

	private static void bfs() {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { R, C });
		int cnt = 0;

		visited[R][C] = true;
		while (!q.isEmpty()) {

			cnt++;
			if (cnt == L) {
				return;
			}
			int size = q.size();
			for (int j = 0; j < size; j++) {
				int y = q.peek()[0];
				int x = q.poll()[1];
				for (int i = 0; i < 4; i++) {
					boolean pass = false;
					for (int p = 0; p < pipes[arr[y][x]].length; p++) {
						if (pipes[arr[y][x]][p] == i) {
							pass = true;
							break;
						}
					}
					if (!pass)
						continue;

					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 0)
						continue;

					for (int k = 0; k < pipes[arr[ny][nx]].length; k++) {
						if ((i + 2) % 4 == pipes[arr[ny][nx]][k]) {
							visited[ny][nx] = true;
							q.offer(new int[] { ny, nx });
							break;
						}
					}

				}
			}
		}
	}
}
