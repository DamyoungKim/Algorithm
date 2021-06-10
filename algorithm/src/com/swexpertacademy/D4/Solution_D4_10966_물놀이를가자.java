package com.swexpertacademy.D4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Land {
	int y;
	int x ;
	
	public Land (int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Solution_D4_10966_물놀이를가자 {
	static int N, M;
	static char[][] map;
	static List<Land> landList = new ArrayList<>();
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int totalCnt = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			visited = new boolean[N][M];
			landList.clear();
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					char temp = s.charAt(j);
					map[i][j] = temp;
					if(temp =='L') {
						landList.add(new Land(i,j));
					}
				}
			}
			int size = landList.size();
			int sum = 0;
			for(int i = 0; i < size; i++) {
				int x = landList.get(i).x;
				int y = landList.get(i).y;
				visited[y][x] = true;
				solve(y,x,0);
				visited[y][x] = false;
				sum += totalCnt;
				totalCnt = Integer.MAX_VALUE;
			}
			System.out.println("#" + t + " " + sum);
		}

	}
	private static void solve(int y, int x, int count) {
		if(map[y][x] == 'W') {
			totalCnt = totalCnt > count ? count : totalCnt;
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= M || ny >= N || nx < 0 || ny < 0 || visited[ny][nx]) continue;
			visited[y][x] = true;
			solve(ny, nx, count + 1);
			visited[y][x] = false;;

		}
	}

}




