package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_10026_적록색약 {
	static int N, cnt;
	static char[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				dfs1(i, j, arr[i][j]);
				cnt++;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append(cnt + " ");
		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				dfs2(i, j, arr[i][j]);
				cnt++;
			}
		}
		sb.append(cnt);

		System.out.println(sb.toString());
	}

	private static void dfs1(int y, int x, char color) {
		visited[y][x] = true;
	
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || color != arr[ny][nx]) continue;
			dfs1(ny, nx, color);
			
		}
	}
	
	private static void dfs2(int y, int x, char color) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx]) continue;
			if(color == 'B' && (arr[ny][nx] == 'R' || arr[ny][nx] == 'G')) continue;
			if((color == 'R' || color == 'G') && arr[ny][nx] == 'B') continue;
			dfs2(ny, nx, color);
			
		}
	}

}
