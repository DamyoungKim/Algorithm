package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2251_물통 {
	static int[] arr = new int[3];
	static boolean[] selected = new boolean[201];
	static boolean[][][] visited = new boolean[201][201][201];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		
		solve(0, 0, arr[2]);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 201; i++) {
			if(selected[i]) sb.append(i + " ");
		}
		System.out.println(sb);
	}
	private static void solve(int a, int b, int c) {
		if(a < 0 || b < 0 || c < 0) return;
		if(visited[a][b][c]) return;
		if(a == 0) {
			selected[c] = true;
		}
		
		visited[a][b][c] = true;
		
		if(a > 0) {
			solve(a > (arr[1] - b) ? a - (arr[1] - b) : 0
					, a > (arr[1] - b) ? arr[1] : b + a
							, c);
			solve(a > (arr[2] - c) ? a - (arr[2] - c) : 0
					, b
					, a > (arr[2] - c) ? arr[2] : c + a);
		}
		
		if (b > 0) {
			solve(b > (arr[0] - a) ? arr[0] : a + b
					, b > (arr[0] - a) ? b - (arr[0] - a) : 0
							, c);
			solve(a
					,  b > (arr[2] - c) ? b - (arr[2] - c) : 0
							,  b > (arr[2] - c) ? arr[2] : c + b);
		}
		
		if (c > 0) {
			solve(c > (arr[0] - a) ? arr[0] : a + c
					, b
					, c > (arr[0] - a) ? c - (arr[0] - a) : 0);
			solve(a
					, c > (arr[1] - b) ? arr[1] : b + c
							, c > (arr[1] - b) ? c - (arr[1] - b) : 0);
		}
	}
}
