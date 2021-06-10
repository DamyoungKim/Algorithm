package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int N, M, C, result, sum;
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
			profit = new int[N][N - M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			selectRow(0, 0);
			System.out.println("#" + t + " " + result);
		}
		
	}
	private static void selectRow(int cnt, int start) {
		
		if(cnt == 2) {
			sum = 0;
			for(int i = 0; i < 2; i++) {
				selectCol(rowArr[i]);
			}
			
			result = result > sum ? result : sum;
			return;
		}
		
		for (int i = start; i < N; i++) {
			rowArr[cnt] = i;
			selectRow(cnt + 1, i + 1);
		}
	}
	private static void selectCol(int row) {
		for(int i = 0; i <= N - M; i++) {
			for(int j = 0; j < M; j++) {
				colArr[j] = i + j;
			}
			
			honey(row, 0);
			
		}
	}
	
	private static void honey(int row, int cnt) {
		if(cnt == M) {
			int check = 0;
			for(int i = 0; i < M; i++) {
				if(selected[i]) {
					check += arr[row][colArr[i]];
					sum += (arr[row][colArr[i]]) * (arr[row][colArr[i]]);
				}
			}
			if(check > C) sum = 0;
			return;
		}
			selected[cnt] = true;
			honey(row, cnt + 1);
			selected[cnt] = false;
			honey(row, cnt + 1);
		
	}

}
