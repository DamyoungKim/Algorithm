package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static class Node {
		int vertex;
		int weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		Node[] adjList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;

		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;

			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;

			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			int temp = distance[i];
			if(temp == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
	}
}
