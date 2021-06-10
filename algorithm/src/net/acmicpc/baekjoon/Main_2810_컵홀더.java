package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2810_컵홀더 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String s = sc.next();

		int cnt = 0;
		int holder = 0;
		boolean checkLL = false;
		while (cnt != s.length()) {
			if (s.charAt(cnt) == 'S') {
				holder++;
				cnt++;
			} else {
				checkLL = true;
				holder++;
				cnt += 2;
			}
		}
		if (checkLL)
			holder++;
		System.out.println(holder);
	}

}