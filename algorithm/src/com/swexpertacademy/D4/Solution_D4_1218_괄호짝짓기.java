package com.swexpertacademy.D4;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int t = 1; t <= T; t++) {
			int result = 1;
			int N = sc.nextInt();
			String temp = sc.next();
			for (int i = 0; i < N; i++) {
				char c = temp.charAt(i);
				if (c == '{' || c == '(' || c == '<' || c == '[') {
					stack.push(c);
				} else {
					if (c == '}') {
						if ((char) stack.peek() == '{') {
							stack.pop();
						} else {
							result = 0;
							break;
						}
					}
					if (c == ')') {
						if ((char) stack.peek() == '(') {
							stack.pop();
						} else {
							result = 0;
							break;
						}
					}
					if (c == '>') {
						if ((char) stack.peek() == '<') {
							stack.pop();
						} else {
							result = 0;
							break;
						}
					}
					if (c == ']') {
						if ((char) stack.peek() == '[') {
							stack.pop();
						} else {
							result = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
