package net.acmicpc.baekjoon;

import java.io.*;
import java.util.*;

public class Main_2468_안전영역 {
	static int N, max;
	static int[][] arr;
	static boolean[][] visited, tempArr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		
		visited = new boolean[N][N];
		tempArr = new boolean[N][N];
		int result = 1;
		for (int h = 1; h < max; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == h) {
						visited[i][j] = true;
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempArr[i][j] = visited[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!tempArr[i][j]) {
						cnt++;
						safeZone(i, j);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);

	}
	private static void safeZone(int y, int x) {
		tempArr[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= N || nx >= N || ny < 0 || nx < 0 || tempArr[ny][nx]) continue;
			safeZone(ny, nx);
		}
	}
}
