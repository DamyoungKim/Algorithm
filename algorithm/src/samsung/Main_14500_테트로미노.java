package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int N, M, max;
	static int[][] arr, except;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false;
			}
		}
		except = new int[][] {
			{0, 1, 2, 1, 0, 0, 0, -1},
			{0, 1, 2, 1, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 1, 2, 1},
			{0, 0, 0, -1, 0, 1, 2, 1},
			{0, -1, -2, -1, 0, 0, 0, 1},
			{0, -1, -2, -1, 0, 0, 0, -1},
			{0, 0, 0, 1, 0, -1, -2, -1},
			{0, 0, 0, -1, 0, -1, -2, -1},
		};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 8; k++) {
					boolean check = true;
					int sum = 0;
					for (int d = 0; d < 4; d++) {
						int ny = i + except[k][d + 4];
						int nx = j + except[k][d];
						if (ny >= N || nx >= M || ny < 0 || nx < 0) {
							check = false;
							break;
						}
						sum += arr[ny][nx];
					}
					if(check) {
						max = Math.max(sum, max);
					}
				}
			}
		}
		System.out.println(max);
	}
	private static void dfs(int y, int x, int cnt, int sum) {
		visited[y][x] = true;
		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx]) continue;
			dfs(ny, nx, cnt + 1, sum + arr[ny][nx]);
			visited[ny][nx] = false;
		}
	}
}
