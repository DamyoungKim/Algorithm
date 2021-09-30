package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int N, M, K;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] square;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		square = new int[K][4];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			square[k][0] = x1;
			square[k][1] = y1;
			square[k][2] = x2;
			square[k][3] = y2;
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					arr[y][x] = -1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1 || visited[i][j]) continue;
				cnt++;
				dfs(i, j, cnt);
			}
		}
		int[] result = new int[cnt + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1) continue;
				result[arr[i][j]]++;
			}
		}
		Arrays.sort(result);
		System.out.println(cnt);
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= cnt; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
		
	}
	private static void dfs(int y, int x, int cnt) {
		arr[y][x] = cnt;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == -1) continue;
			dfs(ny, nx, cnt);
		}
		
	}

}
