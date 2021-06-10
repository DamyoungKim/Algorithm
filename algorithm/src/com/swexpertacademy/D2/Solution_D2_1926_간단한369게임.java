package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1926_간단한369게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		String s369 = "369";
		for (int i = 1; i <= N; i++) {
			String s = Integer.toString(i);
			int check = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s369.indexOf(s.charAt(j)) != -1) {
					sb.append('-');
					check++;
				}
			}
			if (check == 0)
				sb.append(i);
			sb.append(" ");
		}

		System.out.println(sb);
	}
}
