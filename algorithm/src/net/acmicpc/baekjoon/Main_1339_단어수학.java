package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1339_단어수학 {
	static boolean[] isSelected = new boolean[10];
	static char[][] arr, copyArr;
	static int N, useAlph, result;
	static int[] number = new int[10], alph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][];
		copyArr = new char[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		alph = new int['Z' - 'A' + 1];
		Arrays.fill(alph, -1);
		for (int i = 0; i < N; i++) {
			copyArr[i] = new char[arr[i].length];
			for (int j = 0; j < arr[i].length; j++) {
				if (alph[arr[i][j] - 'A'] != -1)
					continue;
				alph[arr[i][j] - 'A'] = 0;
				useAlph++;
			}
		}

		solve(0);
		System.out.println(result);
	}

	public static void solve(int cnt) {
		if (cnt == useAlph) {
			int index = 0;
			for (int i = 0; i < 'Z' - 'A' + 1; i++) {
				if (alph[i] == -1)
					continue;
				alph[i] = number[index++];
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < arr[i].length; j++) {
					sb.append((char) (alph[arr[i][j] - 'A'] + '0'));
				}
				sum += Integer.parseInt(sb.toString());
			}

			result = result > sum ? result : sum;

			return;
		}

		for (int i = 9; i > 9 - useAlph; i--) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			number[cnt] = i;
			solve(cnt + 1);
			isSelected[i] = false;
		}
	}
}