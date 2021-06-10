package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[N][M][2];
		visited[0][0][1] = true;
		q.offer(new int[] { 0, 0, 1 });

		bfs();
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int j = 0; j < size; j++) {
				int y = q.peek()[0];
				int x = q.peek()[1];
				int chance = q.poll()[2];
				if (y == N - 1 && x == M - 1) {
					System.out.println(cnt);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx][chance])
						continue;
					if (arr[ny][nx] == 1) {
						if (chance == 1) {
							visited[ny][nx][0] = true;
							q.offer(new int[] { ny, nx, 0 });
							continue;
						} else {
							continue;
						}
					}
					
					visited[ny][nx][chance] = true;
					q.offer(new int[] { ny, nx, chance });
				}
			}
		}
		System.out.println(-1);
	}
}