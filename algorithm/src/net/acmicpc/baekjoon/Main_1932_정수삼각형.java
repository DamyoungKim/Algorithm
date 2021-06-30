package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n + 1][];
		int[][] dp = new int[n + 1][];
		for(int i = 1; i < n + 1; i++) {
			arr[i] = new int[i];
			dp[i] = new int[i];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][0] = arr[1][0];
		int result = 0;
		for(int i = 2; i < n + 1; i++) {
			for(int j = 0; j < i; j++) {
				if(j == 0 ) {
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				}else if(j == i - 1) {
					dp[i][j] = dp[i - 1][j - 1] + arr[i][j]; 
				}else {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		
//		Arrays.sort(dp[n]);
		
		System.out.println(result);
		
		
	}
}

