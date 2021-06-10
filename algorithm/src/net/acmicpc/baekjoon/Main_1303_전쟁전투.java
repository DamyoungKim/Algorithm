package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1303_전쟁전투 {
	static char[][] arr;
	static int N, M;
	static boolean check[][];
	static int cnt;
	static int cntW;
	static int cntB;
	static int sumW, sumB;
	static boolean end;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 우리팀 W
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[M][N];
		check = new boolean[M][N];

		
		for(int i = 0; i < M; i++) {
			String s = sc.next();
			for(int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(check[i][j]) continue;
				check[i][j] = true;
				cntW = 1;
				cntB = 1;
				solve(i, j);
				if(arr[i][j] == 'W') sumW += Math.pow(cntW, 2);
				if(arr[i][j] == 'B') sumB += Math.pow(cntB, 2);
			}
		}
		System.out.print(sumW + " " + sumB);
		
	}
	
	public static void solve(int r, int c) {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
	
		for(int i = 0; i < 4; i++) {
			int nx = c + dx[i];
			int ny = r + dy[i];
			if(nx >= N || ny >= M || nx < 0 || ny < 0 || check[ny][nx]) continue;
			if(arr[ny][nx] == arr[r][c]) {
				check[ny][nx] = true;
				if(arr[r][c] == 'W') cntW++;
				if(arr[r][c] == 'B') cntB++;
				solve(ny, nx);
			}
		}
	}
}
