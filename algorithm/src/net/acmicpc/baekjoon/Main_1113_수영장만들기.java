package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1113_수영장만들기 {
	static int N, M, result;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean visited[][];
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 2; i <= 9; i++) { // 채울수 있는 물에 높이 2 ~ 9
			visited = new boolean[N][M]; // 높이가 달라질때마다 visited 배열을 초기화
			for(int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if(visited[y][x] || arr[y][x] >= i) continue; // 이미 처리되었거나 (visted)
																  // 물을 채울수 없으면 (arr >= i)
					q = new LinkedList<>();
					visited[y][x] = true;
					q.offer(new int[] {y, x});
					bfs(i);
				}
			}
		}
		System.out.println(result);

	}

	private static void bfs(int h) {
		int cnt = 1;
		boolean check = false;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int y = temp[0];
			int x = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny >= N || nx >= M || ny < 0 || nx < 0) {
					check = true;
					continue;
				} // 해당 높이에 물을 채우다보니 물이 흘러 넘칠 경우 발생
				if(arr[ny][nx] < h && !visited[ny][nx]) { // 설정 높이 보다 작은곳에 물 채울수 있다.	
					cnt++;
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		if(!check ) { // 테두리에 있는 영역이 없다.
			result += cnt;
		}

	}

}

