package com.swexpertacademy.A;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2117_홈방범서비스 {
	static int N, M, result;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			M = sc.nextInt();
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			result = 1;
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}

			
			System.out.println("#" + t + " " + result);
		}
		
		
	}
	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		int homeCnt = 0;
		if(arr[row][col] == 1) homeCnt++;
		boolean[][] visited = new boolean[N][N];
		visited[row][col] = true;
		int cnt = 0;
		while(true) {
			if(cnt == 2 * N) {
				return;
			}
			int size = q.size();
			cnt++;
			
			for(int i = 0; i < size; i++) {
				int[] tempArr = q.poll();
				int y = tempArr[0];
				int x = tempArr[1];
				
				for(int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if( ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx]) continue;
					if(arr[ny][nx] == 1) homeCnt++;
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
			int benefit = homeCnt * M -  ((cnt + 1) * (cnt + 1) + cnt * cnt);
			if(benefit < 0) continue;
			result = result > homeCnt ? result : homeCnt;
		}
		
	}

}
