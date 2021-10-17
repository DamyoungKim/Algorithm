package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477_차량정비소 {
	static int T, N, M, K, A, B;
	static int[] rec, rep, times;

	static class Node {
		int no;
		int tk;
		int rec;
		int rep;

		public Node(int no, int tk) {
			super();
			this.no = no;
			this.tk = tk;
		}
	}

	static Queue<Node> people;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			rec = new int[N + 1];
			rep = new int[M + 1];
			times = new int[K + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				rec[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				rep[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			people = new LinkedList<>();
			for (int i = 1; i <= K; i++) {
//				times[i] = Integer.parseInt(st.nextToken());
				people.offer(new Node(i, Integer.parseInt(st.nextToken())));
			}

			int result = recept();
			if (result == 0) result = -1;
			System.out.println("#" + t + " " + result);
			
		}
	}

	private static int recept() {
		Node[] receptions = new Node[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.tk == o2.tk) {
					return o1.rec - o2.rec;
				} else {
					return o1.tk - o2.tk;
				}
			}
		});
		while (!people.isEmpty()) {
			Node node = people.poll();
			boolean check = false;
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 1; i <= N; i++) {
				Node reception = receptions[i];
				if (reception != null) {
					if (min > reception.tk) {
						min = reception.tk;
						minIndex = i;
					}
					if (reception.tk <= node.tk) {
						pq.offer(reception);
						receptions[i] = node;
						node.tk += rec[i];
						node.rec = i;
						check = true;
						break;
					}
				}
			}
			if (check)
				continue;
			for (int i = 1; i <= N; i++) {
				Node reception = receptions[i];
				if (reception == null) {
					check = true;
					receptions[i] = node;
					node.tk += rec[i];
					node.rec = i;
					break;
				}
			}
			if (check)
				continue;
			pq.offer(receptions[minIndex]);
			int waittingTime = receptions[minIndex].tk - node.tk;
			receptions[minIndex] = node;
			node.tk += (rec[minIndex] + waittingTime);
			node.rec = minIndex;
		}
		
		for (int i = 1; i <= N; i++) {
			if (receptions[i] == null) continue;
			pq.offer(receptions[i]);
		}
		Queue<Node> q = new LinkedList<>();
		Node[] repairs = new Node[N + 1];
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			boolean check = false;
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 1; i <= M; i++) {
				Node repair = repairs[i];
				if (repair != null) {
					if (min > repair.tk) {
						min = repair.tk;
						minIndex = i;
					}
					if (repair.tk <= node.tk) {
						q.offer(repair);
						repairs[i] = node;
						node.tk += rep[i];
						node.rep = i;
						check = true;
						break;
					}
				}
			}
			if (check)
				continue;
			for (int i = 1; i <= M; i++) {
				Node repair = repairs[i];
				if (repair == null) {
					check = true;
					repairs[i] = node;
					node.tk += rep[i];
					node.rep = i;
					break;
				}
			}
			if (check)
				continue;
			q.offer(repairs[minIndex]);
			int waittingTime = repairs[minIndex].tk - node.tk;
			repairs[minIndex] = node;
			node.tk += (rep[minIndex] + waittingTime);
			node.rep = minIndex;
		}
		for (int i = 1; i <= M; i++) {
			if (repairs[i] == null) continue;
			q.offer(repairs[i]);
		}
		int result = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if (node.rec == A && node.rep == B) result += node.no;
		}
		return result;
	}

}
/*
1
2 2 6 1 2
3 2
4 2
0 0 1 2 3 4

*/