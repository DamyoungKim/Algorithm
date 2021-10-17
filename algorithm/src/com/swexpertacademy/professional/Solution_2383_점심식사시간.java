package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	static int T, N, size, min;

	static class Node {
		int y;
		int x;
		int s1;
		int s2;
		int len;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static List<Node> people, stairs;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			people = new ArrayList<>();
			stairs = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						people.add(new Node(i, j));
					}
					if (temp >= 2) {
						Node node = new Node(i, j);
						node.len = temp;
						stairs.add(node);
					}
				}
			}
			Node s1 = stairs.get(0);
			Node s2 = stairs.get(1);
			size = people.size();
			min = Integer.MAX_VALUE;
			selected = new boolean[size];

			for (int i = 0; i < size; i++) {
				Node p = people.get(i);
				p.s1 = Math.abs(p.y - s1.y) + Math.abs(p.x - s1.x) + 1;
				p.s2 = Math.abs(p.y - s2.y) + Math.abs(p.x - s2.x) + 1;
			}
			solve(0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void solve(int cnt) {
		if (cnt == size) {
			PriorityQueue<Node> s1 = new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o1.s1 - o2.s1;
				}
			});
			PriorityQueue<Node> s2 = new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o1.s2 - o2.s2;
				}
			});
			for (int i = 0; i < size; i++) {
				if (selected[i]) {
					s1.add(people.get(i));
				} else {
					s2.add(people.get(i));
				}
			}

			downStair(s1, s2);
			return;
		}

		selected[cnt] = true;
		solve(cnt + 1);
		selected[cnt] = false;
		solve(cnt + 1);
	}

	private static void downStair(PriorityQueue<Node> s1, PriorityQueue<Node> s2) {
	int timeS1 = 0;
	int timeS2 = 0;
	int[] time = new int[s1.size()];
	int cnt = 0;
	int len = stairs.get(0).len;
	while (!s1.isEmpty()) {
		Node p = s1.poll();
		time[cnt] = p.s1 + len;
		if (cnt >= 3) {
			if (time[cnt - 3] > p.s1) {
				time[cnt] += (time[cnt - 3] - p.s1);
			}
		}
		cnt++;
	}
	if (cnt > 0) {
		timeS1 = time[cnt - 1];
	}

	time = new int[s2.size()];
	cnt = 0;
	len = stairs.get(1).len;
	while (!s2.isEmpty()) {
		Node p = s2.poll();
		time[cnt] = p.s2 + len;
		if (cnt >= 3) {
			if (time[cnt - 3] > p.s2) {
				time[cnt] += (time[cnt - 3] - p.s2);
			}
		}
		cnt++;
	}
	if (cnt > 0) {
		timeS2 = time[cnt - 1];
	}
	min = Math.min(Math.max(timeS2, timeS1), min);
}
}
/*
1
10
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 1 0 0 0 0
0 0 0 0 1 0 1 0 0 0
0 0 0 1 0 0 0 1 0 0
0 0 1 0 0 2 0 0 1 0
0 0 0 1 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
10 0 0 0 0 0 0 0 0 0

*/