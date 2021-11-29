package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {
	static class Node {
		int y;
		int x;
		int no;
		int dir;
		boolean died;

		public Node(int y, int x, int no, int dir, boolean died) {
			super();
			this.y = y;
			this.x = x;
			this.no = no;
			this.dir = dir;
			this.died = died;
		}

	}

	static Node shark;
	static Node[][] arr;
	static List<Node> list;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 }, dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new Node[4][4];
		list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int no = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				if (i == 0 && j == 0) {
					shark = new Node(i, j, no, dir, false);
					continue;
				}
				list.add(new Node(i, j, no, dir, false));
			}
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.no - o2.no;
			}

		});
		max = 0;
		solve(shark.y, shark.x, shark.dir, shark.no, list);
		System.out.println(max);
	}

	private static void solve(int y, int x, int dir, int sum, List<Node> temp) {
		List<Node> list = copy(temp);
		move(list, y, x);
		for (int len = 1; len <= 3; len++) {
			int ny = y + dy[dir] * len;
			int nx = x + dx[dir] * len;
			if (ny >= 4 || nx >= 4 || ny < 0 || nx < 0) break;
			Node node = canEat(ny, nx, list);
			if(node == null) continue;
			node.died = true;
			solve(node.y, node.x, node.dir, sum + node.no, list);
			node.died = false;
		}
		max = Math.max(max, sum);
	}

	private static Node canEat(int ny, int nx, List<Node> list) {
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (node.y == ny && node.x == nx)
				return node;
		}
		return null;
	}

	public static void move(List<Node> list, int sharkY, int sharkX) {
		for (int i = 0; i < list.size(); i++) {
			Node cur = list.get(i);
			int y = cur.y;
			int x = cur.x;
			boolean check = false;
			for (int d = cur.dir; d < cur.dir + 8; d++) {
				int dir = d % 8;
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny >= 4 || nx >= 4 || ny < 0 || nx < 0)
					continue;
				if (ny == sharkY && nx == sharkX) continue;
				for (int j = 0; j < list.size(); j++) {
					if (i == j)
						continue;
					Node next = list.get(j);
					if (ny == next.y && nx == next.x) {
						next.y = y;
						next.x = x;
						cur.y = ny;
						cur.x = nx;
						cur.dir = dir;
						check = true;
						break;
					}
				}
				if(check) break;
				
				cur.y = ny;
				cur.x = nx;
				cur.dir = dir;
				break;
			}
		}
	}

	public static List<Node> copy(List<Node> list) {
		List<Node> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (node.died) continue;
			temp.add(new Node(node.y, node.x, node.no, node.dir, node.died));
		}
		return temp;
	}

}
