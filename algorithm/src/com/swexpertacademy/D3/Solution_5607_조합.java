package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_5607_조합 {
	static long[] factorial;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int p = 1234567891;
		factorial = new long[1000001];
		factorial[0] = 1;
		for(int i = 1; i <= 1000000; i++) {
			factorial[i] = factorial[i - 1] * i % p;
		}
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			System.out.println("#" + t + " " + nCr(N, R, p));
		}
		
		
		
	}
	
	static long nCr (int n, int r, int p) {
		if(r== 0) {
			return 1;
		}
		
		return (factorial[n] * power(factorial[r], p - 2, p) % p * power(factorial[n - r], p - 2, p) % p ) % p;
	}

	private static long power(long x, int y, int p) {
		long res = 1;
		
		x = x % p;
		
		while( y > 0) {
			if( y % 2 == 1) {
				res = (res * x) % p;
			}
			
			y = y >> 1;
			x = (x * x) % p;
		
		}
		
		return res;
	}
}
