package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String word = "()[]";
		Stack<Character> stack = new Stack<>();
		boolean check = true;
		while(sc.hasNextLine()) {
			
			String s = sc.nextLine();
			if(s.equals(".")) break;
			for(int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				if(temp == '.') {
					if(!stack.isEmpty()) check = false;
					System.out.println(check ? "yes" : "no");
					stack.clear();
					check = true;
				}
				if(word.indexOf(temp) == -1) continue;
				
				if(temp == '(' || temp =='[') stack.add(temp);
				
				if(temp == ')' || temp == ']') {
					if(stack.isEmpty()) {
						check = false;
					}else {
						if(temp == ')') {
							if(stack.peek() != '(') check = false;
							
						}
						if(temp == ']') {
							if(stack.peek() != '[') check = false;
						}
						if(check) stack.pop();
					}
				}
				
			}
			
		}
		
	}
}
