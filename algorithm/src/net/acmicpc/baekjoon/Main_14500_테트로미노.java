package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				max = Math.max(max, arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 3; j++) {
				max = Math.max(max, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]);
			}
		}

		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N - 3; i++) {
				max = Math.max(max, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j]);
			}
		}
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				int[] tempArr = new int[8];
				int temp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				tempArr[0] = temp - (arr[i + 1][j + 1] + arr[i + 1][j + 2]);
				tempArr[1] = temp - (arr[i + 1][j] + arr[i + 1][j + 1]);
				tempArr[2] = temp - (arr[i + 1][j] + arr[i + 1][j + 2]);
				
				tempArr[3] = temp - (arr[i][j + 1] + arr[i][j + 2]);
				tempArr[4] = temp - (arr[i][j] + arr[i][j + 1]);
				tempArr[5] = temp - (arr[i][j] + arr[i][j + 2]);
				
				tempArr[6] = temp - (arr[i][j] + arr[i + 1][j + 2]);
				tempArr[7] = temp - (arr[i + 1][j] + arr[i][j + 2]);
				
				Arrays.sort(tempArr);
				max = Math.max(max, tempArr[7]);
			}
		}
		
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				int[] tempArr = new int[8];
				int temp = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1];
				tempArr[0] = temp - (arr[i + 1][j + 1] + arr[i + 2][j + 1]);
				tempArr[1] = temp - (arr[i][j + 1] + arr[i + 1][j + 1]);
				tempArr[2] = temp - (arr[i][j + 1] + arr[i + 2][j + 1]);
				
				tempArr[3] = temp - (arr[i + 1][j] + arr[i + 2][j]);
				tempArr[4] = temp - (arr[i][j] + arr[i + 2][j]);
				tempArr[5] = temp - (arr[i][j] + arr[i + 1][j]);
				
				tempArr[6] = temp - (arr[i][j + 1] + arr[i + 2][j]);
				tempArr[7] = temp - (arr[i][j] + arr[i + 2][j + 1]);
				
				Arrays.sort(tempArr);
				max = Math.max(max, tempArr[7]);
			}
		}
		
		System.out.println(max);
	}
	
}
