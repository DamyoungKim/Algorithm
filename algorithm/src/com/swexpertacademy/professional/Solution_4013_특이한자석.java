package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int T, K;
	static int[][] arr, mode; // N극 0, S극 1
	static Queue<Node> q;
	static boolean[] visited;
	static class Node {
		int num;
		int dir;
		public Node(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			arr = new int[4][8];
			mode = new int[K][2];
			StringTokenizer st = null;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				mode[i][0]  = Integer.parseInt(st.nextToken()) - 1;
				mode[i][1]  = Integer.parseInt(st.nextToken());
			}
			q = new LinkedList<>();
			for (int i = 0; i < K; i++) {
				visited = new boolean[4];
				q.offer(new Node(mode[i][0], mode[i][1]));
				visited[mode[i][0]] = true;
				solve();
			}
			int result = 0;
			for (int i = 0; i < 4; i++) {
				result += arr[i][0] * Math.pow(2, i);
			}
			System.out.println("#" + t + " " + result);
		}
		
	}
	private static void solve() {
		
		while(!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = -1; i <= 1; i += 2) {
				int nextNum = cur.num + i;
				int nextDir = cur.dir * -1;
				if (nextNum < 0 || nextNum > 3 || visited[nextNum]) continue;
				
				if (i == -1) {
					if (arr[cur.num][6] != arr[nextNum][2]) {
						visited[nextNum] = true;
						q.offer(new Node(nextNum, nextDir));
					}
				} else if (i == 1) {
					if (arr[cur.num][2] != arr[nextNum][6]) {
						visited[nextNum] = true;
						q.offer(new Node(nextNum, nextDir));
					}
				}
			}
			rotate(cur);
		}
	}
	private static void rotate(Node node) {
		int num = node.num;
		int dir = node.dir;
		int temp = 0;
		if (dir == 1) {
			temp = arr[num][7];
			for (int i = 7; i >= 1; i--) {
				arr[num][i] = arr[num][i - 1];
			}
			arr[num][0] = temp;
		} else if (dir == -1) {
			temp = arr[num][0];
			for (int i = 1; i <= 7; i++) {
				arr[num][i - 1] = arr[num][i];
			}
			arr[num][7] = temp;
		}
	}


}
/*
10
2
0 0 1 0 0 1 0 0
1 0 0 1 1 1 0 1
0 0 1 0 1 1 0 0
0 0 1 0 1 1 0 1
1 1
3 -1
 
 */
