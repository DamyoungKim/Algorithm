package com.swexpertacademy.A;

import java.util.Scanner;

public class Solution_1952_수영장 {
	static int result;
	static int[] wons = new int[4];
	static int[] arr = new int[13];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			
			for(int i = 0; i < 4; i++) {
				wons[i] = sc.nextInt();
			}
			for(int i = 1; i <= 12; i++) {
				arr[i] = sc.nextInt();
			}
		
		int start = 1;
		
		result = Integer.MAX_VALUE;
		solve(start, 0);
		System.out.println("#" + t + " " + result);
		}
	}
	private static void solve(int start, int won) {
		if(start > 12) {
			if(won > wons[3]) {
				won = wons[3];
			}
			result = result > won ? won : result;
			return;
		}
		int next = 0;
		for(int i = start; i <= 12; i++) {
			if(i != 0) {
				next = i;
				break;
			}
		}
		
		int day = arr[next]*wons[0];
		solve(next + 1,won + day);
		
		
		int month = wons[1];
		solve(next + 1, won + month); // 월
		
		
		int month3 = wons[2];
		solve(next+ 3, won + month3);
		
	}
}
