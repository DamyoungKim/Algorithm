package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1026_보물 {
	static class B {
		int index;
		int val;
		public B(int index, int val) {
			super();
			this.index = index;
			this.val = val;
		}
		
	}
	static int N, min;
	static int[] arr;
	static boolean[] selected;
	static List<B> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(new B(i, temp));
		}
		Collections.sort(list, new Comparator<B>() {
			@Override
			public int compare(B o1, B o2) {
				return -1 * (o1.val - o2.val);
			}
		});
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (list.get(i).val * arr[i]);
		}
		System.out.println(sum);
	}

}
