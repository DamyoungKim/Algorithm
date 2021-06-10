package com.swexpertacademy.D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();

		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			boolean check = false;
			while (true) {
				for (int i = 1; i <= 5; i++) {
					int temp = q.poll() - i;

					if (temp <= 0) {
						q.offer(0);
						check = true;
						break;
					} else {
						q.offer(temp);
					}
				}
				if (check)
					break;
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
