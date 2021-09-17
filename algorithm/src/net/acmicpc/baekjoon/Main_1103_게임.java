package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1103_게임 {
	static int N, M;
	static boolean isEnd;
	static int[][] arr, dp;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char temp = s.charAt(j);
				if (temp == 'H') {
					arr[i][j] = -1;
				} else {
					arr[i][j] = temp - '0';
				}
				
			}
		}
		visited[0][0] = true;
		solve(0, 0, 0);
		System.out.println(isEnd ? -1 : dp[0][0]);
	}
	private static void solve(int y, int x, int cnt) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i] * arr[y][x];
			int nx = x + dx[i] * arr[y][x];
			
			if(ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == -1) {
				if(dp[y][x] == 0) {
					dp[y][x] = 1;
				}
				continue;
			}
			
			if(visited[ny][nx]) {
				isEnd = true;
				return;
			}
			if(dp[ny][nx] !=  0) {
				dp[y][x] = Math.max(dp[y][x], dp[ny][nx] + 1);
				continue;
			}
			visited[ny][nx] = true;
			if(!isEnd) solve(ny, nx, cnt + 1);
			dp[y][x] = Math.max(dp[y][x], dp[ny][nx] + 1);
			visited[ny][nx] = false;
		}
	}
	
}
