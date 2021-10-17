package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	static int T, N, X, result;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			for (int i = 0; i < N; i++) {
				if (solveRow(i, 0)) result++;
			}
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				if (solveCol(i, 0)) result++;
			}
			System.out.println("#" + t + " " + result);
		}
	}
	private static boolean solveCol(int lev, int cur) {
		if (cur >= N - 1) return true;
		if (arr[cur][lev] == arr[cur + 1][lev]) {
			if(solveCol(lev, cur + 1)) return true;
		} else if (arr[cur][lev] == arr[cur + 1][lev] + 1) {
			int cnt = 0;
			while (true) {
				if (cnt == X) {
					if(solveCol(lev, cur + X)) return true;
					break;
				}
				if (cur + 1 + cnt >= N) break;
				if (arr[cur + 1][lev] == arr[cur + 1 + cnt][lev] && !visited[cur + 1 + cnt][lev]) {
					visited[cur + 1 + cnt][lev] = true;
				} else break;
				cnt++;
			}
		} else if (arr[cur][lev] + 1 == arr[cur + 1][lev]) {
			int cnt = 0;
			while (true) {
				if (cnt == X) {
					if(solveCol(lev, cur + 1)) return true;
					break;
				}
				if (cur - cnt < 0) break;
				if (arr[cur][lev] == arr[cur - cnt][lev] && !visited[cur - cnt][lev]) {
					visited[cur - cnt][lev] = true;
				} else break;
				cnt++;
			}
		}
		
		return false;
	}
	private static boolean solveRow(int lev, int cur) {
		if (cur >= N - 1) return true;
		if (arr[lev][cur] == arr[lev][cur + 1]) {
			if(solveRow(lev, cur + 1)) return true;
		} else if (arr[lev][cur] == arr[lev][cur + 1] + 1) {
			int cnt = 0;
			while (true) {
				if (cnt == X) {
					if(solveRow(lev, cur + X)) return true;
					break;
				}
				if (cur + 1 + cnt >= N) break;
				if (arr[lev][cur + 1] == arr[lev][cur + 1 + cnt] && !visited[lev][cur + 1 + cnt]) {
					visited[lev][cur + 1 + cnt] = true;
				} else break;
				cnt++;
			}
		} else if (arr[lev][cur] + 1 == arr[lev][cur + 1]) {
			int cnt = 0;
			while (true) {
				if (cnt == X) {
					if(solveRow(lev, cur + 1)) return true;
					break;
				}
				if (cur - cnt < 0) break;
				if (arr[lev][cur] == arr[lev][cur - cnt] && !visited[lev][cur - cnt]) {
					visited[lev][cur - cnt] = true;
				} else break;
				cnt++;
			}
		}
		return false;
		
	}

}


/*

1
6 2
3 3 3 2 1 1
3 3 3 2 2 1
3 3 3 3 3 2
2 2 3 2 2 2
2 2 3 2 2 2
2 2 2 2 2 2

 * */
