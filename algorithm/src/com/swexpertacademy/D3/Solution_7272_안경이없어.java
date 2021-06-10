package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_7272_안경이없어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String s1 = sc.next();
			String s2 = sc.next();
			boolean check = true;
			if (s1.length() != s2.length()) {
				System.out.println("#" + t + " " + "DIFF");
				continue;
			}
			for (int i = 0; i < s1.length(); i++) {
				if (zero.indexOf(s1.charAt(i)) != -1 && zero.indexOf(s2.charAt(i)) != -1) {
					continue;
				}
				if (one.indexOf(s1.charAt(i)) != -1 && one.indexOf(s2.charAt(i)) != -1) {
					continue;
				}

				if (s1.charAt(i) == 'B' && s2.charAt(i) == 'B') {
					continue;
				}
				check = false;
				break;

			}
			if (check)
				System.out.println("#" + t + " " + "SAME");

			else
				System.out.println("#" + t + " " + "DIFF");

		}
	}

}
