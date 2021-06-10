package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] arr = new int[N + 1][4];
		for(int i  = 1; i <= N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] results = new int[N + 1][4];
		
		for(int i  = 1; i <= N; i++ ) {
			results[i][1] = Math.min(results[i-1][2], results[i-1][3]) + arr[i][1];
			results[i][2] = Math.min(results[i-1][1], results[i-1][3]) + arr[i][2];
			results[i][3] = Math.min(results[i-1][2], results[i-1][1]) + arr[i][3];
		}
		
		System.out.println(Math.min(Math.min(results[N][1], results[N][2]), results[N][3]));
	}

}
