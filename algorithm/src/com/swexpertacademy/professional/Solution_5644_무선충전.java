package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int T, M, A, sum;
	static int[] dirA, dirB, dx = {0, 0, 1, 0, -1}, dy = {0, -1, 0, 1, 0}, powerA, powerB;
	static List<Node>[][] arr;
	static class Node implements Comparable<Node> {
		int y;
		int x;
		int C;
		int P;
		
		
		public Node(int y, int x, int c, int p) {
			super();
			this.y = y;
			this.x = x;
			C = c;
			P = p;
		}


		@Override
		public int compareTo(Node o) {
			return o.P - this.P;
		}
		
		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if (this.y == node.y && this.x == node.x) return true;
			return false;
		}
	}
	static Node userA, userB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			dirA = new int[M];
			for (int i = 0; i < M; i++) {
				dirA[i] = Integer.parseInt(st.nextToken());
			}
			
			dirB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dirB[i] = Integer.parseInt(st.nextToken());
			}
			
			arr = new ArrayList[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					arr[i][j] = new ArrayList<>();
				}
			}
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				Node node = new Node(y, x, C, P);
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (Math.abs(x - j) + Math.abs(y - i) <= C) arr[i][j].add(node);
					}
				}
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (arr[i][j].size() >= 2) {
						Collections.sort(arr[i][j]);
					}
				}
			}
			sum = 0;
			userA = new Node(0, 0, 0, 0);
			userB = new Node(9, 9, 0, 0);
			gain(userA, userB);
			for (int i = 0; i < M; i++) {
				move(userA, dirA[i]);
				move(userB, dirB[i]);
				gain(userA, userB);
			}
			System.out.println("#" + t + " " + sum);
		}

	}
	
	static public void move(Node node, int dir) {
		node.y += dy[dir];
		node.x += dx[dir];
	}
	
	static public void gain(Node userA, Node userB) {
		List<Node> A = arr[userA.y][userA.x];
		List<Node> B = arr[userB.y][userB.x];
		
		if (A.size() == 0 && B.size() == 0) return;
		
		if (A.size() >= 1 && B.size() == 0) {
			sum += A.get(0).P;
			return;
		}
		
		if (A.size() == 0 && B.size() >= 1) {
			sum += B.get(0).P;
			return;
		}
		
		if (A.size() == 1 && B.size() == 1) {
			if (B.get(0).equals(A.get(0))) {
				sum += B.get(0).P;
			} else {
				sum += (B.get(0).P + A.get(0).P);
			}
			return;
		}
		
		if (A.size() >= 2 && B.size() == 1) {
			if (B.get(0).equals(A.get(0))) {
				sum += (A.get(1).P + B.get(0).P);
			}else {
				sum += (A.get(0).P + B.get(0).P);
			}
			return;
		}
		
		if (A.size() == 1 && B.size() >= 2) {
			if (B.get(0).equals(A.get(0))) {
				sum += (A.get(0).P + B.get(1).P);
			}else {
				sum += (A.get(0).P + B.get(0).P);
			}
			return;
		}
		
		if (A.size() >= 2 && B.size() >= 2) {
			if (A.get(0).equals(B.get(0))) {
				if (A.get(1).P > B.get(1).P) {
					sum += A.get(1).P;
					sum += B.get(0).P;
				} else {
					sum += A.get(0).P;
					sum += B.get(1).P;
				}
			} else {
				sum += A.get(0).P;
				sum += B.get(0).P;
			}
			return;
		}
	}
}

/*
1
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
7 10 3 40
6 3 2 70
4 4 1 100

 * */
