package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			
			if(temp != 0) {
				stack.add(temp);
			}else {
				stack.pop();
			}
		}
		int result = 0;
		for(int i = 0, size = stack.size(); i < size; i++) {
			result += stack.pop();
		}
		
		System.out.println(result);
	}

}