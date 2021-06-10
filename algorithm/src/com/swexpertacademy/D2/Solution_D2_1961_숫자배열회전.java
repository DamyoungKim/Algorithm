package com.swexpertacademy.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1961_숫자배열회전 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = arr.length - 1; j >= 0; j--) {
					arr90[i][arr.length - 1 - j] = arr[j][i];
				}
			}
			for (int i = arr.length - 1; i >= 0; i--) {
				for (int j = arr.length - 1; j >= 0; j--) {
					arr180[arr.length - 1 - i][arr.length - 1 - j] = arr[i][j];
				}
			}
			for (int i = 0; i < arr270.length; i++) {
				for (int j = arr270.length - 1; j >= 0; j--) {
					arr270[arr.length - 1 - j][i] = arr[i][j];
				}
			}

			System.out.println("#" + t);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
	}
}
