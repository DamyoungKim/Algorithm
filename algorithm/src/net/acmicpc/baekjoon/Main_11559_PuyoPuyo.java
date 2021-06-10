package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Puyo {
	int y;
	int x;
	char val;

	public Puyo(int y, int x, char val) {
		super();
		this.y = y;
		this.x = x;
		this.val = val;
	}
}
public class Main_11559_PuyoPuyo {
	static int H = 12, W = 6, count;
	static char[][] arr = new char[H][W];
	static List<int[]> boomList = new ArrayList<>();
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static List<Puyo> puyoList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < H; i++) {
			String s = sc.next();
			for (int j = 0; j < W; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] != '.') {
					puyoList.add(new Puyo(i, j, arr[i][j]));
				}
			}
		}
		int result = 0;
		while(true) {
			visited = new boolean[H][W];
			int oldCnt = puyoList.size();
			for (int i = 0; i < oldCnt; i++) {
				Puyo puyo = puyoList.get(i);
				int y = puyo.y;
				int x = puyo.x;
				char val = puyo.val;
				
				if(visited[y][x]) continue;
				dfs(y, x, val);
				int tempSize = boomList.size();
				if(tempSize >= 4) {
					for(int j = 0; j < tempSize; j++) {
						int[] tempArr = boomList.get(j);
						arr[tempArr[0]][tempArr[1]] = '.';
					}
				}
				boomList.clear();
			}
			
			drop();
			reset();
			
			int newCnt = puyoList.size();
			if(oldCnt == newCnt) {
				System.out.println(result);
				return;
			}
			result++;
		}
	}

	private static void dfs(int y, int x, char val) {
		visited[y][x] = true;
		boomList.add(new int[] {y, x});
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= H || nx >= W || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == '.') continue;
			
			if(arr[ny][nx] == val) {
				
				dfs(ny, nx, val);
			}
		}
	}
	
	private static void drop() {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				if(arr[j][i] == '.') continue;
				stack.add(arr[j][i]);
				arr[j][i] = '.';
			}
			
			for(int j = H - 1; j >= 0; j--) {
				if(stack.isEmpty()) break;
				arr[j][i] = stack.pop();
			}
		}
	}
	
	private static void reset() {
		puyoList.clear();
		
		for(int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(arr[i][j] == '.') continue;
				puyoList.add(new Puyo(i, j, arr[i][j]));
			}
		}
	}
}