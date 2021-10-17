package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int T, N, W, H, min;
	static int[][] arr, temp;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0}, selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			selected = new int[N];
			arr = new int[H][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(0);
			System.out.println("#" + t + " " + min);
		}
	}
	private static void solve(int cnt) {
		if (cnt == N) {
			temp = copyArr();
			for (int i = 0; i < N; i++) {
				findBlock(selected[i]);
				downBlock();
			}
			int tempCount = countBlock();
			int count = tempCount;
			min = Math.min(min, count);
			return;
		}
		
		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			solve(cnt + 1);
		}
	}
	private static void findBlock(int cnt) {
		for (int i = 0; i < H; i++) {
			if (temp[i][cnt] != 0) {
				breakBlock(i, cnt, temp[i][cnt]);
				return;
			}
		}
	}
	private static void breakBlock(int y, int x, int len) {
		temp[y][x] = 0;
		for (int d = 1; d < len; d++) {
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i] * d;
				int nx = x + dx[i] * d;
				if (ny >= H || ny < 0 || nx >= W || nx < 0 || temp[ny][nx] == 0) continue;
				breakBlock(ny, nx, temp[ny][nx]);
			}
		}
	}
	
	private static int[][] copyArr() {
		int[][] temp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	
	private static void downBlock() {
		Stack<Integer> stack = new Stack<>();
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (temp[i][j] == 0) continue;
				stack.add(temp[i][j]);
			}
			
			for (int i = H - 1; i >= 0; i--) {
				if (stack.isEmpty()) {
					temp[i][j] = 0;
				} else {
					temp[i][j] = stack.pop();
				}
			}
		}
	}
	
	private static int countBlock() {
		int count = 0;
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (temp[i][j] != 0) count++;
			}
		}
		return count;
	}
}

/*
* 
* 
1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1

1
2 9 10
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 0 0 1 0 0 0 0
1 1 0 1 1 1 0 1 0
1 1 0 1 1 1 0 1 0
1 1 1 1 1 1 1 1 0
1 1 3 1 6 1 1 1 1
1 1 1 1 1 1 1 1 1
 * */
