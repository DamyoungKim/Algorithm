package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2605_줄세우기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> order = new ArrayList<>();
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			order.add(i);
		}

		for (int i = 0; i < N; i++) {
			int o = sc.nextInt();
			if(o == 0) continue;
			int val = order.get(i);
			order.remove(i);
			order.add(i - o, val);
		}
		
		for(int x : order) {
			System.out.print(x + " ");
		}
	}
}