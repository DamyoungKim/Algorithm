package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int[][] dice, arr;
	static int N, M, K;
	static int[] commend, dx = { 0, 1, -1, 0, 0 }, dy = { 0, 0, 0, -1, 1 };
								// 동 서 북 남

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		dice = new int[7][1];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		commend = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			commend[i] = Integer.parseInt(st.nextToken());
		}
		
		solve2(x, y, 1, 6, 3, 4, 2, 5, 0);

	}

	static void solve2(int x, int y, int top, int bottom, int east, int west, int north, int south, int order) {
		if(order == K) {
			return;
		}
		int dir = commend[order];
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		if( ny >= N || nx >= M || ny < 0 || nx < 0) {
			solve2(x, y, top, bottom, east, west, north, south, order + 1);
		}else {
			int t = 0;
			int b = 0;
			int e = 0;
			int w = 0;
			int n = 0;
			int s = 0;
			switch(dir) {
			case 1: 
				t = west;
				b = east;
				n = north;
				s = south;
				e = top;
				w = bottom;
				break;
			case 2:	
				t = east;
				b = west;
				n = north;
				s = south;
				e = bottom;
				w = top;
				break;
			case 3: 
				t = south;
				b = north;
				n = top;
				s = bottom;
				e = east;
				w = west;
				break;
			case 4: 
				t = north;
				b = south;
				n = bottom;
				s = top;
				e = east;
				w = west;
				break;
			}
			if(arr[ny][nx] == 0 ) {
				arr[ny][nx] = dice[b][0];
			}else if (arr[ny][nx] != 0) {
				dice[b][0] = arr[ny][nx];
				arr[ny][nx] = 0;
			}
			System.out.println(dice[t][0]);
		 	solve2(nx, ny, t, b, e, w, n, s, order + 1);
		}
		
	}

}