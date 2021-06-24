package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N + 1][K + 1];
		int[] arr = new int[N];
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for(int i = 1; i <= N; i++) {
			int weight = list.get(i - 1)[0];
			int value = list.get(i - 1)[1];
			for(int j = 1; j <= K; j++) {
				if(weight > j) dp[i][j] = dp[i - 1][j];
				else dp[i][j] = Math.max(value + dp[i - 1][j - weight], dp[i - 1][j]);
			}
		}
		System.out.println(dp[N][K]);
	}
}
