package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K, max;
	static String[] arr;
	static int[] selected;
	static int mask = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		selected = new int[K];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		if(K < 5) {
			System.out.println(0);
			return;
		}
		K -= 5;
		int mask = 0;
		mask |= 1 << ('a' - 'a');
		mask |= 1 << ('n' - 'a');
		mask |= 1 << ('t' - 'a');
		mask |= 1 << ('i' - 'a');
		mask |= 1 << ('c' - 'a');
		solve(0, 'b', mask);
		System.out.println(max);
	}
	private static void solve(int cnt, int start, int mask) {
		if(cnt == K) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean check = true;
				for (int j = 0; j < arr[i].length(); j++) {
					if((mask & (1 << (arr[i].charAt(j) - 'a'))) == 0){
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
			if((mask & (1 << (i - 'a'))) != 0) continue;
			solve(cnt + 1, i + 1, mask | (1 << (i - 'a')));
		}
	}
}
