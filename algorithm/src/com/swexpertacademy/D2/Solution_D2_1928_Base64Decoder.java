package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1928_Base64Decoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb;

		char[] encoding = new char[64];

		int count = 0;
		for (char i = 'A'; i <= 'Z'; i++) {
			encoding[count++] = i;
		}
		for (char i = 'a'; i <= 'z'; i++) {
			encoding[count++] = i;
		}

		for (char i = '0'; i <= '9'; i++) {
			encoding[count++] = i;
		}

		encoding[count++] = '+';
		encoding[count++] = '/';

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			sb = new StringBuffer();
			for (int j = 0; j < s.length(); j++) {
				for (int i = 0; i < count; i++) {
					if (s.charAt(j) == encoding[i]) {
						
						for (int k = 0; k < 6 - Integer.toBinaryString(i).length(); k++) {
							sb.append(0);
						}
						sb.append(Integer.toBinaryString(i));
						
						break;
					}
				}
			}
			int check = 7;
			int sum = 0;
			StringBuffer a = new StringBuffer();
			for (int i = 0; i < sb.length(); i++) {

				int x = sb.charAt(i) - '0';
				sum += x * Math.pow(2, check);
				check--;
				if (check == -1) {
					a.append((char) sum);
					check = 7;
					sum = 0;
				}
			}
			System.out.println("#" + t + " " + a);
		}
	}
}
