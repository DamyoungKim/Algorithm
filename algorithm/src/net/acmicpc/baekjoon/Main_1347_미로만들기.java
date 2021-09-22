package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1347_미로만들기 {
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int N, widthMax, hightMax, widthMin = Integer.MAX_VALUE, hightMin = Integer.MAX_VALUE;
	static Queue<Node> q = new LinkedList<>();
	static char[] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		
	
		q.offer(new Node(0, 0));
		solve(0, 0, 2, 0);
		int width = widthMax - widthMin;
		int hight = hightMax - hightMin;
		char[][] result = new char[hight + 1][width + 1];
		while (!q.isEmpty()) {
			Node temp = q.poll();
			result[temp.y - hightMin][temp.x - widthMin] = '.';
		}
		for (int i = 0; i < hight + 1; i++) {
			for (int j = 0; j < width + 1; j++) {
				if(result[i][j] == '.') System.out.print('.');
				else System.out.print('#');
			}
			System.out.println();
		}
	}
	private static void solve(int y, int x, int dir, int cnt) {
		widthMin = Math.min(x, widthMin);
		hightMin = Math.min(y, hightMin);
		widthMax = Math.max(x, widthMax);
		hightMax = Math.max(y, hightMax);
		if(cnt == N) {
			return;
		}
		int nextDir = 0;
		int[] nextPos = {y, x};
		if (arr[cnt] == 'F') {
			nextDir = dir;
			nextPos[0] = y + dy[dir];
			nextPos[1] = x + dx[dir];
			q.offer(new Node(nextPos[0], nextPos[1]));
		} else if (arr[cnt] == 'R') {
			nextDir = (dir + 1) % 4;
		} else if (arr[cnt] == 'L') {
			nextDir = (dir - 1);
			if (nextDir < 0) {
				nextDir = 3;
			}
		}
		solve(nextPos[0], nextPos[1], nextDir, cnt + 1);
	}
}
