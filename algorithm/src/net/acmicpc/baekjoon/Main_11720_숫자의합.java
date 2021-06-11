package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_11720_숫자의합 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result = 0;
		String s = sc.next();
		for(int i = 0; i < N; i++) {
			result += (s.charAt(i) - '0');
		}
		System.out.println(result);
	}

}
