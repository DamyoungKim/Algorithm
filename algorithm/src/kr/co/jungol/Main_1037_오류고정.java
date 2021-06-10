package kr.co.jungol;

import java.util.Scanner;

public class Main_1037_오류고정 {
	static int[][] arr;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int rowSum = 0;
		int colSum = 0;
		int rowC = 0;
		int colC = 0;
		int checkRC = 0;
		int checkCC = 0;
		int resultI = 0;
		int resultJ = 0;
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (j = 0; j < N; j++) {
				rowSum += arr[i][j];
			}
			if (rowSum % 2 != 0) {
				checkRC++;
				resultI = i;
				rowC++;
			}
			rowSum = 0;
		}

		for (int i = 0; i < N; i++) {
			int j = 0;
			for (j = 0; j < N; j++) {
				colSum += arr[j][i];
			}
			if (colSum % 2 != 0) {
				checkCC++;
				resultJ = i;
				colC++;
			}
			colSum = 0;
		}

		if (checkCC == 0 && checkRC == 0) {
			System.out.println("OK");
			return;
		}
		if (checkCC == 1 && checkRC == 1) {
			System.out.println("Change bit (" + (resultI + 1) + "," + (resultJ + 1) + ")");
			return;
		}
		System.out.println("Corrupt");
	}

}
