package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크 {
	static int N, loop, result = Integer.MAX_VALUE;
	static int[] arr;
	static boolean[] selected;
	static int[][][] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		selected = new boolean[N];
		memo = new int[61][61][61];
	
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(N == 1) {
			solve(0, arr[0]);
		}else if (N == 2) {
			solve(0, arr[0], arr[1]);
		}else if (N == 3) {
			solve(0, arr[0], arr[1], arr[2]);
		}
		System.out.println(result);
	}
	private static void solve(int l, int i, int j, int k) {
		if(i < 0) i = 0;
		if(j < 0) j = 0;
		if(k < 0) k = 0;
		if(i <= 0 && j <= 0 && k <= 0) {
			result = result > l ? l : result;
			return;
		}
		if(memo[i][j][k] != 0 && memo[i][j][k] <= l) return;
		
		memo[i][j][k] = l;
		
		if(i > 0) solve(l + 1, i - 9, j - 3, k - 1);
		if(i > 0) solve(l + 1, i - 9, j - 1, k - 3);
		
		if(j > 0) solve(l + 1, i - 3, j - 9, k - 1);
		if(j > 0) solve(l + 1, i - 1, j - 9, k - 3);
		
		if(k > 0) solve(l + 1, i - 3, j - 1, k - 9);
		if(k > 0) solve(l + 1, i - 1, j - 3, k - 9);
	}
	
	private static void solve(int l, int i, int j) {
		if(i <= 0 && j <= 0) {
			result = result > l ? l : result;
			return;
		}
		
		if(result <= l) return;
		
		
		if(i > 0) solve(l + 1, i - 9, j - 3);
		if(j > 0) solve(l + 1, i - 3, j - 9);
	}
	
	private static void solve(int l, int i) {
		result = i % 9 == 0 ? i / 9 : i / 9 + 1; 

	}

}

