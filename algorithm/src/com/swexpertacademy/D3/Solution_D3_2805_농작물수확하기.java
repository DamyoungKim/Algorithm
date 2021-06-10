package com.swexpertacademy.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			int count = 0;
			boolean turn = false;
			for (int i = 0; i < arr.length; i++) {
				if(i > N/2) turn = true;
				if (!turn) {
					count++;
				}
				if (turn) { ;
					count--;
				}
				for (int j = N/2 + 1 - count; j < N - (N/2 + 1 - count) ; j++) {
					result += arr[i][j];
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
