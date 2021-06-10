package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_16953_A에서B {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();
		int cnt = 1;
		while (true) {
			if(Integer.parseInt(A) > Integer.parseInt(B)) {
				System.out.println(-1);
				break;
			}
			if (B.charAt(B.length() - 1) == '1') {
				cnt++;
				B = B.substring(0, B.length() - 1);
				if (A.equals(B)) {
					System.out.println(cnt);
					break;
				}
			}else if(Integer.parseInt(B) % 2 == 0) {
				cnt++;
				B = Integer.toString((Integer.parseInt(B) / 2));
				if (A.equals(B)) {
					System.out.println(cnt);
					break;
				}
			}else {
				System.out.println(-1);
				break;
			}

		}
	}
}
