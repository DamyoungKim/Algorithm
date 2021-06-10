package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {
	static int N, d, k, c, count, result;
	static int arr[];
	static int[] selected;
	static boolean serviceMenu;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selected = new int[d + 1];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(c == arr[i]) serviceMenu = true;
		}
		
		for(int i = 0; i < k; i++) {
			int temp = arr[i];
			q.offer(temp);
			if(selected[temp] == 0) count++;
			selected[temp]++;
			
		}
		result = count;
		if(serviceMenu) solve1();
		else solve2();
		
		System.out.println(result);
	}
	private static void solve1() {
		for(int i = k; i < N + k; i++) {
			int first = q.poll();
			selected[first]--;
			if(selected[first] == 0) count--;
			int last = arr[i % N];
			if(selected[last] == 0) count++;
			selected[last]++;
			q.offer(last);
			int temp = 0;
			if(selected[c] == 0) {
				temp = count + 1;
				result = result > temp ? result : temp;
				continue;
			}
			result = result > count ? result : count;
		}
	}
	private static void solve2() {
		for(int i = k; i < N + k; i++) {
			int first = q.poll();
			selected[first]--;
			if(selected[first] == 0) count--;
			int last = arr[i % N];
			if(selected[last] == 0) count++;
			selected[last]++;
			q.offer(last);
			result = result > count ? result : count;
		}
		result++;
	}
}
