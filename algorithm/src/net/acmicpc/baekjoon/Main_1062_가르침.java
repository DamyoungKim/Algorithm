package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K, max;
	static String[] arr;
	static int[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		selected = new int[K];
		visited = new boolean['z' - 'a' + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		if(K < 5) {
			System.out.println(0);
			return;
		}
		K -= 5;
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		solve(0, 'b');
		System.out.println(max);
	}
	private static void solve(int cnt, int start) {
		if(cnt == K) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean check = true;
				for (int j = 0; j < arr[i].length(); j++) {
					if(!visited[arr[i].charAt(j) - 'a']) {
						check = false;
						break;
					}
				}
				
				if(check) count++;
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i <= 'z'; i++) {
			if(visited[i - 'a']) continue;
			visited[i - 'a'] = true;
			selected[cnt] = i;
			solve(cnt + 1, i + 1);
			visited[i - 'a'] = false;
		}
	}
}
