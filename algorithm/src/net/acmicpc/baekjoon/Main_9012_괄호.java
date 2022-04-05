package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_9012_괄호 {

//	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		
//		int T = sc.nextInt();
//		Stack<Character> stack = new Stack<>();
//		for(int t = 1; t <= T; t++) {
//			boolean ans = true;
//			stack.clear();
//			String s = sc.next();
//			for(int i = 0; i < s.length(); i++) {
//				char cur = s.charAt(i);
//				if(cur == '(') 
//					stack.add(cur);
//				if(cur == ')') {
//					if(stack.isEmpty())  {
//						ans = false;
//						break;
//					}
//					char last = stack.pop();
//					if(last == ')') {
//						ans = false;
//						break;
//					}
//	
//				}
//			}
//			if(!ans || !stack.isEmpty()) {
//				System.out.println("NO");
//				continue;
//			}
//			System.out.println("YES");
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int open = 0;
			char[] arr = sc.next().toCharArray();
			for (int i = 0, size = arr.length; i < size; i++) {
				if ('(' == arr[i]) {
					open++;
				} else if (')' == arr[i]) {
					open--;
					if(open < 0) {
						break;
					}
				}
			}
			if (open == 0) sb.append("YES");
			else sb.append("NO");
			sb.append('\n');
		}
		System.out.println(sb);
	}
}