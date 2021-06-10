package com.swexpertacademy.professional;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_5604_구간합 {
	static long A, B;
	static long[] arr;
	static Map<Long, Long> memo = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(Long i = 0L; i < 10; i++) {
			memo.put(i, i * (i + 1) / 2);
		}
		for(int t = 1; t <= T; t++) {
			A = sc.nextLong();
			B = sc.nextLong();
			long ansA = F(A - 1);
			long ansB = F(B);
			System.out.println("#" + t + " " + (ansB - ansA));
		}
	}
	private static long F(long N) {
		String sN = Long.toString(N);
		long v = (long) Math.pow(10, sN.length() - 1);
		if(N == -1) return 0;
		if(memo.get(N) != null) return memo.get(N);
		long temp = F(N - 1 - N % v) + G(N);
		memo.put(N, temp);
		return  memo.get(N);
	}
	private static long G(long N) {
		String sN = Long.toString(N);
		long v = (long) Math.pow(10, sN.length() - 1);
		return N / v * (N % v + 1) + F(N % v);
	}

}
