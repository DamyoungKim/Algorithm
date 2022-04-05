package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> A = new Stack<>(), B = new Stack<>();
		for (int i = 0, size = s.length(); i < size; i++) {
			A.add(s.charAt(i));
		}
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char mode = st.nextToken().charAt(0);
			switch (mode) {
				case 'P': 
					A.add(st.nextToken().charAt(0));
					break;
				case 'L':
					if (A.isEmpty()) break;
					B.add(A.pop());
					break;
				case 'B':
					if (A.isEmpty()) break;
					A.pop();
					break;
				case 'D':
					if (B.isEmpty()) break;
					A.add(B.pop());
					break;
			}
		}
		
		while (!A.isEmpty()) {
			B.add(A.pop());
		}
		StringBuilder sb = new StringBuilder();
		while (!B.isEmpty()) {
			sb.append(B.pop());
		}
		System.out.println(sb);
	}

}
