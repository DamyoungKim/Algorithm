package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_16926_배열돌리기1 {
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			rotation();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotation() {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int index = 0;
		int[][] temp = new int[N][M];
		for (int k = 0; k < (N >= M ? M / 2 : N / 2); k++) {
			int i = k, j = k;
			index = 0;
			while(index != 4) {
				int x = j + dx[index];
				int y = i + dy[index];
				if(y >= N - k || x >= M - k || y < k || x < k) {
					index++;
					continue;
				}
				temp[y][x] = arr[i][j];
				i = y;
				j = x;
				
			}
		}
		arr = temp;
	}
}