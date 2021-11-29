package miracom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N, M;
	static char[][] map;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	static class Node {
		int bY;
		int bX;
		int rY;
		int rX;
	}

	static Node start = new Node();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'B') {
					start.bY = i;
					start.bX = j;
				}
				if (map[i][j] == 'R') {
					start.rY = i;
					start.rX = j;
				}
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][M][N][M];
		visited[start.bY][start.bX][start.rY][start.rX] = true;
		q.offer(start);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (cnt == 10)
				return -1;
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int[] rPos = null;
					int[] bPos = null;
					if (d == 0) {
						if (cur.bY > cur.rY) {
							rPos = findNextPos(cur.rY, cur.rX, d, cur.bY, cur.bX);
							if (rPos == null) {
								bPos = findNextPos(cur.bY, cur.bX, d, -1, -1);
							} else {
								bPos = findNextPos(cur.bY, cur.bX, d, rPos[0], rPos[1]);
							}
						} else {
							bPos = findNextPos(cur.bY, cur.bX, d, cur.rY, cur.rX);
							if (bPos == null) continue;
							rPos = findNextPos(cur.rY, cur.rX, d, bPos[0], bPos[1]);
						}
					} else if (d == 1) {
						if (cur.bX > cur.rX) {
							bPos = findNextPos(cur.bY, cur.bX, d, cur.rY, cur.rX);
							if (bPos == null) continue;
							rPos = findNextPos(cur.rY, cur.rX, d, bPos[0], bPos[1]);
						} else {
							rPos = findNextPos(cur.rY, cur.rX, d, cur.bY, cur.bX);
							if (rPos == null) {
								bPos = findNextPos(cur.bY, cur.bX, d, -1, -1);
							} else {
								bPos = findNextPos(cur.bY, cur.bX, d, rPos[0], rPos[1]);
							}
						}
					} else if (d == 2) {
						if (cur.bY > cur.rY) {
							bPos = findNextPos(cur.bY, cur.bX, d, cur.rY, cur.rX);
							if (bPos == null) continue;
							rPos = findNextPos(cur.rY, cur.rX, d, bPos[0], bPos[1]);
						} else {
							rPos = findNextPos(cur.rY, cur.rX, d, cur.bY, cur.bX);
							if (rPos == null) {
								bPos = findNextPos(cur.bY, cur.bX, d, -1, -1);
							} else {
								bPos = findNextPos(cur.bY, cur.bX, d, rPos[0], rPos[1]);
							}
						}
					} else if (d == 3) {
						if (cur.bX > cur.rX) {
							rPos = findNextPos(cur.rY, cur.rX, d, cur.bY, cur.bX);
							if (rPos == null) {
								bPos = findNextPos(cur.bY, cur.bX, d, -1, -1);
							} else {
								bPos = findNextPos(cur.bY, cur.bX, d, rPos[0], rPos[1]);
							}
						} else {
							bPos = findNextPos(cur.bY, cur.bX, d, cur.rY, cur.rX);
							if (bPos == null) continue;
							rPos = findNextPos(cur.rY, cur.rX, d, bPos[0], bPos[1]);
						}
					}
					if (bPos == null) continue;
					if (rPos == null) return cnt + 1;
					Node next = new Node();
					next.bY = bPos[0];
					next.bX = bPos[1];
					next.rY = rPos[0];
					next.rX = rPos[1];
					if (visited[next.bY][next.bX][next.rY][next.rX]) continue;
					q.offer(next);
					visited[next.bY][next.bX][next.rY][next.rX] = true;
				}
			}
			cnt++;
		}
		return -1;
	}

	private static int[] findNextPos(int y, int x, int dir, int otherY, int otherX) {

		int ny = y + dy[dir];
		int nx = x + dx[dir];
		while (true) {
			if (map[ny][nx] == '#')
				return new int[] { ny - dy[dir], nx - dx[dir] };
			if (map[ny][nx] == 'O')
				return null;
			if (ny == otherY && nx == otherX)
				return new int[] { ny - dy[dir], nx - dx[dir] };
			ny += dy[dir];
			nx += dx[dir];
		}
	}

}
