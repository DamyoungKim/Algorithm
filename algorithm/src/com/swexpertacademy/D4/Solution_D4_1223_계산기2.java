package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1223_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stackI = new Stack<>();
		String number = "0123456789";
		for (int t = 1; t <= 1; t++) {
			StringBuffer sb = new StringBuffer();
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			for (int i = 0; i < N; i++) {
				if (number.indexOf(s.charAt(i)) != -1) {
					sb.append(s.charAt(i));
				} else {
					if (stack.isEmpty()) {
						stack.push(s.charAt(i));
					} else {
						if (!stack.isEmpty()) {
							if (s.charAt(i) == '*') {
								if (stack.peek() == '+') {
									stack.push(s.charAt(i));
								} else {
									while(!stack.isEmpty() && stack.peek() == '*') {
										sb.append(stack.pop());
									}
									stack.push(s.charAt(i));
								}
							}
							if (s.charAt(i) == '+') {
								while (!stack.isEmpty()) {
									sb.append(stack.pop());
								}
								stack.push(s.charAt(i));
							}
						}
					}
				}
			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb);
			for (int i = 0; i < N; i++) {
				if (number.indexOf(sb.charAt(i)) != -1) {
					stackI.push(sb.charAt(i) - '0');
				} else {
					if (sb.charAt(i) == '*') {
						int a = stackI.pop();
						int b = stackI.pop();
						stackI.push(a * b);
					}
					if (sb.charAt(i) == '+') {
						int a = stackI.pop();
						int b = stackI.pop();
						stackI.push(a + b);
					}
				}
			}
			System.out.println("#" + t + " " + stackI.pop());
		}

	}
}

/*
 * 13 3+5*9*7*2+7+7
 */
