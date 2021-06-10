package com.swexpertacademy.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart {
	static int N, M, check;
	static int[] arr, result, temp = new int[2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
			result = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			c(0,0);
			check = 0;
			Arrays.sort(result);
			System.out.print("#" + t + " ");
			if (result[result.length - 1] == 0) {
				System.out.print(result[0]);
			} else {
				System.out.print(result[result.length - 1]);
			}
			System.out.println();
		}
	}

	private static void c(int cnt, int start) {
		
		if (cnt == 2) {
			check++;
			if (result.length == check) {
				result = Arrays.copyOf(result, check * 2);
			}
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				sum += temp[i];
			}
			if (sum > M)
				sum = -1;
			result[check] = sum;
			return;
		}

		for (int i = start; i < N; i++) {
			temp[cnt] = arr[i];
			c(cnt + 1, i + 1);
		}
	}
}
