package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Bong {
	int x;
	int y;

	public Bong(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Main_2304_창고다각형 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Bong[] poles = new Bong[N];
		Stack<Bong> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			poles[i] = new Bong(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(poles, new Comparator<Bong>() {

			@Override
			public int compare(Bong o1, Bong o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});

		Bong maxBong = poles[0];
		for (Bong p : poles) {
			if (p.y > maxBong.y) {
				maxBong = p;
			}
		}
		int S = 0;
		int cnt = 0;
		stack.add(poles[0]);
		while (poles[cnt] != maxBong) {

			int max = stack.peek().y;
			if (max <= poles[cnt + 1].y) {
				stack.add(poles[cnt + 1]);
			}
			cnt++;
//			if (poles[cnt] == maxBong) {
//				stack.add(poles[cnt]);
//			}
		}
		while (cnt != poles.length - 1) {
			if (poles[cnt + 1].y == poles[cnt].y) {
				stack.add(poles[cnt + 1]);
			} else if (poles[cnt + 1].y > poles[cnt].y) {
				while (stack.peek().y < poles[cnt + 1].y) {
					stack.pop();
				}
				stack.add(poles[cnt + 1]);
			} else if (poles[cnt + 1].y < poles[cnt].y) {
				stack.add(poles[cnt + 1]);
			}
		cnt++;
		}

		boolean check = false;

		while (!stack.isEmpty()) {
			if (maxBong == stack.peek()) {
				check = true;
			}
			if (check) {
				S += stack.peek().y;
				if (stack.size() == 1)
					break;
				S += (stack.pop().x - stack.peek().x - 1) * stack.peek().y;
			} else {
				S += stack.peek().y;
				if (stack.size() == 1)
					break;
				S += stack.peek().y * (stack.pop().x - stack.peek().x - 1);
			}
		}
		System.out.println(S);
	}
}
