package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {
	static int N, M, T;
	static int[][] arr, mode;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean same;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mode = new int[T][3];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				mode[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			rotate(i);
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1) continue;
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void rotate(int cnt) {
		int X = mode[cnt][0];
		int D = mode[cnt][1];
		int K = mode[cnt][2];
		for (int k = 0; k < K; k++) {
			for (int i = X; i <= N; i += X) {
				int temp = 0;
				if (D == 0) {
					temp = arr[i][M - 1];
					for (int j = M - 1; j > 0; j--) {
						arr[i][j] = arr[i][j - 1];
					}
					arr[i][0] = temp;
				} else {
					temp = arr[i][0];
					for (int j = 0; j < M - 1; j++) {
						arr[i][j] = arr[i][j + 1];
					}
					arr[i][M - 1] = temp;
				}
			}
		}
		boolean isFinded = false;
		int sum = 0;
		int n = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				same = false;
				if (temp != -1) {
					sum += temp;
					n++;
					dfs(i, j, temp);
					if (!same) {
						arr[i][j] = temp;
					} else {
						isFinded = true;
					}
				}
			}
		}
		if (!isFinded) {
			double avg = (double) sum / n;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == -1) continue;
					if (arr[i][j] > avg) arr[i][j]--;
					else if (arr[i][j] < avg) arr[i][j]++;
				}
			}
		}
	}

	private static void dfs(int y, int x, int val) {
		arr[y][x] = -1;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny > N || ny < 1) continue;
			if (nx == M) nx = 0;
			if (nx == -1) nx = M - 1;
			if (val != arr[ny][nx]) continue;
			same = true;
			dfs(ny, nx, val);
		}
	}
}
