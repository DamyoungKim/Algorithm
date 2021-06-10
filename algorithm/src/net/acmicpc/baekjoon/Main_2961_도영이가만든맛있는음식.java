package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2961_도영이가만든맛있는음식 {
	static int[] S, B;
	static boolean[] isSelected;
	static int N;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		s(0);
		System.out.println(result);
	}

	private static void s(int cnt) {

		if (cnt == N) {
			int totalS = 1;
			int totalB = 0;
			boolean check = false; // 공집합 구분
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					check = true;
					totalS *= S[i];
					totalB += B[i];
				}
			}
			if (check) {
				result = Math.abs(totalS - totalB) > result ? result : Math.abs(totalS - totalB);
			}
			return;
		}
		// 선택
		isSelected[cnt] = true;
		s(cnt + 1);
		// 비선택
		isSelected[cnt] = false;
		s(cnt + 1);
	}

}
