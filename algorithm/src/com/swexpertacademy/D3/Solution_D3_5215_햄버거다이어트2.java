package com.swexpertacademy.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트2 {

	static boolean[] isSelected;
	static int N, L;
	static int[] T;
	static int[] K;
	static int result;
	static int check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			L = sc.nextInt(); 
			isSelected = new boolean[N];
			T = new int[N];
			K = new int[N];
		
			for (int i = 0; i < N; i++) {
				T[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
			p(0);
		
			System.out.println("#" + t + " " + result);
			result = 0;
		}
	}

	private static void p(int cnt) {
		
		if(cnt == N) {
			int kSum = 0;
			int tSum = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					kSum += K[i];
				}
			}
			if(kSum <= L) {
				
				for(int i = 0; i < N; i++) {
					if(isSelected[i]) {
					tSum += T[i];
					}
				}
				result = result > tSum ? result : tSum;
			}
		return;
		}
		
		isSelected[cnt] = true;
		p(cnt + 1);
		isSelected[cnt] = false;
		p(cnt + 1);
	}
}

/*

2
5 1000
100 200
300 500
250 300
500 1000
400 400
5 1000
100 200
300 500
250 300
500 1000
400 400


*/
