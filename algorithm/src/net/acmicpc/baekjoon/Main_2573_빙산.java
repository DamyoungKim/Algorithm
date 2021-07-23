package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static int N, M;
	static int[][] arr, temp;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		int time = 0;
		while(true) {
			int status = check();
			if(status == 1) {
				break;
			}else if (status == 0) {
				time = 0;
				break;
			}
			time++;
			temp = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] != 0) continue;
					cal(i, j);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					arr[i][j] = arr[i][j] - temp[i][j];
					if(arr[i][j] < 0 ) arr[i][j] = 0;
				}
			}
			
		}
		
		System.out.println(time);
	}
	
	
	private static void cal(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == 0) continue;
			temp[ny][nx]++;
		}
		
		
	}
	
	private static int check() {
		int cnt = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] || arr[i][j] == 0) continue;
				cnt++;
				dfs(i, j);
				if(cnt == 2) return 1;
			}
		}
		if(cnt == 0) return 0;
		return -1;
	}
	
	private static void dfs(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == 0 || visited[ny][nx]) continue;
			visited[ny][nx] = true;
			dfs(ny, nx);
			
		}
		
	}
}
