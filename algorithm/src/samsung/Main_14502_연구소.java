package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, max;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static List<Node> wall;
	static List<Node> virus;
	static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		wall = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) wall.add(new Node(i, j));
				if (arr[i][j] == 2) virus.add(new Node(i, j));
			}
		}
		selected = new int[3];
		max = 0;
		combi(0, 0);
		System.out.println(max);
	}
	private static void combi(int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				Node node = wall.get(selected[i]);
				arr[node.y][node.x] = 1;
			}
			bfs();
			for (int i = 0; i < 3; i++) {
				Node node = wall.get(selected[i]);
				arr[node.y][node.x] = 0;
			}
			return;
		}
		for (int i = start; i < wall.size(); i++) {
			selected[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < virus.size(); i++) {
			Node node = virus.get(i);
			visited[node.y][node.x] = true;
			q.offer(node);
		}
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 1) continue;
				visited[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && arr[i][j] != 1) cnt++;
			}
		}
		max = Math.max(max, cnt);
	}
}
