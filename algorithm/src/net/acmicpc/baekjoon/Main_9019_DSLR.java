package net.acmicpc.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9019_DSLR {
	static Queue<String[]> q;
	static String A, B;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			A = sc.next();
			B = sc.next();
			q = new LinkedList<String[]>();
			visited = new boolean[10000];
			q.offer(new String[] { A, "" });
			bfs();
		}
	}

	private static void bfs() {
		boolean check = false;
		while (!q.isEmpty()) {
			String[] temp = q.poll();
			String s = temp[0];
			String process = temp[1];
			String result = null;
			String mode = null;
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					result = D(s);
					mode = "D";
					break;
				case 1:
					result = S(s);
					mode = "S";
					break;
				case 2:
					result = L(s);
					mode = "L";
					break;
				case 3:
					result = R(s);
					mode = "R";
					break;
				}

				if (result.equals(B)) {
					System.out.println(process + mode);
					check = true;
					break;
				}
				if(!visited[Integer.parseInt(result)]) {
					visited[Integer.parseInt(result)] = true;
					q.offer(new String[] { result, process + mode });
				}
			}
			if (check)
				break;
		}

	}

	private static String D(String s) {
		int before = Integer.parseInt(s);
		int after = before * 2 % 10000;
		return Integer.toString(after);
	}

	private static String S(String s) {
		int before = Integer.parseInt(s);
		int after = before == 0 ? 9999 : before - 1;
		return Integer.toString(after);
	}

	private static String L(String s) {
		int num = Integer.parseInt(s);
		return Integer.toString(( (num % 1000) * 10 ) + ( num / 1000 ));
	}

	private static String R(String s) {
		int num = Integer.parseInt(s);
		return  Integer.toString(( (num % 10) * 1000 ) + ( num / 10 ) );
	}
}