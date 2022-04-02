package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		
		public Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node that) {
			if (this.x == that.x) {
				return this.y - that.y;
			}
			return this.x - that.x;
		}
		
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Node node = pq.poll();
			sb.append(node.x + " " + node.y + '\n');
		}
		
		System.out.println(sb);
	}
	
}
