package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int N, K, L;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
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

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
	static Node snail;
	static int[] times;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		arr = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			arr[y][x] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		times = new int[10001];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int mode = st.nextToken().equals("L") ? -1 : 1;
			times[time] = mode;
		}
		
		arr[0][0] = -1;
		snail = new Node(0, 0, 1);
		solve();
	}
	private static void solve() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0));
		int cnt = 0;
		while (true) {
			if (times[cnt] != 0) {
				snail.dir += times[cnt];
				if (snail.dir == -1) snail.dir = 3;
				snail.dir %= 4;
			}
			int ny = snail.y + dy[snail.dir];
			int nx = snail.x + dx[snail.dir];
			
			if (ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == -1) {
				System.out.println(cnt + 1);
				return;
			}
			
			if (arr[ny][nx] != 1) {
				Node tail = q.poll();
				arr[tail.y][tail.x] = 0;
			}
			q.offer(new Node(ny, nx));
			snail.y = ny;
			snail.x = nx;
			arr[ny][nx] = -1;
			cnt++;
		}
	}
	
}
