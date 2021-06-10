package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1989_초심자의회문검사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	
		for(int t = 1; t <= T; t++) {
			String s = sc.next();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(s.length() -1 - i));
			}
			System.out.print("#" + t + " ");
			if(s.equals(sb.toString())) System.out.println(1);
			else System.out.println(0);
		}
	}
}
