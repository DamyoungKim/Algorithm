package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		Stack<Character> stack = new Stack<>();
		for(int t = 1; t <= T; t++) {
			boolean ans = true;
			stack.clear();
			String s = sc.next();
			for(int i = 0; i < s.length(); i++) {
				char cur = s.charAt(i);
				if(cur == '(') 
					stack.add(cur);
				if(cur == ')') {
					if(stack.isEmpty())  {
						ans = false;
						break;
					}
					char last = stack.pop();
					if(last == ')') {
						ans = false;
						break;
					}
	
				}
			}
			if(!ans || !stack.isEmpty()) {
				System.out.println("NO");
				continue;
			}
			System.out.println("YES");
		}
	}

}