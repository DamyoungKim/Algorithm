package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	static int N, result;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		solve(0, arr);
		System.out.println(result);
	}

	private static void solve(int cnt, int[][] arr) {
		if (cnt == 5) {
			int max = findMax(arr);
			result = Math.max(result, max);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int[][] map = copy(arr);
			move(i, map);
			solve(cnt + 1, map);
		}
	}

	private static int findMax(int[][] map) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}

	private static void move(int dir, int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		if (dir == 0) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 0) continue;
					q.offer(map[i][j]);
				}
				
				for (int i = 0; i < N; i++) {
					if (q.isEmpty()) {
						map[i][j] = 0;
					} else {
						if (i == 0) {
							map[i][j] = q.poll();
							continue;
						}
						int temp = q.poll();
						if (map[i - 1][j] == temp && !visited[i - 1][j]) {
							visited[i - 1][j] = true;
							map[i - 1][j] = temp * 2;
							i--;
						} else {
							map[i][j] = temp;
						}
					}
				}
			}
		} else if (dir == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] == 0) continue;
					q.offer(map[i][j]);
				}
				for (int j = N - 1; j >= 0; j--) {
					if (q.isEmpty()) {
						map[i][j] = 0;
					} else {
						if (j == N - 1) {
							map[i][j] = q.poll();
							continue;
						}
						int temp = q.poll();
						if (map[i][j + 1] == temp && !visited[i][j + 1]) {
							visited[i][j + 1] = true;
							map[i][j + 1] = temp * 2;
							j++;
						} else {
							map[i][j] = temp;
						}
					}
				}
			}
		} else if (dir == 2) {
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] == 0) continue;
					q.offer(map[i][j]);
				}
				
				for (int i = N - 1; i >= 0; i--) {
					if (q.isEmpty()) {
						map[i][j] = 0;
					} else {
						if (i == N - 1) {
							map[i][j] = q.poll();
							continue;
						}
						int temp = q.poll();
						if (map[i + 1][j] == temp && !visited[i + 1][j]) {
							visited[i + 1][j] = true;
							map[i + 1][j] = temp * 2;
							i++;
						} else {
							map[i][j] = temp;
						}
					}
				}
			}
		} else if (dir == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) continue;
					q.offer(map[i][j]);
				}
				
				for (int j = 0; j < N; j++) {
					if (q.isEmpty()) {
						map[i][j] = 0;
					} else {
						if (j == 0) {
							map[i][j] = q.poll();
							continue;
						}
						int temp = q.poll();
						if (map[i][j - 1] == temp && !visited[i][j - 1]) {
							visited[i][j - 1] = true;
							map[i][j - 1] = temp * 2;
							j--;
						} else {
							map[i][j] = temp;
						}
					}
				}
			}
		}
	}

	private static int[][] copy(int[][] arr) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
}
