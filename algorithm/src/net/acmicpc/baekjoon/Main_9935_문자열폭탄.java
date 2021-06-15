package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_9935_문자열폭탄 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s1.length(); i++) {
			stack.add(s1.charAt(i));
		}
		
		Stack<Character> temp = new Stack<>();
		List<Character> list = null;
		while(true) {
			if(stack.size() == 0) {
				break;
			}
			char lastChar = stack.pop();
			
			if(lastChar == s2.charAt(s2.length() - 1)) {
				list = new ArrayList<>();
				list.add(lastChar); // 같으니까 list에 넣는다
				for(int i = s2.length() - 2 ; i >= 0; i--) {
					if(stack.isEmpty()) break;
					char curChar = stack.pop();
					char checkChar = s2.charAt(i);
					
					if(curChar == checkChar) {
						list.add(curChar); // 같으니까 list에 넣는다
						
						if(i == 0 && !temp.isEmpty()) {
							for(int j = 0, size = temp.size(); j < size; j++) {
								stack.add(temp.pop());
							}
						}
					}else {
						temp.add(lastChar);
						list.add(curChar);
						for(int j = list.size() - 1; j >= 1; j--) {
							stack.add(list.get(j));
						}
						break;
					}
				}
			}else {
				temp.add(lastChar);
			}
		}
		
		
		if(temp.size() == 0) {
			System.out.println("FRULA");
		} else {
			for(int i = 0, size = temp.size(); i < size; i++) {
				System.out.print(temp.pop());
			}
		}
	}

}