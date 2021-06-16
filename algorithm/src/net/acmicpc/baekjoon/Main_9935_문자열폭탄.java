package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭탄 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		Stack<Character> temp = new Stack<>();
		char lastChar = s2.charAt(s2.length() - 1);
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == lastChar && stack.size()  >= s2.length() - 1) {
				temp.clear();
				temp.add(s1.charAt(i));
				boolean check = false;
				for(int j = s2.length() - 2; j >= 0; j--) {
					char tempChar = stack.pop();
					temp.add(tempChar);
					if(tempChar != s2.charAt(j)) {
						check = true;
						break;
					}
				}
				if(check) {
					for(int j = 0, size = temp.size(); j < size; j++) {
						stack.add(temp.pop());
					}
				}
			}else {
				stack.add(s1.charAt(i));
			}
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			System.out.println(sb);
		}
		
	}

}