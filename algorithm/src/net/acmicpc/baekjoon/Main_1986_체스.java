package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1986_체스 {
	static int N, M;
	static int[][] arr;
	static int[] q_dx = {0, 1, 1, 1, 0, -1, -1, -1}, q_dy = {-1, -1, 0, 1, 1, 1, 0, -1}, 
			k_dx = {1, 2, 2, 1, -1, -2, -2, -1}, k_dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 1; i <= 3; i++) { // Q = 1, K = 2, P = 3
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					queen(i, j);
				} else if (arr[i][j] == 2) {
					knight(i, j);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) result++;
			}
		}
		
		System.out.println(result);
	}

	private static void queen(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int len = 0;
			while(true) {
				len++;
				int ny = y + q_dy[i] * len;
				int nx = x + q_dx[i] * len;
				if(ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == 1 || arr[ny][nx] == 2 ||arr[ny][nx] == 3) break;
				arr[ny][nx] = -1;
			}
		}
	}
	
	private static void knight(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int ny = y + k_dy[i];
			int nx = x + k_dx[i];
			if (ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] != 0) continue;
			arr[ny][nx] = -1;
		}
	}
	
}
