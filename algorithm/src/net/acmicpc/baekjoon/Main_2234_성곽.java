package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2234_성곽 {
	static int n, m, count, maxRoomSize, cntRoom, cntTwoRoom;
	static int[][] arr;
	static boolean[][] selected;
	static int[][] roomArr;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		selected = new boolean[m][n];
		roomArr = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> rooms = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count = 1;
				if (selected[i][j])
					continue;
				cntRoom++;
				dfs(i, j);
				rooms.add(count);
				maxRoomSize = maxRoomSize > count ? maxRoomSize : count;
			}
		}

		System.out.println(cntRoom);
		System.out.println(maxRoomSize);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (ny >= m || nx >= n || ny < 0 || nx < 0 || roomArr[i][j] == roomArr[ny][nx])
						continue;
					int temp = rooms.get(roomArr[i][j] - 1) + rooms.get(roomArr[ny][nx] - 1);
					cntTwoRoom = cntTwoRoom > temp ? cntTwoRoom : temp;
				}
			}
		}
		System.out.println(cntTwoRoom);
	}

	private static void dfs(int y, int x) {
		selected[y][x] = true;
		roomArr[y][x] = cntRoom;
		for (int i = 0; i < 4; i++) {
			if ((arr[y][x] >> i & 0x01) == 0) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (!selected[ny][nx]) {
					count++;
					dfs(ny, nx);
				}
			}
		}
	}
}