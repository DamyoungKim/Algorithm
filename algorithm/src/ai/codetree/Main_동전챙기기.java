package ai.codetree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_동전챙기기 {
	static int N, min;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0}, selected;
	static List<Node> list;
	static Node start, end;
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int num;
		public Node(int y, int x, int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}
		@Override
		public int compareTo(Node node) {
			return this.num - node.num;
		}
		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if (this.y == node.y && this.x == node.x) return true;
			return false;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'S') start = new Node(i, j, 0);
				if (arr[i][j] == 'E') end = new Node(i, j, 0);
				if ('1' <= arr[i][j] && arr[i][j] <= '9') list.add(new Node(i, j, arr[i][j] - '0'));
			}
		}
		
		Collections.sort(list);
		min = Integer.MAX_VALUE;
		selected = new int[3];
		combi(0, 0);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}
	private static void combi(int cnt, int start) {
		if (cnt == 3) {
			int len = bfs();
			min = Math.min(len, min);
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
	private static int bfs() {
		boolean[][] visited;
		int result = 0;
		Queue<Node> q = new LinkedList<>();
		for (int lev = 0; lev <= 3; lev++) {
			visited = new boolean[N][N];
			q.clear();
			if (lev == 0) {
				q.offer(start);
				visited[start.y][start.x] = true;

			}
			else {
				q.offer(list.get(selected[lev - 1]));
				visited[list.get(selected[lev - 1]).y][list.get(selected[lev - 1]).x] = true;
			}
			int len = 0;
			boolean isFinished = false;
			while(!q.isEmpty()) {
				if (result >= min) return Integer.MAX_VALUE;
				int size = q.size();
				for (int s = 0; s < size; s++) {
					Node cur = q.poll();
					if (lev != 3 && cur.equals(list.get(selected[lev]))) {
						result += len;
						isFinished = true;
						break;
					} else if (lev == 3 && cur.equals(end)) {
						result += len;
						return result;
					}
					
					for (int i = 0; i < 4; i++) {
						int ny = cur.y + dy[i];
						int nx = cur.x + dx[i];
						if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == '#') continue;
						if (lev != 3 && arr[ny][nx] == '#') continue;
						visited[ny][nx] = true;
						q.offer(new Node(ny, nx, 0));
					}
				}
				if (isFinished) break;
				len++;
			}
			if (!isFinished) return Integer.MAX_VALUE;
		}
		return Integer.MAX_VALUE;
	}

}
/*
4
..3.
2#.E
.1#.
5S.4

*/