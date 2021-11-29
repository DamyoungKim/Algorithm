package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17779_게리맨더링2 {
	static int N, X, Y, result;
	static int[][] arr, selected;
	static int[] dx = { 1, 1, -1, -1 }, dy = { -1, 1, 1, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MAX_VALUE;
		visited = new boolean[N][N];
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < N - 1; j++) {
				Y = i;
				X = j;
				solve(i, j, 0, 1, 0, 0, 1);
				visited[i][j] = false;
			}
		}
		System.out.println(result);
	}

	private static void solve(int y, int x, int a, int b, int c, int d, int dir) {
		visited[y][x] = true;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (a == c && b == d) {
			selected = new int[N][N];
			int d1 = a;
			int d2 = b;
			int[] count = new int[5];
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int startX = 0;
				int endX = 0;
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) {
						cnt++;
						if (cnt == 1) {
							startX = j;
						} else {
							endX = j;
							break;
						}
					}
				}
				if (cnt == 1) {
					selected[i][startX] = 5;
				} else if (cnt == 2) {
					for (int j = startX; j <= endX; j++) {
						selected[i][j] = 5;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (selected[i][j] == 5) {
						count[4] += arr[i][j];
					} else if (0 <= i && i < Y + d1 && 0 <= j && j <= X) {
						count[0] += arr[i][j];
						selected[i][j] = 1;
					} else if (0 <= i && i <= Y + d2 && X < j && j < N) {
						count[1] += arr[i][j];
						selected[i][j] = 2;
					} else if (Y + d1 <= i && i < N && 0 <= j && j < X - d1 + d2) {
						count[2] += arr[i][j];
						selected[i][j] = 3;
					} else if (Y + d2 < i && i < N && X - d1 + d2 <= j && j < N) {
						count[3] += arr[i][j];
						selected[i][j] = 4;
					} 
				}
			}
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 5; i++) {
				int temp = count[i];
				min = Math.min(temp, min);
				max = Math.max(temp, max);
			}
			result = Math.min(result, max - min);
			return;
		}
		if (ny >= N || nx >= N || ny < 0 || nx < 0) {
			return;
		}
		if (dir == 1) {
			solve(ny, nx, a, b + 1, c, d, 1);
			visited[ny][nx] = false;
			solve(ny, nx, a, b, c + 1, d, 2);
			visited[ny][nx] = false;
		} else if (dir == 2) {
			solve(ny, nx, a, b, c + 1, d, 2);
			visited[ny][nx] = false;
			solve(ny, nx, a, b, c, d + 1, 3);
			visited[ny][nx] = false;
		} else if (dir == 3) {
			if (b != d) {
				solve(ny, nx, a, b, c, d + 1, 3);
				visited[ny][nx] = false;
			} else {
				solve(ny, nx, a + 1, b, c, d, 0);
				visited[ny][nx] = false;
			}
		} else if (dir == 0) {
			solve(ny, nx, a + 1, b, c, d, 0);
			visited[ny][nx] = false;
		} 
	}

}
/*
7
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0


 */