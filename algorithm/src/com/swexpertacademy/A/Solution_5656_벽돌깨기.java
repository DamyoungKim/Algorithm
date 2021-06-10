package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int N, W, H, result = Integer.MAX_VALUE;
	static int[][] arr, copyArr;
	static int[] startPoint, dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			copyArr = new int[H][W];
			startPoint = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			setStartPoint(0);// 중복 순열 
			System.out.println("#" + t + " " + result);
		}
	}
	private static void setStartPoint(int cnt) {
		if(cnt == N) {
			
			for(int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copyArr[i][j] = arr[i][j];
				}
			}
			
			
			for(int i = 0; i < N; i++) {
				int[] temp = searchTop(startPoint[i]);
				if(temp == null) continue;
				solve(temp);
				moveBlock2();
			}
			int count = 0;
			for(int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(copyArr[i][j] != 0) count++;
				}
			}
			
			result = result > count ? count : result;
			return;
		}
		for(int i = 0; i < W; i++) {
			startPoint[cnt] = i;
			setStartPoint(cnt + 1);
		}
	}
	
	private static int[] searchTop(int startPoint) {
		for(int i = 0; i < H; i++) {
			if(copyArr[i][startPoint] == 0) continue;
			return new int[] {i, startPoint, copyArr[i][startPoint]};
		}
		return null;
	}
	private static void solve(int[] setting) {
		int y = setting[0];
		int x = setting[1];
		int val = setting[2];
		copyArr[y][x] = 0;
		for(int i = 1; i < val; i++) {
			for(int j = 0; j < 4; j++) {
				int ny = y + dy[j] * i;
				int nx = x + dx[j] * i;
				
				if(ny >= H || nx >= W || ny < 0 || nx < 0 || copyArr[ny][nx] == 0) continue;
				
				solve(new int[] {ny, nx, copyArr[ny][nx]});
			}
		}
	}
	private static void moveBlock2() {
		Stack<Integer> stack = new Stack<>();
		
		for(int j = 0; j < W; j++) {
			for(int i = 0; i < H; i++) {
				if(copyArr[i][j] == 0) continue;
				stack.add(copyArr[i][j]);
				copyArr[i][j] = 0;
			}
			
			for(int i = H - 1; i >= 0; i--) {
				if(stack.isEmpty()) break;
				copyArr[i][j] = stack.pop();
			}
		}
	}
	
}


/*
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

*/ 
