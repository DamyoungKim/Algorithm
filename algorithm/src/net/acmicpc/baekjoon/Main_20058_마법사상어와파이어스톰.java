package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰 {
	static int N, Q, powN, maxCnt, count;
	static int[][] arr, copyArr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		powN = (int) Math.pow(2, N);
		arr = new int[powN][powN];
		copyArr = new int[powN][powN];
		for (int i = 0; i < powN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < powN; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copyArr[i][j] = arr[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) {
			int q = Integer.parseInt(st.nextToken());
			int interval = (int) Math.pow(2, q);
			fireStrom(interval, 0, 0);
			copy();
		}
		
		int iceCnt = 0;
		for (int i = 0; i < powN; i++) {
			for (int j = 0; j < powN; j++) {
				iceCnt += arr[i][j];
			}
		}
		visited = new boolean[powN][powN];
		for (int i = 0; i < powN; i++) {
			for (int j = 0; j < powN; j++) {
				if(visited[i][j] || arr[i][j] == 0) continue;
				count = 0;
				dfs(i, j);
				maxCnt = maxCnt > count ? maxCnt : count;
			}
		}
		
		System.out.println(iceCnt + " " + maxCnt);
		
	}
	private static void copy() {
		for (int i = 0; i < powN; i++) {
			for (int j = 0; j < powN; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
	}
	private static void fireStrom(int interval, int y, int x) {
		if(x >= powN) {
			fireStrom(interval, y + interval, 0);
			return;
		}
		if(y >= powN) {
			checkIce();
			return;
		}
		int temp[][] = rotate(interval, y, x);
		for (int i = y; i < y + interval ; i++) {
			for (int j = x; j < x + interval; j++) {
				arr[i][j] = temp[i - y][j - x];
			}
		}
		fireStrom(interval, y, x + interval);
	}
	private static int[][] rotate(int interval, int y, int x) {
		int[][] temp = new int[interval][interval];
		for (int i = 0; i < interval ; i++) {
			for (int j = 0; j < interval; j++) {
				temp[j][interval - 1 - i] = copyArr[y + i][x + j];
			}
		}
		return temp;
	}
	private static void checkIce() {
		for (int i = 0; i < powN; i++) {
			for (int j = 0; j < powN; j++) {
				int cnt = 0;
				if(arr[i][j] == 0) continue;
				for(int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(ny >= powN || nx >= powN || ny < 0 || nx < 0 || arr[ny][nx] == 0) continue;
					cnt++;
				}
				if(cnt < 3) {
					q.offer(new int[] {i, j});
				}
			}
		}
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			arr[temp[0]][temp[1]]--;
		}
		
	}
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		count++;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= powN || nx >= powN || nx < 0 || ny < 0 || arr[ny][nx] == 0 || visited[ny][nx]) continue;
			dfs(ny, nx);
		}
	}


}