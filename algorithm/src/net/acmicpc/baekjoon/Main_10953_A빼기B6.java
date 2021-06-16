package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_10953_A빼기B6 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String s = sc.next();

			int comma = s.indexOf(",");

			int A = Integer.parseInt(s.substring(0, comma));
			int B = Integer.parseInt(s.substring(comma + 1));

			System.out.println(A + B);
		}
	}

}
