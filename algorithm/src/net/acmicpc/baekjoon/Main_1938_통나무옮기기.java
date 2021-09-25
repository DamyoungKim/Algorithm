package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1938_통나무옮기기 {
	static int N, result;
	static char[][] arr;
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 }, dy = { -1, 0, 1, 0, -1, 1, -1, 1 };
	static class Node {
		int y;
		int x;
		int mode; // row(0) - or col(1) |

		public Node(int y, int x, int mode) {
			super();
			this.y = y;
			this.x = x;
			this.mode = mode;
		}
	}

	static boolean[][][] visited;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new char[N][];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr[i] = s.toCharArray();
		}
		visited = new boolean[N][N][2];
		int bx = 0, by = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'B') {
					bx += j;
					by += i;
				}
			}
		}

		bx /= 3;
		by /= 3;
		int startMode =  0;
		if (bx + 1 < N) {
			startMode =  arr[by][bx + 1] == 'B' ? 0: 1;
		} else if (by + 1 < N) {
			startMode =  arr[by + 1][bx] == 'B' ? 1: 0;
		}
		
		q.offer(new Node(by, bx, startMode));
		visited[by][bx][startMode] = true;
		if(!solve()) System.out.println(0);
	}

	private static boolean solve() {
		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();
			result++;
			for (int s = 0; s < size ; s++) {
				Node cur = q.poll();
				int y = cur.y;
				int x = cur.x;
				int mode = cur.mode;
				if (arr[cur.y][cur.x] == 'E') {
					boolean end = true;
					if (mode == 0) { // -
						for (int i = -1; i <= 1; i += 2) {
							if(arr[y][x + i] != 'E') {
								end = false;
								break;
							}
						}
					} else if (mode == 1) { // |
						for (int i = -1; i <= 1; i += 2) {
							if(arr[y + i][x] != 'E') {
								end = false;
								break;
							}
						}
					}
					if(end) {
						System.out.println(result - 1);
						return true;
					}
				}
				boolean isCan = true;
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					 isCan = true;
					if (mode == 0) { // -
						if(ny >= N || nx + 1 >= N || ny < 0 || nx - 1 < 0 || visited[ny][nx][mode]) continue;
						for (int j = -1; j <= 1; j++) {
							if(arr[ny][nx + j] == '1') {
								isCan = false;
								break;
							}
						}
					} else if (mode == 1) { // |
						if(ny + 1 >= N || nx >= N || ny - 1 < 0 || nx < 0 || visited[ny][nx][mode]) continue;
						for (int j = -1; j <= 1; j++) {
							if(arr[ny + j][nx] == '1') {
								isCan = false;
								break;
							}
						}
					}
					if(!isCan) continue;
					visited[ny][nx][mode] = true;
					q.offer(new Node(ny, nx, mode));
				}
				int newMode = (mode + 1) % 2;
				if (visited[y][x][newMode]) continue;
				
				isCan = true;
				for (int i = 0; i < 8; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == '1') {
						isCan = false;
						break;
					}
				}
				if(!isCan) continue;
				visited[y][x][newMode] = true;
				q.offer(new Node(y, x, newMode));
			}
		}
		return false;
		
	}

}
