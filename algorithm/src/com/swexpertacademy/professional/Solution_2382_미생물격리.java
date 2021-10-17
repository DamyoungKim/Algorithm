package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {
	static int T, N, M, K;

	static class Node {
		int no;
		int y;
		int x;
		int n;
		int dir;

		public Node(int y, int x, int n, int dir, int no) {
			super();
			this.y = y;
			this.x = x;
			this.n = n;
			this.dir = dir;
			this.no = no;
		}

		public boolean move() {
			y += dy[dir];
			x += dx[dir];
			if (y == 0 || y == N - 1 || x == 0 || x == N - 1) {
				n /= 2;
				switch (dir) {
				case 0:
					dir = 1;
					break;
				case 1:
					dir = 0;
					break;
				case 2:
					dir = 3;
					break;
				case 3:
					dir = 2;
					break;
				}
				if (n == 0) {
					list.remove(this);
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if (this.no == node.no && this.no == node.no)
				return true;

			return false;
		}
	}

	static List<Node> list;
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				list.add(new Node(y, x, n, dir, i));
			}
			
			for (int i = 0; i < M; i++) {
				move();
				union();
			}
			int result = 0;
			for (int i = 0; i < list.size(); i++) {
				result += list.get(i).n;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void union() {
		boolean[] visited = new boolean[list.size()];
		ArrayList<Node>[] temp = new ArrayList[list.size()];
		for (int i = 0; i < list.size(); i++) {
			if (visited[i]) continue; 
			temp[i] = new ArrayList<>();
			Node cur = list.get(i);
			visited[i] = true;
			temp[i].add(cur);
			for (int j = i + 1; j < list.size(); j++) {
				Node next = list.get(j);
				if(cur.y == next.y && cur.x == next.x) {
					visited[j] = true;
					temp[i].add(next);
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == null || temp[i].size() < 2) continue;
			
			Node maxNode = temp[i].get(0);
			int maxN = maxNode.n;
			int dir = maxNode.dir;
			int sum = maxN;
			for (int j = 1; j < temp[i].size(); j++) {
				Node cur = temp[i].get(j);
				sum += cur.n;
				if (maxN < cur.n) {
					list.remove(maxNode);
					maxNode = cur;
					maxN = cur.n;
					dir = cur.dir;
				} else {
					list.remove(cur);
				}
			}
			maxNode.n = sum;
			maxNode.dir = dir;
		}
	}

	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).move()) i--;
		}
	}

}
/*
 * 
 * 
 * 
10
7 2 9
1 1 7 1
2 1 7 1
5 1 5 4
3 2 8 4
4 3 14 1
3 4 3 3
1 5 8 2
3 5 100 1
5 5 1 1

 * */
