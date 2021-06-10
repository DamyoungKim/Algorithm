package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int MAX = st.countTokens();
		int[] result = new int[MAX];
		for (int i = 0; i < MAX; i++) {
			int val = Integer.parseInt(st.nextToken());
			if (stack.empty()) {
				result[i] = 0;
				stack.push(new int[] { val, i + 1 });
			} else {
				if (stack.peek()[0] > val) {
					result[i] = stack.peek()[1];
					stack.push(new int[] { val, i + 1 });
					continue;
				}

				if (stack.peek()[0] < val) {
					while (stack.peek()[0] < val) {
						stack.pop();
						if(stack.empty()) break;
					}
					if (stack.empty()) {
						result[i] = 0;
					
					}else result[i] = stack.peek()[1];
					
					stack.push(new int[] { val, i + 1 });
				}
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}