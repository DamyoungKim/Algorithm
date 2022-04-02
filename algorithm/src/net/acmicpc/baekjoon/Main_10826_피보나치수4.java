package net.acmicpc.baekjoon;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main_10826_피보나치수4 {
	static BigInteger[] dp = new BigInteger[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(dp, BigInteger.valueOf(-1));
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		int N = sc.nextInt();
		System.out.println(fibo(N));
	}

	private static BigInteger fibo(int N) {
		
		
		if (dp[N].compareTo(BigInteger.ZERO) > -1) {
			return dp[N];
		}
		return dp[N] = fibo(N - 2).add(fibo(N - 1));
	}
}
