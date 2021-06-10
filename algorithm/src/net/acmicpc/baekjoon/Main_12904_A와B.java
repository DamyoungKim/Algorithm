package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_12904_A와B {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		
		while(true) {
			if(S.length() > T.length()) {
				System.out.println(0);
				return;
			}
			if(T.charAt(T.length() - 1) == 'A') {
				T = T.substring(0, T.length() - 1);
			}else if (T.charAt(T.length() - 1) == 'B') {
				T = T.substring(0, T.length() - 1);
				StringBuffer sb = new StringBuffer();
				for(int i = T.length() - 1; i >= 0; i--) {
					sb.append(T.charAt(i));
				}
				T = sb.toString();
			}
			if(S.equals(T)) {
				System.out.println(1);
				return;
			}
		}
	}

}
