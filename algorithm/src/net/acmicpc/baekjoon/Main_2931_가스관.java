package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	static int N, M;
	static char[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean pipe[][] = { 
			{ true, false, true, false }, 
			{ false, true, false, true }, 
			{ true, true, true, true },
			{ false, true, true, false }, 
			{ true, true, false, false }, 
			{ true, false, false, true },
			{ false, false, true, true } };
	static boolean[][][] visited;
	static char[] result = new char[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M][4];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int mx = 0;
		int my = 0;
		boolean m = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'M') {
					mx = j;
					my = i;
					m = true;
					break;
				}
			}
			if (m)
				break;
		} 
		visited[my][mx][0] = true;
		visited[my][mx][1] = true;
		visited[my][mx][2] = true;
		visited[my][mx][3] = true;
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			int nextX = mx + dx[i];
			int nextY = my + dy[i];
			if (nextX >= M || nextY >= N || nextY < 0 || nextX < 0 || arr[nextY][nextX] == '.' || arr[nextY][nextX] == 'Z')
				continue;
			if(solve(nextY, nextX, i, 1)) check = true;
			break;
		}
		if (check) {
			
			System.out.println(result[0] + " " + result[1] + " " + result[2]);
		}
	}

	private static boolean solve(int y, int x, int dir, int cnt) {

		int in = (dir + 2) % 4;
		int cur = charToInt(arr[y][x]);
		visited[y][x][in] = true;
		for (int out = 0; out < 4; out++) {
			if (!pipe[cur][out] || in == out) continue;
			int ny = y + dy[out];
			int nx = x + dx[out];
			if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx][(out + 2) % 4]) continue;
			if (arr[ny][nx] == '.') {
				if (cnt == 1) {
					for (int i = 0; i < 7; i++) {
						if (pipe[i][(out + 2) % 4]) {
							if (!isPossible(ny, nx, (out + 2) % 4, i)) continue;
							arr[ny][nx] = intToChar(i);
							result[0] = (char) (ny + '1');
							result[1] = (char) (nx + '1');
							result[2] = intToChar(i);
							if(solve(ny, nx, out, 0)) return true;
							visited[ny][nx][(out + 2) % 4] = false;
							arr[ny][nx] = '.';
						}
					}
				}
			} else {
				int next = charToInt(arr[ny][nx]);
				if (next == 7) {
					if (cnt == 0) return true;
				} else if(pipe[next][(out + 2) % 4]) {
					if (solve(ny, nx, out, cnt)) return true;
					visited[ny][nx][(out + 2) % 4] = false;
				} 
			}		
		}
		return false;
	}

	private static int charToInt(char chr) {
		int temp = -1;
		switch (chr) {
			case '|': temp = 0; break;
			case '-': temp = 1; break;
			case '+': temp = 2; break;
			case '1': temp = 3; break;
			case '2': temp = 4; break;
			case '3': temp = 5; break;
			case '4': temp = 6; break;
			case 'Z': temp = 7; break;
		}

		return temp;
	}

	private static char intToChar(int i) {
		char temp = ' ';
		switch (i) {
			case 0: temp = '|'; break;
			case 1: temp = '-'; break;
			case 2: temp = '+'; break;
			case 3: temp = '1'; break;
			case 4: temp = '2'; break;
			case 5: temp = '3'; break;
			case 6: temp = '4'; break;
		}

		return temp;
	}
	
	private static boolean isPossible(int y, int x, int in, int cur) {
		for (int out = 0; out < 4; out++) {
			if (in == out) continue;
			int ny = y + dy[out];
			int nx = x + dx[out];
			if (ny >= N || nx >= M || ny < 0 || nx < 0) {
				if (pipe[cur][out]) return false;
				continue;
			}
			if (arr[ny][nx] == '.' && pipe[cur][out]) {
				return false;
			} else if (arr[ny][nx] == 'Z' || arr[ny][nx] == 'M') {
				if (pipe[cur][out]) return false;
			} else if (arr[ny][nx] != '.') {
				int next = charToInt(arr[ny][nx]);
				if (pipe[next][(out + 2 ) % 4] && !pipe[cur][out]) return false;
			}
		}
		return true;
	}
}
/*
 * 
6 10
Z.1----4..
|.|....|..
|.|14..M..
2-.++4....
..2323....
..........
 * */
