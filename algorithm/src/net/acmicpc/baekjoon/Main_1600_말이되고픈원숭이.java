package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey {
	int y;
	int x;
	int cnt;
	int K;

	public Monkey(int y, int x, int cnt, int k) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		K = k;
	}

}
public class Main_1600_말이되고픈원숭이 {
	static int W, H;
	static int[][] arr;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 },
			{ 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static boolean[][][] visited;
	static boolean check;
	static Queue<Monkey> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visited = new boolean[H][W][K + 1];
		if (W == 1 && H == 1) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i <= K; i++) {
			visited[0][0][i] = true;
		}
		q.offer(new Monkey(0, 0, 0, K));
		System.out.println(bfs());
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			Monkey monkey = q.poll();
			int y = monkey.y;
			int x = monkey.x;
			int cnt = monkey.cnt;
			int K = monkey.K;
			int end = 12;
			if (K == 0) {
				end = 4;
			}
			for (int i = 0; i < end; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				if (ny >= H || nx >= W || ny < 0 || nx < 0 || arr[ny][nx] == 1)
					continue;
				if (ny == H - 1 && nx == W - 1) {
					return cnt + 1;
				}
				if (i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11) {
					if (!visited[ny][nx][K - 1]) {
						visited[ny][nx][K - 1] = true;
						q.offer((new Monkey(ny, nx, cnt + 1, K - 1)));
					}
				} else {
					if (!visited[ny][nx][K]) {
						visited[ny][nx][K] = true;
						q.offer((new Monkey(ny, nx, cnt + 1, K)));
					}
				}
			}
		}
		return -1;
	}

}
