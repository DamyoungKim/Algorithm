package com.swexpertacademy.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_4012_요리사 {
	static int N, result;
	static int[][] arr;
	static boolean[] selected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			N = sc.nextInt();
			arr = new int[N][N];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			solve(0, 0);
			System.out.println("#" + t + " " + result);
		}
		
	}
	private static void solve(int cnt, int start) {
		if(cnt == N / 2) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				if(selected[i]) A.add(i);
				else B.add(i);
			}
			int sumA = 0, sumB = 0;
			for(int i = 0; i < N/2; i++) {
				for(int j = 0; j < N/2; j++) {
					sumA += (arr[A.get(i)][A.get(j)]);
					sumB += (arr[B.get(i)][B.get(j)]);
				}
			}
			int temp = Math.abs(sumA - sumB);
			result = result > temp ? temp : result;
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[i] = true;
			solve(cnt + 1, i + 1);
			selected[i] = false;
		}
	}
}
