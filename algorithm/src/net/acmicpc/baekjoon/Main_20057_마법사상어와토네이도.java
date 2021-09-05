package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	static int N, result;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 좌 하 우 상
	static int[][] tornadoW = {{-1, 0, 1}, {-1, -1, 7}, {-2, -1, 2}, {-1, -2, 10}, {0, -3, 5}, {1, -2, 10}, {1, -1, 7}, {2, -1, 2}, {1, 0, 1}, {0, -2, 0}},
					tornadoS = {{0, -1, 1}, {1, -1, 7}, {1, -2, 2}, {2, -1, 10}, {3, 0, 5}, {2, 1, 10}, {1, 1, 7}, {1, 2, 2}, {0, 1, 1}, {2, 0, 0}},
					tornadoE = {{-1, 0, 1}, {-1, 1, 7}, {-2, 1, 2}, {-1, 2, 10}, {0, 3, 5}, {1, 2, 10}, {1, 1, 7}, {2, 1, 2}, {1, 0, 1}, {0, 2, 0}},
					tornadoN = {{0, -1, 1}, {-1, -1, 7}, {-1, -2, 2}, {-2, -1, 10}, {-3, 0, 5}, {-2, 1, 10}, {-1, 1, 7}, {-1, 2, 2}, {0, 1, 1}, {-2, 0, 0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		int dir = 0, len = 1, y = N / 2, x = N / 2;
		while(true) {
			for(int i = 0 ; i < 2; i++) {
				for(int j = 0; j < len; j++) {
					if(y == 0 && x == 0) {
						System.out.println(result);
						return;
					}
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					spread(y, x, dir, arr[ny][nx]);
					arr[ny][nx] = 0;
					y = ny;
					x = nx;
				}
				dir = (dir + 1) % 4;
			}
			len++;
		}
		
	}

	
	private static void spread(int y, int x, int dir, int sand) {
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			int ny = 0;
			int nx = 0;
			int val = 0;			
			switch(dir) {
				case 0: 
					ny = y + tornadoW[i][0];
					nx = x + tornadoW[i][1];
					val = sand * tornadoW[i][2] / 100;
					break;
				case 1: 
					ny = y + tornadoS[i][0];
					nx = x + tornadoS[i][1];
					val = sand * tornadoS[i][2] / 100;
					break;
				case 2: 
					ny = y + tornadoE[i][0];
					nx = x + tornadoE[i][1];
					val = sand * tornadoE[i][2] / 100;
					break;
				case 3: 
					ny = y + tornadoN[i][0];
					nx = x + tornadoN[i][1];
					val = sand * tornadoN[i][2] / 100;
					break;
			}
			sum += val;
			if(i == 9) {
				val = sand - sum;
			}
			
			if(ny >= N || nx >= N || ny < 0 || nx < 0) {
				result += val;
				continue;
			}
			arr[ny][nx] += val;
		}
	}

}
