package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	static int N, M, H;
	static boolean[][] visited;

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static List<Node> list;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		visited = new boolean[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			visited[y][x] = true;
		}
		list = new ArrayList<>();
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (!visited[i][j]) {
					if (visited[i][j - 1] || visited[i][j + 1])
						continue;
					list.add(new Node(i, j));
				}
			}
		}
		if (solve()) {
			System.out.println(0);
			return;
		}
		int result = -1;
		for (int i = 1; i <= 3; i++) {
			selected = new int[i];
			if (combi(0, 0, i)) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

	private static boolean combi(int cnt, int start, int R) {
		if (cnt == R) {
			if (R != 1) {
				for (int i = 0; i < R; i++) {
					Node cur = list.get(selected[i]);
					for (int j = i + 1; j < R; j++) {
						Node next = list.get(selected[j]);
						if (cur.y != next.y) continue;
						if (Math.abs(cur.x - next.x) == 1)
							return false;
					}
				}
			}
			for (int i = 0; i < R; i++) {
				Node node = list.get(selected[i]);
				visited[node.y][node.x] = true;
			}
			if (solve()) return true;
			for (int i = 0; i < R; i++) {
				Node node = list.get(selected[i]);
				visited[node.y][node.x] = false;
			}
			return false;
		}
		
		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			if (combi(cnt + 1, i + 1, R))
				return true;
		}
		return false;
	}

	private static boolean solve() {
		for (int j = 1; j < N; j++) {
			int x = j;
			for (int i = 1; i <= H; i++) {
				if (visited[i][x - 1]) {
					x--;
				} else if (visited[i][x]) {
					x++;
				}
			}
			if (x != j) return false;
		}
		return true;
	}
}
