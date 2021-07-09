package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static class Robot {
		int y;
		int x;
		int dir;
		int cnt = 1;
		public Robot(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
	static Robot robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));

		arr = new int[N][M];
		visited= new boolean[N][M];
		visited[robot.y][robot.x] = true;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(find());
		
		System.out.println(robot.cnt);
	
	}

	private static boolean find() {
		for(int i = 0; i < 4; i++) {
			robot.dir = ( robot.dir + 3 ) % 4;
			int y = robot.y + dy[robot.dir];
			int x = robot.x + dx[robot.dir];
			
			if(y >= N || x >= M || y < 0 || x < 0 || visited[y][x] || arr[y][x] == 1) continue;
			
				robot.y = y;
				robot.x = x;
				robot.cnt++;
				visited[y][x] = true;
				return true;
			
		}
		
		int y = robot.y + dy[(robot.dir + 2) % 4];
		int x = robot.x + dx[(robot.dir + 2) % 4];
		
		if(y >= N || x >= M || y < 0 || x < 0 || arr[y][x] == 1) return false;
		
		robot.y = y;
		robot.x = x;
		
		return true;
	}
	
	
}
