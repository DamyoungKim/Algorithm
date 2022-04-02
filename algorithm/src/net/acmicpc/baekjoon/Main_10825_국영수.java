package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10825_국영수 {
	static class Node implements Comparable<Node> {
		String name;
		int kor;
		int eng;
		int math;
		
		public Node(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public int compareTo(Node that) {
			if (this.kor != that.kor) return that.kor - this.kor;
			if (this.eng != that.eng) return this.eng - that.eng;
			if (this.math != that.math) return that.math - this.math;
			
			return this.name.compareTo(that.name);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Node(
						st.nextToken(),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
					));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(pq.poll().name + '\n');
		}
		System.out.println(sb);
	}

}
