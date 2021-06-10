package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class SafeZone {
	int y;
	int x;
	public SafeZone(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
public class Solution_1868_파핑파핑지뢰찾기2 {
	static int N;
	static char[][] arr, copyArr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 }, dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static List<SafeZone> szList;
	static int[] order;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			copyArr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			szList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == '.') {
						if(check(i, j)) {
							szList.add(new SafeZone(i, j));
						}
					}
				}
			}
			visited = new boolean[N][N];
			int count = 0;
			for(int i = 0; i < szList.size(); i++) {
				int y = szList.get(i).y;
				int x = szList.get(i).x;
				if(!visited[y][x]) {
					count++;
					solve(y, x, visited);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == '*' || visited[i][j]) continue;
					count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}

	}

	private static void solve(int r, int c, boolean[][] visited) {
		q.offer(new int[] {r, c});
		visited[r][c] =  true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int y = temp[0];
			int x = temp[1];
			int cnt = 0;
			for(int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx]) continue;
				if(arr[ny][nx] == '*') {
					cnt++;
					break;
				}
			}
			if(cnt == 0) {
				for(int i = 0; i < 8; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if(ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == '*' || visited[ny][nx]) continue;
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
			
		}
	}

	private static boolean check(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0)
				continue;
			if (arr[ny][nx] == '*')
				return false;
		}
		return true;
	}

}
