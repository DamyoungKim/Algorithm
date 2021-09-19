package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static class Node {
		int y;
		int x;
		int key;
		
		public Node(int y, int x, int key) {
			super();
			this.y = y;
			this.x = x;
			this.key = key;
		}
	}
	static int N, M, result = -1;
	static char[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static Queue<Node> q = new LinkedList<>();
	static boolean[][][] visited; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M][(int) Math.pow(2, 'f' - 'a' + 1)];
		

		for (int i = 0; i < N; i++) {
			String s =br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				arr[i][j] = c;
				if (c == '0') {
					q.offer(new Node(i, j, 0));
					visited[i][j][0] = true;
				}
			}
		}
		solve();
		System.out.println(result);
	}
	private static void solve() {
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				Node node = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					int key = node.key;
					if(ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx][key] || arr[ny][nx] == '#') continue;
					
					if(arr[ny][nx] == '1') {
						result = cnt;
						return;
					}
					
					if('A' <= arr[ny][nx] && arr[ny][nx] <= 'F') {
						if ((key & 1 << (arr[ny][nx] - 'A')) !=  0) {
							visited[ny][nx][key] = true;
							q.offer(new Node(ny, nx, key));
						}
					} else if ('a' <= arr[ny][nx] && arr[ny][nx] <= 'f') {
						key = key | 1 << (arr[ny][nx] - 'a');
						visited[ny][nx][key] = true;
						q.offer(new Node(ny, nx, key));
					} else {
						visited[ny][nx][key] = true;
						q.offer(new Node(ny, nx, key));
					}
				}
			}
		}
	}
}
