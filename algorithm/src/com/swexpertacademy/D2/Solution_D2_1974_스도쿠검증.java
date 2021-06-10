package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1974_스도쿠검증 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[9][9];
		for (int t = 1; t <= T; t++) {
			boolean result = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 9; i++) {
				int[] check = new int[10];
				for (int j = 0; j < 9; j++) {
					check[arr[i][j]]++;
				}

				for (int j = 1; j < 10; j++) {
					if (check[j] != 1) {
						result = false;
						break;
					}
				}

				if (!result)
					break;
			}

			for (int i = 0; i < 9; i++) {
				int[] check = new int[10];
				for (int j = 0; j < 9; j++) {
					check[arr[j][i]]++;
				}

				for (int j = 1; j < 10; j++) {
					if (check[j] != 1) {
						result = false;
						break;
					}
				}

				if (!result)
					break;
			}

			for (int k = 0; k <= 6; k += 3) {
				int[] check = new int[10];
				for (int i = k; i < 3 + k; i++) {

					for (int j = k; j < 3 + k; j++) {
						check[arr[i][j]]++;
					}
				}
				for (int j = 1; j < 10; j++) {
					if (check[j] != 1) {
						result = false;
						break;
					}
				}
				if (!result)
					break;
			}
			System.out.print("#" + t + " ");
			if (result)
				System.out.print(1);
			else
				System.out.print(0);
			System.out.println();
		}
	}
}
