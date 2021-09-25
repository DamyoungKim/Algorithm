package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	static int N, num;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static class Node {
		int y;
		int x;
		int num;
		public Node(int y, int x, int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}
	static Queue<Node> q = new LinkedList<>();
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		setIsland();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] != 0 && nearSea(i,  j)) q.offer(new Node(i, j, arr[i][j]));
			}
		}
		
		bfs();	
	}

	private static void setIsland() {
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, ++num, visited);
				}
			}
		}
	}
	
	private static void bfs() {
		int result = 0;
		int size = 0;
		boolean[][][] visited = new boolean[N][N][num + 1];
		while (!q.isEmpty()) {
			size = q.size();
			result++;
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					int num = cur.num;
					if(ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx][num]) continue;
					if(arr[ny][nx] == 0) {
						q.offer(new Node(ny,nx, num));
						visited[ny][nx][num] = true;
					} else {
						if(arr[ny][nx] != num) {
							System.out.println(result - 1);
							return;
						}
					}
				}
			}
		}
	}


	private static void dfs(int y, int x, int num, boolean[][] visited) {
		arr[y][x] = num;
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 0) continue;
			
			dfs(ny, nx, num, visited);
		}
		
	}
	
	private static boolean nearSea(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= N || nx >= N || ny < 0 || nx < 0) continue;
			if(arr[ny][nx] == 0) return true;
		}
		
		return false;
	}
}
