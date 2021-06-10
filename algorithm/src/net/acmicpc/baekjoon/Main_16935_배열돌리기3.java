package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_16935_배열돌리기3 {
	static int[][] arr;
	static int N, M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		int S = 0;
		arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			S = sc.nextInt();
			switch (S) {
			case 1:
				one();

				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void one() {
		int temp[][] = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				temp[i][j] = arr[arr.length - 1 - i][j];
			}
		}
		arr = temp;
	}

	private static void two() {
		int temp[][] = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				temp[i][j] = arr[i][arr[0].length - 1 - j];
			}
		}
		arr = temp;
	}

	private static void three() {
		int[][] temp = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i][j] = arr[arr.length - 1 - j][i];
			}
		}
		arr = temp;
	}

	private static void four() {
		int[][] temp = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i][j] = arr[j][arr[0].length - 1 - i];
			}
		}
		arr = temp;
	}

	private static void five() {
		int temp[][] = new int[arr.length][arr[0].length];
		int x_temp[] = { arr[0].length / 2, 0, -arr[0].length / 2, 0 };
		int y_temp[] = { 0, arr.length / 2, 0, -arr.length / 2 };
		int i_k[] = { 0, 0, arr.length / 2, arr.length / 2 };
		int j_k[] = { 0, arr[0].length / 2, arr[0].length / 2, 0 };
		for (int k = 0; k < 4; k++) {
			for (int i = i_k[k]; i < arr.length / 2 + i_k[k]; i++) {
				for (int j = j_k[k]; j < arr[0].length / 2 + j_k[k]; j++) {
					temp[i + y_temp[k]][j + x_temp[k]] = arr[i][j];
				}
			}
		}
		arr = temp;
	}

	private static void six() {
		int temp[][] = new int[arr.length][arr[0].length];
		int x_temp[] = { 0, arr[0].length / 2, 0, -arr[0].length / 2 };
		int y_temp[] = { arr.length / 2, 0, -arr.length / 2, 0 };
		int i_k[] = { 0, arr.length / 2, arr.length / 2, 0 };
		int j_k[] = { 0, 0, arr[0].length / 2, arr[0].length / 2 };
		for (int k = 0; k < 4; k++) {
			for (int i = i_k[k]; i < arr.length / 2 + i_k[k]; i++) {
				for (int j = j_k[k]; j < arr[0].length / 2 + j_k[k]; j++) {
					temp[i + y_temp[k]][j + x_temp[k]] = arr[i][j];
				}
			}
		}
		arr = temp;
	}
}
