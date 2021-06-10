package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Cheeze {
	int y;
	int x;
	int time;

	public Cheeze(int y, int x, int time) {
		super();
		this.y = y;
		this.x = x;
		this.time = time;
	}

}

public class Main_2636_치즈 {
	static int N, M, time, cheezeCnt;
	static int[][] arr;

	static Queue<int[]> q;
	static List<Cheeze> cheezes = new ArrayList<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = sc.nextInt();
				arr[i][j] = temp;
				if (temp == 1)
					cheezes.add(new Cheeze(i, j, 0));
			}
		}
		solve();
		System.out.println(time);
		System.out.println(cheezeCnt);
	}

	private static void solve() {

		List<Cheeze> meltedCheezes = new ArrayList<>();
		
		while (cheezes.size() != 0) {
			meltedCheezes.clear();
			cheezeCnt = cheezes.size();
			time++;
			for (int i = 0; i < cheezes.size(); i++) {
				Cheeze cheeze = cheezes.get(i);
				int y = cheeze.y;
				int x = cheeze.x;
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if (ny >= N || nx >= M || ny < 0 || nx < 0)
						continue;

					if (arr[ny][nx] == 0) {
						q = new LinkedList<int[]>();
						q.offer(new int[] { y, x });
						if (bfs()) { // 구멍이다
							break;
						} else { // 구멍이 아니다
							meltedCheezes.add(cheeze);
							cheezes.remove(i);
							i--;
							break;
						}
					}
				}

			}

			for (int i = 0; i < meltedCheezes.size(); i++) {
				int y = meltedCheezes.get(i).y;
				int x = meltedCheezes.get(i).x;
				arr[y][x] = 0;
			}

		}

	}

	public static boolean bfs() {
		boolean[][] visited = new boolean[N][M];
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny == N - 1 || nx == M - 1 || ny == 0 || nx == 0)
					return false;

				if (arr[ny][nx] == 1 || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				q.offer(new int[] { ny, nx });
			}
		}

		return true;
	}
}

