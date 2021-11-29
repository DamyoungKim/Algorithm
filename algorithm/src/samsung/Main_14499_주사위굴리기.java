package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, x, y, K, up;
	static int[][] arr;
	static int[] com, memo, dx = {0, 1, -1, 0, 0}, dy = {0, 0, 0, -1, 1};
	static StringBuffer sb;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		com = new int[K];
		memo = new int[7];
		up = 1;
		sb = new StringBuffer();
		q = new LinkedList<>();
		q.offer(new int[] {6, 3, 4, 2, 5});
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			com[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < K; i++) {
			solve(com[i]);
		}
		System.out.println(sb);
		
	}
	private static void solve(int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		int[] dice = q.poll();
		int bottom = dice[dir];
		if (ny >= N || nx >= M || ny < 0 || nx < 0) {
			q.offer(dice);
			return;
		}
		if (dir == 1) {
			q.offer(new int[] {dice[1], up, dice[0], dice[3], dice[4]});
			up = dice[2];
		} else if (dir == 2) {
			q.offer(new int[] {dice[2], dice[0], up, dice[3], dice[4]});
			up = dice[1];
		} else if (dir == 3) {
			q.offer(new int[] {dice[3], dice[1], dice[2], up, dice[0]});
			up = dice[4];
		} else if (dir == 4) {
			q.offer(new int[] {dice[4], dice[1], dice[2], dice[0], up});
			up = dice[3];
		}
		
		if (arr[ny][nx] != 0) {
			memo[bottom] = arr[ny][nx];
			arr[ny][nx] = 0;
		} else {
			arr[ny][nx] = memo[bottom];
		}
		y = ny;
		x = nx;
		sb.append(memo[up]);
		sb.append('\n');
	}
}
