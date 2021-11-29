package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static int N, M, min;
	static class Node {
		int no;
		int y;
		int x;
		public Node(int no, int y, int x) {
			super();
			this.no = no;
			this.y = y;
			this.x = x;
		}
	}
	static List<Node> list;
	static boolean[] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static int[][][] dirs = {{}, 
			{{0}, {1}, {2}, {3}}, 
			{{0, 2}, {1, 3}},
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
			{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
			{{0, 1, 2, 3}}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= arr[i][j] && arr[i][j] <= 5) {
					list.add(new Node(arr[i][j], i, j));
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (node.no == 5) {
				int[][] temp = setCCTV(node.no, node.y, node.x, arr, 0);
				arr = temp;
				list.remove(i--);
			}
		}
		min = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) min++;
			}
		}
		solve(0, arr);
		System.out.println(min);
	}
	private static void solve(int cnt, int[][] arr) {
		if (cnt == list.size()) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) sum++;
				}
			}
			min = Math.min(min, sum);
			return;
		}
		Node cur = list.get(cnt);
		for (int i = 0; i < dirs[cur.no].length; i++) {
			int[][] map = setCCTV(cur.no, cur.y, cur.x, arr, i);
			solve(cnt + 1, map);
		}
	}
	private static int[][] setCCTV (int no, int y, int x, int[][] arr, int dir) {
		int[][] map = copy(arr);
		for (int j = 0; j < dirs[no][dir].length; j++) {
			int ny = y;
			int nx = x;
			int d = dirs[no][dir][j];
			while (true) {
				ny += dy[d];
				nx += dx[d];
				if (ny >= N || nx >= M || ny < 0 || nx < 0 || map[ny][nx] == 6) break;
				if (1 <= map[ny][nx] && map[ny][nx] <= 5) continue;
				map[ny][nx] = '#';
			}
		}
		return map;
	}
	private static int[][] copy(int[][] arr) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
}
