package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1018_체스판다시칠하기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] checkW = new int[8][8];
		int[][] checkB = new int[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					checkW[i][j] = 1;
					checkB[i][j] = -1;
				} else {
					checkW[i][j] = -1;
					checkB[i][j] = 1;
				}
			}
		}

		int[][] arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'W') {
					arr[i][j] = 1;
				} else {
					arr[i][j] = -1;
				}
			}
		}
		int countW = 0;
		int countB = 0;
		int subResult = 0;
		int result = 0;
		for (int r = 0; r <= M - 8; r++) {
			for (int c = 0; c <= N - 8; c++) {
				int resultW = 0;
				int resultB = 0;
				countW = 0;
				countB = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						resultW = checkW[i][j] * arr[i + r][j + c];
						resultB = checkB[i][j] * arr[i + r][j + c];
						if (resultW == -1)
							countW++;
						if (resultB == -1)
							countB++;
					}
				}
				subResult = countW > countB ? countB : countW;
				if (r == 0 && c == 0)
					result = subResult;
				result = Math.min(result, subResult);
			}
		}
		System.out.println(result);
	}
}