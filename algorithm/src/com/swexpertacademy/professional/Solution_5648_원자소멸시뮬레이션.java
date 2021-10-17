package com.swexpertacademy.professional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_5648_원자소멸시뮬레이션 {
	static int T, N;

	static class Node {
		int no;
		int y;
		int x;
		int dir;
		int energy;

		public Node(int no, int y, int x, int dir, int energy) {
			super();
			this.no = no;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.energy = energy;
		}
		
		public boolean move() {
			y += dy[dir];
			x += dx[dir];
			if (y > 2000 || x > 2000 || y < -2000 || x < -2000) {
				list.remove(this);
				return true;
			}
			return false;
		}
		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if (this.y == node.y && this.x == node.x) {
				return true;
			}
			return false;
		}
	}
	static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
	static List<Node> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				int energy = sc.nextInt();
				list.add(new Node(i, y * 2, x * 2, dir, energy));
			}
			int result = 0;
			while(list.size() != 0) {
				move();
				result += collision();
			}
			System.out.println("#" + t + " " + result);
		}
	}
	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (node.move()) {
				i--;
			}
		}
	}
	
	private static int collision () {
		int sum = 0;
		boolean[] visited = new boolean[1001];
		for (int i = 0; i < list.size(); i++) {
			Node cur = list.get(i);
			if (visited[cur.no]) continue;
			for (int j = i + 1; j < list.size(); j++) {
				Node next = list.get(j);
				if (cur.equals(next)) {
					if (!visited[cur.no]) {
						visited[cur.no] = true;
						sum += cur.energy;
					}
					if (!visited[next.no]) {
						visited[next.no] = true;
						sum += next.energy;
					}
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (visited[list.get(i).no]) {
				list.remove(i--);
			}
		}
		return sum;
	}

}
