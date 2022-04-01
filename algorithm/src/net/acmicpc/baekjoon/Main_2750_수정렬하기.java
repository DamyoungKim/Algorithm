package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2750_수정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
