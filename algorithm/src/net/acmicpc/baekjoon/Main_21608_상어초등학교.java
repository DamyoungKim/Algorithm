package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_21608_상어초등학교 {
	static int N;
	static int[][] arr, resultArr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0}, order;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N * N + 1][4];
		order = new int[N * N];
		resultArr = new int[N][N];
		for(int i = 0; i < N * N; i++) {
			order[i] = sc.nextInt(); 
			for(int j = 0; j < 4; j++) {
				arr[order[i]][j] = sc.nextInt();
			}
		}
		
		
		for(int i = 0; i < N * N; i++) {
			solve(order[i]);
		}
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;				
				for(int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if(ny >= N || nx >= N || ny < 0 || nx < 0) continue;
					for(int z = 0; z < 4; z++) {
						if(resultArr[ny][nx] == arr[resultArr[i][j]][z]) {
							cnt++;
							break;
						}
					}
				}
				if (cnt == 1) result += 1;
				else if (cnt == 2) result += 10;
				else if (cnt ==3) result += 100;
				else if (cnt ==4) result += 1000;
			}
		}
		
		System.out.println(result);
		
	}
	private static void solve(int student) {
		int[][] score = new int[N][N];
		int max = 0;
		int y = -1;
		int x = -1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(resultArr[i][j] != 0) continue;
				int a = 0;
				int b = 0;
				for(int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if(ny >= N || nx >= N || ny < 0 || nx < 0) continue;
					
					for(int z = 0; z < 4; z++) {
						if(resultArr[ny][nx] == arr[student][z]) {
							a++;
							break;
						}
					}
					
					if(resultArr[ny][nx] == 0) b++;
				}
				score[i][j] = a * 10 + b;
				if(score[i][j] > max) {
					max = score[i][j];
					y = i;
					x = j;
				}
			}
		}
		if(y == -1 && x == -1) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(resultArr[i][j] == 0) {
						resultArr[i][j] = student;
						return;
					}
				}
			}
		}
		resultArr[y][x] = student;
	}	
}
