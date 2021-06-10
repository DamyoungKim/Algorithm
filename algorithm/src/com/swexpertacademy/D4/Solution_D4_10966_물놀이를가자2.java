package com.swexpertacademy.D4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Water {
	int y;
	int x ;
	
	public Water (int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Solution_D4_10966_물놀이를가자2 {
	static int N, M;
	static char[][] map;
	static List<Water> landList = new ArrayList<>();
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int totalCnt = Integer.MAX_VALUE;
	static int[][] cntArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			visited = new boolean[N][M];
			cntArr = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					cntArr[i][j] = Integer.MAX_VALUE;
				}
			}
			landList.clear();
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					char temp = s.charAt(j);
					map[i][j] = temp;
					if(temp =='W') {
						cntArr[i][j] = 0;
						landList.add(new Water(i,j));
					}
				}
			}
			int size = landList.size();
			int sum = 0;
			for(int i = 0; i < size; i++) {
				int x = landList.get(i).x;
				int y = landList.get(i).y;
				visited[y][x] = true;
				solve(y,x,1);
				visited[y][x] = false;
			}
			for(int i = 0; i < N; i++) {
				for(int  j = 0; j < M; j++) {
					if(cntArr[i][j] != 0) sum += cntArr[i][j];
				}
			}
			System.out.println("#" + t + " " + sum);
		}

	}
	private static void solve(int y, int x, int count) {
	
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= M || ny >= N || nx < 0 || ny < 0 || map[ny][nx] == 'W' || visited[ny][nx] || cntArr[ny][nx] < count) continue;
			visited[ny][nx] = true;
			cntArr[ny][nx] = count;
			solve(ny, nx, count + 1);
			visited[ny][nx] = false;
		}
	}

}




