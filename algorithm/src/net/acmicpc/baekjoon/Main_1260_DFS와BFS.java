package net.acmicpc.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS와BFS {
	static int N, M, start;
	static boolean[][] arr;
	static boolean[] check;

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new boolean[N + 1][N + 1];
		check = new boolean[N + 1];
		start = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from][to] = true;
			arr[to][from] = true;
		}
		dfs(start);
		check = new boolean[N + 1];
		System.out.println();
		bfs();

	}

	private static void dfs(int from) {
		check[from] = true;
		System.out.print(from + " ");
		for(int i = 1; i <= N; i++) {
			if(arr[from][i]) {
				if(check[i]) continue;
				check[i] = true; 
				dfs(i);
			}
			
		}
	}

	private static void bfs() {
		q.offer(start);
		check[start] = true;
		while (!q.isEmpty()) {
			int from = q.poll();
			System.out.print(from + " ");
			for (int i = 1; i <= N; i++) {
				if (arr[from][i]) {
					if(check[i]) continue;
					check[i] = true;
					q.offer(i);
				}
			}
		}

	}
}