package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2941_크로아티아알파벳 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String croatia = "cdlnsz";
		int[] arr = new int['z' - 'a' + 1 + 8];
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (croatia.indexOf(s.charAt(i)) == -1) {
				arr[temp - 'a']++;
			} else {
				switch (temp) {
				case 'c':
					if (i + 1 < s.length() && s.charAt(i + 1) == '=') {
						arr['z' - 'a' + 1]++;
						i++;
					} else if (i + 1 < s.length() && s.charAt(i + 1) == '-') {
						arr['z' - 'a' + 2]++;
						i++;
					}else {
						arr['c' - 'a']++;
					}
					break;
				case 'd':
					if (i + 2 < s.length() && i + 1 < s.length() &&s.charAt(i + 2) == '=' && s.charAt(i + 1) == 'z') {
						arr['z' - 'a' + 3]++;
						i++;
						i++;
					} else if (i + 1 < s.length() && s.charAt(i + 1) == '-') {
						arr['z' - 'a' + 4]++;
						i++;
					}else {
						arr['d' - 'a']++;
					}
					break;
				case 'l':
					if(i + 1 < s.length() && s.charAt(i + 1) == 'j') {
						arr['z' - 'a' + 5]++;
						i++;
					}else {
						arr['l' - 'a']++;
					}
					break;
				case 'n':
					if(i + 1 < s.length() && s.charAt(i + 1) == 'j') {
						arr['z' - 'a' + 6]++;
						i++;
					}else {
						arr['n' - 'a']++;
					}
					break;
				case 's':
					if(i + 1 < s.length() && s.charAt(i + 1) == '=') {
						arr['z' - 'a' + 7]++;
						i++;
					}else {
						arr['s' - 'a']++;
					}
					break;
				case 'z':
					if(i + 1 < s.length() && s.charAt(i + 1) == '=') {
						arr['z' - 'a' + 8]++;
						i++;
					}else {
						arr['z' - 'a']++;
					}
					break;
				}

			}
		}
		int cnt = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] != 0) cnt += arr[i]; 
		}
		System.out.println(cnt);
	}

}