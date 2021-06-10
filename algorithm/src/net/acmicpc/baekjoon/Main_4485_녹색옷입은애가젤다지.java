package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] arr, result;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int cnt = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			
			arr = new int[N][N];
			result = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = Integer.MAX_VALUE;
				}
			}
			result[0][0] = arr[0][0];
			bfs();
			
			System.out.println("Problem " + cnt++ + ": " +  result[N-1][N-1]);
		}
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.poll()[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny >= N || nx >= N || ny < 0 || nx < 0) continue;
				
				int temp = result[y][x] + arr[ny][nx];
				if(result[ny][nx] > temp) {
					result[ny][nx] = temp;
					q.offer(new int[] {ny, nx});
				}
				
			}
		}
	}

}
