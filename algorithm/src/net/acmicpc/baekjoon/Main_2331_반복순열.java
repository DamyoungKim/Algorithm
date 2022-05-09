package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;
public class Main_2331_반복순열 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		int P = Integer.parseInt(st.nextToken());
		
		int ans = bfs(A, P);
		System.out.println(ans);
	}

	private static int bfs(String A, int P) {
		Map<String, Integer> visited = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		q.offer(A);
		visited.put(A, 1);
		int ans = 0;
		while (!q.isEmpty()) {
			String cur = q.poll();
			int next = 0;
			for (int i = 0; i < cur.length(); i++) {
				next += Math.pow(cur.charAt(i) - '0', P);
			}
			String nextStr = Integer.toString(next);
			if (visited.containsKey(nextStr)) {
				ans = visited.get(nextStr) - 1;
				break;
			}
			int nextCnt = visited.get(cur) + 1;
			visited.put(nextStr, nextCnt);
			q.offer(nextStr);
			
		}
		return ans;
	}

}
