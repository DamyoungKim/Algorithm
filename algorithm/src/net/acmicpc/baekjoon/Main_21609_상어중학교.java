package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_21609_상어중학교 {
	static int N, M, rainbowCnt, max, cnt, rainbowMax, r, c, score;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {

			findMaxGroubBlock();
			if (max == 0) {
				System.out.println(score);
				return;
			}
			removeBlock();
			down();
			rotate();
			down();

		}
	}

	private static void findMaxGroubBlock() {
		visited = new boolean[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == -1 || arr[i][j] == 0 || arr[i][j] == -2 || visited[i][j])
					continue;
				setVisitedArray();
				rainbowCnt = 0;
				cnt = 1;
				findDfs(i, j, arr[i][j]);
				if (cnt == 1)
					continue;
				if (cnt >= max) {
					if (cnt == max) {
						if (rainbowCnt < rainbowMax) {
							continue;
						}
					}
					r = i;
					c = j;
					max = cnt;
					rainbowMax = rainbowCnt;
				}

			}
		}
	}

	private static void findDfs(int y, int x, int val) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == -1 || arr[ny][nx] == -2)
				continue;
			if (arr[ny][nx] != val) {
				if (arr[ny][nx] != 0)
					continue;
			}
			if (arr[ny][nx] == 0)
				rainbowCnt++;
			cnt++;
			findDfs(ny, nx, val);
		}
	}

	private static void rotate() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				temp[i][N - 1 - j] = arr[N - 1 - j][N - 1 - i];
			}
		}
		arr = temp;
	}

	private static void setVisitedArray() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					visited[i][j] = false;
				}
			}
		}
	}

	private static void removeBlock() {
		boolean[][] visited = new boolean[N][N];
		removeDfs(r, c, visited, arr[r][c]);
		score += (int) Math.pow(max, 2);
	}

	private static void removeDfs(int y, int x, boolean[][] visited, int val) {
		visited[y][x] = true;
		arr[y][x] = -2;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == -1 || arr[ny][nx] == -2)
				continue;
			if (arr[ny][nx] != val) {
				if (arr[ny][nx] != 0)
					continue;
			}
			removeDfs(ny, nx, visited, val);
		}
	}

	private static void down() {
		Stack<Integer> stack = new Stack<>();
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (arr[i][j] == -2)
					continue;
				stack.add(arr[i][j]);
			}
			for (int i = N - 1; i >= 0; i--) {
				if (stack.isEmpty()) {
					if (arr[i][j] == -1)
						continue;
					arr[i][j] = -2;
				} else {
					if (stack.peek() == -1) {
						while (true) {
							int ny = i--;
							if (arr[ny][j] == -1)
								break;
							if (i < 0)
								break;
							arr[ny][j] = -2;
						}
						stack.pop();
						i++;
					} else {
						arr[i][j] = stack.pop();
					}
				}
			}
		}
	}

}
