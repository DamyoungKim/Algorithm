package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1463_1로만들기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		if(N == 1) {
			System.out.println(0);
			return;
		}
		for(int i = 3; i < 1000001; i++) {
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
			
			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
			
			if(i == N) break;
		}
		
		System.out.println(dp[N]);
	}
}
