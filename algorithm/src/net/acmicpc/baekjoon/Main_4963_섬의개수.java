package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;

public class Main_4963_섬의개수 {
	static int w, h;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			visited = new boolean[h][w];
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visited[i][j] || map[i][j] == 0) continue;
					cnt++;
					dfs(i, j);
				}
			}
			sb.append(cnt);
			sb.append('\n');
		}
		System.out.print(sb);
	}
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= h || nx >= w || visited[ny][nx] || map[ny][nx] == 0) continue;
			dfs(ny, nx);
		}
	}

}
