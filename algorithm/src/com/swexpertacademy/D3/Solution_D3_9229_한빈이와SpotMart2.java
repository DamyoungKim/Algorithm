package com.swexpertacademy.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart2 {
	static int N, M, check;
	static int[] arr, temp = new int[2];
	static int result = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
		
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			c(0, 0);
			
			System.out.print("#" + t + " " + result);
		
			System.out.println();
			result = -1;
		}
	}
	private static void c(int cnt, int start) {

		if (cnt == 2) {
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				sum += temp[i];
			}
			if (sum > M)
				sum = -1;
			result = result > sum ? result : sum;
			return;
		}
		for (int i = start; i < N; i++) {
			temp[cnt] = arr[i];
			c(cnt + 1, i + 1);
		}
	}
}
