package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취3 {
	static int N, M, C;
	static int[][] arr, profit;
	static int[] rowArr;
	static int[] colArr;
	static boolean[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			colArr = new int[M];
			rowArr = new int[2];
			selected = new boolean[M];
			profit = new int[N][N - M + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				selectCol(i);
			}
			
			int[] resultArr = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					resultArr[i] = resultArr[i] > profit[i][j] ? resultArr[i] : profit[i][j];
				}
			}
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int temp = resultArr[i] + resultArr[j];
					max = max > temp ? max : temp;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N - M + 1; i++) {
					for (int j = i + M; j < N - M + 1; j++) {
						int temp = profit[k][i] + profit[k][j];
						max = max > temp ? max : temp;
						
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
		
	}
	private static void selectCol(int row) {
		for(int i = 0; i < N - M + 1; i++) {
			for(int j = 0; j < M; j++) {
				colArr[j] = i + j;
			}
			
			honey(row, i, 0);
			
		}
	}
	
	private static void honey(int row, int col, int cnt) {
		if(cnt == M) {
			int check = 0;
			int sum = 0;
			for(int i = 0; i < M; i++) {
				if(selected[i]) {
					check += arr[row][colArr[i]];
					sum += (arr[row][colArr[i]]) * (arr[row][colArr[i]]);
				}
			}
			if(check > C) return;
			profit[row][col] = profit[row][col] > sum ? profit[row][col] : sum;
			return;
		}
			selected[cnt] = true;
			honey(row, col, cnt + 1);
			selected[cnt] = false;
			honey(row, col, cnt + 1);
		
	}

}
