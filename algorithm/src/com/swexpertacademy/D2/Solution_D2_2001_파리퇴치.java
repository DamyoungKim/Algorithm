package com.swexpertacademy.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[] resultArr = new int[(N-1) * ((N-1))];
			int count = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					
					for (int ii = 0; ii < M; ii++) {
						for (int jj = 0; jj < M; jj++) {
							resultArr[count] += arr[i + ii][j + jj];
						}
					}
					count++;
				}
			}
			Arrays.sort(resultArr);
			System.out.println("#" + t + " " + resultArr[resultArr.length - 1]);
		}
	}
}
