package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
			adj[end].add(start);
		}
		int[][] arr = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			boolean[] visited = new boolean[N + 1];
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			visited[i] = true;
			int cnt = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				cnt++;
				for(int j = 0; j < size; j++) {
					int temp = q.poll();
					for(int k = 0; k < adj[temp].size(); k++) {
						if(visited[adj[temp].get(k)]) continue;
						visited[adj[temp].get(k)] = true;
						q.offer(adj[temp].get(k));
						arr[i][adj[temp].get(k)] = cnt;
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 1; i < N + 1; i++) {
			int sum = 0;
			for(int j = 1; j < N + 1; j++) {
				sum += arr[i][j];
			}
			if(min > sum) {
				index = i;
				min = sum;
			}
		}
		System.out.println(index);
		
	}
}

