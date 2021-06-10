package net.acmicpc.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10799_쇠막대기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		
			String s = sc.next();
			int count = 0;
			int stick = 0;
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				stack.push(s.charAt(i));
				if (i + 1 < s.length() && (char) stack.peek() == '(' && s.charAt(i + 1) == ')') {
					stack.pop();
					i += 1;
					while (!stack.isEmpty()) {
						stack.pop();
					}
					sum += stick;
					continue;
				}
				if ((char) stack.peek() == '(') {
					stick++;
				} else if ((char) stack.peek() == ')') {
					stick--;
					sum += 1;
				}
			}
			System.out.println(sum);
		
	}
}