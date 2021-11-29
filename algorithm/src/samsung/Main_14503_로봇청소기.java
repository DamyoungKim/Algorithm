package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int N, M, cnt;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean[][] visited;
	static class Node {
		int y;
		int x;
		int dir;
		public Node(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
	static Node robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		robot = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		solve();
	}
	private static void solve() {
		clear();
		while(true) {
			boolean check = search();
			if (!check) {
				if (!back()) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	private static boolean search() {
		int dir = robot.dir;
		for (int i = 0; i < 4; i++) {
			dir--;
			if (dir < 0) dir = 3;
			int ny = robot.y + dy[dir];
			int nx = robot.x + dx[dir];
			if (visited[ny][nx] || arr[ny][nx] == 1) continue;
			robot.dir = dir;
			robot.y = ny;
			robot.x = nx;
			clear();
			return true;
		}
		
		return false;
	}
	private static boolean back() {
		int dir = (robot.dir + 2) % 4;
		int ny = robot.y + dy[dir];
		int nx = robot.x + dx[dir];
		
		if (arr[ny][nx] == 1) {
			return false;
		} else {
			robot.y = ny;
			robot.x = nx;
		}
		return true;
	}
	private static void clear() {
		cnt++;
		visited[robot.y][robot.x] = true;
	}
}
