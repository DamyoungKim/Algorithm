package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K, max;
	static int[][] arr;
	static int[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N]['z' - 'a' + 2];
		selected = new int[K];
		visited = new boolean['z' - 'a' + 1];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr[i]['z' - 'a' + 1] = s.length();
			for (int j = 0; j < s.length(); j++) {
				arr[i][s.charAt(j) - 'a']++;
			}
		}
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		if(K < 5) {
			System.out.println(0);
			return;
		}
		selected[0] = 'a';
		selected[1] = 'n';
		selected[2] = 't';
		selected[3] = 'i';
		selected[4] = 'c';
		solve(5, 'b');
		System.out.println(max);
	}
	private static void solve(int cnt, int start) {
		if(cnt == K) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < K; j++) {
					sum += arr[i][selected[j] - 'a'];
				}
				if(sum == arr[i]['z' - 'a' + 1]) {
					count++;
				}
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i <= 'z'; i++) {
			if(visited[i - 'a']) continue;
			selected[cnt] = i;
			solve(cnt + 1, i + 1);
		}
	}
}
