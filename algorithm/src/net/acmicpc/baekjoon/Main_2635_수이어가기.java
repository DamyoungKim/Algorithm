package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2635_수이어가기 {
	static int cnt = 2, result;
	static List<Integer> list = new ArrayList<>();
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = N; i >= 1; i--) {
			check = false;
			cnt = 0;
			solve(N, i);
			if(check) {
				list.add(i);
				list.add(N);
			}
		}
		System.out.println(list.size());
		for(int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}

	public static void solve(int a, int b) {
		int x = a - b;
		if(x < 0) {
			if(result < cnt) {
				list.clear();
				result = cnt;
				check = true;
				
			}
			return;
		}
		cnt++;
		solve(b, x);
		if(check) {
			list.add(x);
		}
	}
}