package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_D4_5550_나는개구리로소이다 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			int[] arr = new int[5];
			boolean check = false;
			int cnt = 0;
			boolean a = false;

			for (int i = 0; i < s.length(); i++) {
				
				char c = s.charAt(i);
				if (c == 'c') {
					if(cnt != 0 ) {
						cnt--;
					}
					arr[0]++;
				} else if (c == 'r') {
					if (arr[0] > arr[1]) {
						arr[1]++;
					} else {
						check = true;
						break;
					}
				} else if (c == 'o') {
					if (arr[0] > arr[2] && arr[1] > arr[2]) {
						arr[2]++;
					} else {
						check = true;
						break;
					}
				} else if (c == 'a') {
					if (arr[0] > arr[3] && arr[1] > arr[3] && arr[2] > arr[3]) {
						arr[3]++;
					} else {
						check = true;
						break;
					}
				} else if (c == 'k') {
					if (arr[0] > arr[4] && arr[1] > arr[4] && arr[2] > arr[4] && arr[3] > arr[4]) {
						arr[4]++;
						cnt++;
					} else {
						check = true;
						break;
					}
				}

			}
			int start = arr[0];
			for(int i = 1; i < 5; i++) {
				if(start != arr[i]) {
					check = true;
					break;
				}
			}
			if (check)
				System.out.println("#" + t + " " + "-1");
			else {
				System.out.println("#" + t + " " + cnt);
			}
		}
	}
}
