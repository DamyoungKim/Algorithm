package net.acmicpc.baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Blank {
	int y;
	int x;

	public Blank(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}

public class Main_14502_연구소 {
	static int N, M, result;
	static int[][] arr, tempArr;
	static boolean[][] visited;
	static List<Blank> blankList = new ArrayList<>();
	static int[] select = new int[3];
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					blankList.add(new Blank(i, j));
				}
			}
		}

		solve(0, 0);
		System.out.println(result);

	}

	private static void solve(int cnt, int start) {
		// TODO Auto-generated method stub
		if (cnt == 3) {
			tempArr = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tempArr[i][j] = arr[i][j];
					if (tempArr[i][j] == 2) {
						visited[i][j] = true;
						q.offer(new int[] { i, j });
					}
				}
			}
			for (int i = 0; i < 3; i++) {
				Blank blank = blankList.get(select[i]);
				tempArr[blank.y][blank.x] = 1;
			}

			bfs();
			int blankCnt = count();

			result = result > blankCnt ? result : blankCnt;
			return;
		}
		for (int i = start; i < blankList.size(); i++) {
			select[cnt] = i;
			solve(cnt + 1, i + 1);
		}
	}

	private static int count() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempArr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			int[] virus = q.poll();
			int y = virus[0];
			int x = virus[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny >= N || nx >= M || ny < 0 || nx < 0 || tempArr[ny][nx] == 1 || visited[ny][nx])
					continue;

				visited[ny][nx] = true;
				tempArr[ny][nx] = 2;
				q.offer(new int[] { ny, nx });

			}
		}
	}
}

