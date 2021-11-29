package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구술탈출2 {
	static int N, M, cnt;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static int[][][][][] best;
	static class Node {
		int y;
		int x;
		char[][] map;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static Node O;
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		Node B = null;
		Node R = null;
		q = new LinkedList<>();
		best = new int[N][M][N][M][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int ii = 0; ii < N; ii++) {
					for (int jj = 0; jj < M; jj++) {
						for (int d = 0; d < 4; d++) {
							best[i][j][ii][jj][d] = Integer.MAX_VALUE;
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'B') {
					B = new Node(i, j);
				} else if (arr[i][j] == 'R') {
					R = new Node(i, j);
				} else if (arr[i][j] == 'O') {
					O = new Node(i, j);
				}
			}
		}
		char[][] map = copy(arr);
		B.map = map;
		map = copy(arr);
		R.map = map;
		q.offer(B);
		q.offer(R);
		bfs();
	}

	private static void bfs() {
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s += 2) {
				Node B = q.poll();
				Node R = q.poll();
				for (int i = 0; i < 4; i++) {
					
					Node nB = null;
					Node nR = null;
					char[][] temp = copy(B.map);
					if (i == 0) {
						if (B.y > R.y) {
							nR = move(R.y, R.x, i, temp);
							nB = move(B.y, B.x, i, temp);
						} else {
							nB = move(B.y, B.x, i, temp);
							nR = move(R.y, R.x, i, temp);
						}
					} else if (i == 1) {
						if (B.x > R.x) {
							nB = move(B.y, B.x, i, temp);
							nR = move(R.y, R.x, i, temp);
						} else {
							nR = move(R.y, R.x, i, temp);
							nB = move(B.y, B.x, i, temp);
						}
					} else if (i == 2) {
						if (B.y > R.y) {
							nB = move(B.y, B.x, i, temp);
							nR = move(R.y, R.x, i, temp);
						} else {
							nR = move(R.y, R.x, i, temp);
							nB = move(B.y, B.x, i, temp);
						}
					} else if (i == 3) {
						if (B.x > R.x) {
							nR = move(R.y, R.x, i, temp);
							nB = move(B.y, B.x, i, temp);
						} else {
							nB = move(B.y, B.x, i, temp);
							nR = move(R.y, R.x, i, temp);
						}
					}
					
					
					if (nB == null || nR == null) {
						if (nB == null) continue;
						if (nR == null) {
							System.out.println(cnt);
							return;
						}
					}
					if (best[nB.y][nB.x][nR.y][nR.x][i] <= cnt) {
						continue;
					}
					best[nB.y][nB.x][nR.y][nR.x][i] = cnt;
					char[][] map = copy(temp);
					nB.map = map;
					map = copy(temp);
					nR.map = map;
					q.offer(nB);
					q.offer(nR);
				}
			}
			if (cnt == 10) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(-1);
	}

	private static Node move(int y, int x, int dir, char[][] map) {
		char start = map[y][x];
		map[y][x] = '.';
		Node node = null;
		while (true) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (map[ny][nx] == '#' || map[ny][nx] == 'B' || map[ny][nx] == 'R') {
				node = new Node(y, x);
				map[y][x] = start;
				return node;
			}
			if (map[ny][nx] == 'O') {
				return node;
			}
			y = ny;
			x = nx;
		}
	}

	private static char[][] copy(char[][] map) {
		char[][] temp = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}
