package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		String s = sc.next();
		StringBuffer sb = new StringBuffer();
		List<Integer> list = new ArrayList<>();
		boolean minus = false;
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(temp!= '+' && temp != '-') {
				sb.append(temp);
				if(i == s.length() - 1) {
					int lastVal = Integer.parseInt(sb.toString());
					list.add(minus ? -1 * lastVal : lastVal);
				}
				continue;
			}
			
			int val = Integer.parseInt(sb.toString());
			
			list.add(minus ? -1 * val : val);
			if(temp == '-') {
				minus = true;
			}
			
			sb = new StringBuffer();
		}
		
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}
		
		System.out.println(result);
	}
}
