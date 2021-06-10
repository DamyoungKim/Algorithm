package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2798_블랙잭 {
	static int N, M, result = Integer.MAX_VALUE;
	static int[] arr;
	static int[] temp = new int[3];
	static int[] resultArr = new int[3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		solve(0,0);
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += resultArr[i];
		}
		System.out.println(sum);
	}

	public static void solve(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += temp[i];
			}
			if(M - sum < 0 ) return;
			if(result > M - sum) {
				result = Math.abs(M - sum);
				System.arraycopy(temp, 0, resultArr, 0, 3);
			}
			
			return;
		}

		for (int i = start; i < N; i++) {
			temp[cnt] = arr[i];
			solve(cnt + 1, i + 1);
		}
	}

}