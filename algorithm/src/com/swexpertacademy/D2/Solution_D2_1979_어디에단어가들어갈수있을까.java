package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			int K = sc.nextInt();

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int check = 0;
					while (j < N && arr[i][j] != 0) {
						check++;
						j++;
					}
					if (check == K) {
						result++;
					}
				}
				for (int j = 0; j < N; j++) {
					int check = 0;
					while (j < N && arr[j][i] != 0) {
						check++;
						j++;
					}
					if (check == K) {
						result++;
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

}
