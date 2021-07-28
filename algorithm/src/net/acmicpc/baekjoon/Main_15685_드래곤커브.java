package net.acmicpc.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_15685_드래곤커브 {
	static int[][] arr;
	static boolean[][] map;
	static int[] dx = { 1, 0, -1, 0, -1, -1, 1, 1}, dy = { 0, -1, 0, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N][4];
		map = new boolean[402][402];
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < 4; i++) {
				arr[n][i] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			int d = arr[i][2];
			int g = arr[i][3];
			Stack<Integer> stack = new Stack<>();
			stack.add(d);
			map[y][x] = true;
			for (int j = 0; j < g; j++) {
				for (int t = 0, size = stack.size(); t < Math.pow(2, j); t++) {
					int temp = size - 1 - t;
					stack.add((stack.get(temp) + 1) % 4);
				}
			}
			for(int j = 0; j < stack.size(); j++) {
				int temp = stack.get(j);
				y += dy[temp];
				x += dx[temp];
				map[y][x] =true;
			}
		}
		int result = 0;
		for(int i = 0; i < 201; i++) {
			for(int j = 0; j < 201; j++) {
				if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) result++; 
			}
		}
		System.out.println(result);
//		for (int i = 0; i < N; i++) {
//			int x = arr[i][0];
//			int y = arr[i][1];
//			int d = arr[i][2];
//			int g = arr[i][3];
//			Stack<Integer> stack = new Stack<>();
//			stack.add(d);
//
//			for (int j = 1; j <= g; j++) {
//				for (int t = 0, size = stack.size(); t < Math.pow(2, j - 1); t++) {
//					int temp = size - 1 - t;
//					stack.add((stack.get(temp) + 1) % 4);
//				}
//			}
//			int lineX = 2 * x + 1;
//			int lineY = 2 * y + 1;
//			int temp = stack.get(0);
//			lineY += dy[temp];
//			lineX += dx[temp];
//			
//			for(int k = -1; k <= 1; k += 2) {
//				map[lineY + dy[temp] * k][lineX + dx[temp] * k] = true;
//			}
//			map[lineY][lineX] = true;
//			for (int j = 1; j < stack.size(); j++) {
//				temp = stack.get(j);
//				int val = stack.get(j) - stack.get(j - 1);
//				switch (temp) {
//				case 0:
//					if (val == -3) {
//						lineY += 1;
//						lineX += 1;
//					} else if (val == -1) {
//						lineY += -1;
//						lineX += 1;
//					}
//					break;
//				case 1:
//					if (val > 0) {
//						lineY += -1;
//						lineX += 1;
//					} else if (val < 0) {
//						lineY += -1;
//						lineX += -1;
//					}
//					break;
//				case 2:
//					if (val > 0) {
//						lineY += -1;
//						lineX += -1;
//					} else if (val < 0) {
//						lineY += 1;
//						lineX += -1;
//					}
//					break;
//
//				case 3:
//					if (val == 1) {
//						lineY += 1;
//						lineX += -1;
//					} else if (val == 3) {
//						lineY += 1;
//						lineX += 1;
//					}
//					break;
//				}
//				map[lineY][lineX] = true;
//				for(int k = -1; k <= 1; k += 2) {
//					map[lineY + dy[temp] * k][lineX + dx[temp] * k] = true;
//				}
//			}
//		}
//		int result = 0;
//		for (int i = 2; i < 402; i += 2) {
//			for (int j = 2; j < 402; j += 2) {
//				int cnt = 0;
//				for (int k = 4; k < 8; k++) {
//					int ny = i + dy[k];
//					int nx = j + dx[k];
//					if (!map[ny][nx])
//						break;
//					cnt++;
//				}
//				if (cnt == 4)
//					result++;
//			}
//		}
//		System.out.println(result);
	}
}
