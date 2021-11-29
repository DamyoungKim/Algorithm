package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, L;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		int cnt = 0;
		for (int j = 0; j < N; j++) {
			if (col(j, 0, arr[0][j])) cnt++;
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			if (row(i, 0, arr[i][0])) cnt++;
		}
		System.out.println(cnt);
	}
	private static boolean col(int x, int cnt, int cur) {
		if (cnt == N - 1) {
			return true;
		}
		if (cur == arr[cnt + 1][x]) {
			if (col(x, cnt + 1, arr[cnt + 1][x])) return true;
		} else if ((cur - arr[cnt + 1][x]) == 1) { // 다음이 더 작은 경우
			for (int i = cnt + 1; i <= cnt + L; i++) {
				if (i >= N || arr[i][x] != arr[cnt + 1][x]) return false;
			}
			for (int i = cnt + 1; i <= cnt + L; i++) {
				visited[i][x] = true;
			}
			if (col(x, cnt + L, arr[cnt + 1][x])) return true;
		} else if ((arr[cnt + 1][x] - cur) == 1) { // 다음이 더 큰 경우
			for (int i = cnt; i > cnt - L; i--) {
				if (i < 0 || arr[i][x] != cur || visited[i][x]) return false;
			}
			for (int i = cnt; i > cnt - L; i--) {
				visited[i][x] = true;
			}
			if (col(x, cnt + 1, arr[cnt + 1][x])) return true;
		}
		
		return false;
	}
	private static boolean row(int y, int cnt, int cur) {
		if (cnt == N - 1) {
			return true;
		}
		if (cur == arr[y][cnt + 1]) {
			if (row(y, cnt + 1, arr[y][cnt + 1])) return true;
		} else if ((cur - arr[y][cnt + 1]) == 1) { // 다음이 더 작은 경우
			for (int i = cnt + 1; i <= cnt + L; i++) {
				if (i >= N || arr[y][i] != arr[y][cnt + 1]) return false;
			}
			for (int i = cnt + 1; i <= cnt + L; i++) {
				visited[y][i] = true;
			}
			if (row(y, cnt + L, arr[y][cnt + 1])) return true;
		} else if ((arr[y][cnt + 1] - cur) == 1) { // 다음이 더 큰 경우
			for (int i = cnt; i > cnt - L; i--) {
				if (i < 0 || arr[y][i] != cur || visited[y][i]) return false;
			}
			for (int i = cnt; i > cnt - L; i--) {
				visited[y][i] = true;
			}
			if (row(y, cnt + 1, arr[y][cnt + 1])) return true;
		}
		
		return false;
	}

}
