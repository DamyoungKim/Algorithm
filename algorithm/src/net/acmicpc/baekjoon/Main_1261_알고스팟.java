package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static int N, M;
	static int[][] arr, result;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
				result[i][j] = Integer.MAX_VALUE;
			}
		}
		result[0][0] = 0;
		q.offer(new int[] {0, 0, 0});
		bfs();
		System.out.println(result[N-1][M-1]);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			int y = temp[0];
			int x = temp[1];
			int cnt = temp[2];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny >= N || nx >= M || ny < 0 || nx < 0) continue;
				if(arr[ny][nx] == 1 && result[ny][nx] > cnt + 1) {
					result[ny][nx] = cnt + 1;
					q.offer(new int[] {ny, nx, cnt + 1});
				}else if(arr[ny][nx] == 0 && result[ny][nx] > cnt) {
					result[ny][nx] = cnt;
					q.offer(new int[] {ny, nx, cnt});
				}
			}
		}
	}
}
