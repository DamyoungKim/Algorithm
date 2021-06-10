package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_삼국지 {
	static int N;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static int[][] own, sol, sup;
	static boolean[] turns;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			own = new int[N][N];
			sol = new int[N][N];
			sup = new int[N][N];
			turns = new boolean[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					own[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					sol[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					sup[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean end = true;
			while(end) {
				for(int turn = 1; turn <= 3; turn++) {
					if(turns[turn]) continue;
					attack(turn);
					help(turn);
					supplement();
					Arrays.fill(turns, true);
					checkEndCon();
					if(checkEnd()) {
						end = false;
						break;
					}
				}
			}
			int result = 0;
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					result += sol[i][j];
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
	
	private static void attack(int turn) {
		int[][] tempSol = new int[N][N];
		int[][] tempOwn = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(own[i][j] == turn || own[i][j] == 0) {
					tempOwn[i][j] = own[i][j];
					continue;
				}
				int sum = 0;
				for(int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					
					if(ny >= N || nx >= N || ny < 0 || nx < 0 || own[ny][nx] != turn) continue;
					sum += sol[ny][nx];
				}
				
				if(sum > 5 * sol[i][j]) {
					tempOwn[i][j] = turn;
					for(int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(ny >= N || nx >= N || ny < 0 || nx < 0 || own[ny][nx] != turn) continue;
						tempSol[ny][nx] += sol[ny][nx] / 4;
						tempSol[i][j] += sol[ny][nx] / 4;
					}
				}else {
					tempOwn[i][j] = own[i][j];
				}
			
			}
		}
		own = tempOwn;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++ ) {
				if(own[i][j] == 0) continue;
				sol[i][j] = Math.abs(sol[i][j] - tempSol[i][j]);
			}
		}
	}
	private static void help(int turn) {
		int[][] tempSol = new int[N][N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(own[i][j] == 0 || own[i][j] != turn) continue;
				int count = 0;
				for(int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(ny >= N || nx >= N || ny < 0 || nx < 0 || own[ny][nx] == 0) continue;
					if(own[i][j] != own[ny][nx]) count++;
//					if(own[i][j] == own[ny][nx]) {
//						if(sol[i][j] > 5 * sol[ny][nx]) {
//							tempSol[ny][nx] += sol[i][j] / 5; 
//							tempSol[i][j] -= sol[i][j] / 5;
//						}
//					}else {
//						count++;
//					}
					
				}
				if(count == 0) {
					for(int d = 0; d < 4; d++) {
						if(sol[i][j] == 0 ) continue;
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(ny >= N || nx >= N || ny < 0 || nx < 0 || own[ny][nx] == 0) continue;
						tempSol[ny][nx] += sol[i][j] / 5;
						tempSol[i][j] -= sol[i][j] / 5;
					}
				}else {
					for(int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(ny >= N || nx >= N || ny < 0 || nx < 0 || own[ny][nx] == 0) continue;
						if(own[i][j] != own[ny][nx]) count++;
						if(own[i][j] == own[ny][nx]) {
							if(sol[i][j] > 5 * sol[ny][nx]) {
								tempSol[ny][nx] += sol[i][j] / 5; 
								tempSol[i][j] -= sol[i][j] / 5;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] += tempSol[i][j];
			}
		}
		
	}
	private static void supplement() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sol[i][j] += sup[i][j];
			}
		}
	}
	
	private static void checkEndCon() {
		int count = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++) {
				if(own[i][j] == 0 || !turns[own[i][j]]) continue;
				turns[own[i][j]] = false;
				count++;
				if(count == 3) break;
			}
			if(count == 3) break;

		}
	}
	
	private static boolean checkEnd() {
		int count = 0;
		for(int i = 1; i <= 3; i++) {
			if(!turns[i]) count++;
			if(count == 2) return false;
		}
		
		return true;
	}

}

/*
 * 
1
3
1 2 0
1 2 2
2 2 3
50 100 0
800 110 500
150 200 150
15 300 0
10 200 1500
25 500 100

*/

/*
 * 
 * 
#1 9760
#2 72095
#3 118750
#4 98645
#5 160635
#6 1202920
#7 279310
#8 3120311
#9 38565366
#10 15490100

*/
