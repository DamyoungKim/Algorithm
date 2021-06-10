package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1976_시각덧셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int startHour = sc.nextInt();
			int startMin = sc.nextInt();
			int endHour = sc.nextInt();
			int endMin = sc.nextInt();

			int resultMin = startMin + endMin;
			int resultHour = startHour + endHour;
			if (resultMin >= 60) {
				resultMin -= 60;
				resultHour += 1;
			}
			
			if(resultHour >= 13) resultHour -= 12;

			System.out.println("#" + t + " " + resultHour + " " + resultMin);
		}
	}

}
