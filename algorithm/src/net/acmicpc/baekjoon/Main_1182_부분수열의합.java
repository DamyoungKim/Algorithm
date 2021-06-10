package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1182_부분수열의합 {
	static int N, S;
	static boolean[] isSelected;
	static int[] arr;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sub(0);
		System.out.println(count);

	}

	private static void sub(int cnt) {
		if (cnt == N) {
			int result = 0;
			int check = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					result += arr[i];
					continue;
				}
				check++;
			}
			if(check == N && S == 0) count -= 1;
			if (result == S) count++;
			return;
		}

		isSelected[cnt] = true;
		sub(cnt + 1);
		isSelected[cnt] = false;
		sub(cnt + 1);
	}
}