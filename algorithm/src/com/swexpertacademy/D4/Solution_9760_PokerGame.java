package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_9760_PokerGame {
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			arr = new int[4][15];
			for (int i = 0; i < 5; i++) {
				String s = sc.next();
				int r = 0;
				switch (s.charAt(0)) {
				case 'S':
					r = 0;
					break;
				case 'D':
					r = 1;
					break;
				case 'H':
					r = 2;
					break;
				case 'C':
					r = 3;
					break;
				}
				if (s.charAt(1) == 'A') {
					arr[r][1]++;
					arr[r][14]++;
				} else if (s.charAt(1) == 'T') {
					arr[r][10]++;
				} else if (s.charAt(1) == 'J') {
					arr[r][11]++;
				} else if (s.charAt(1) == 'Q') {
					arr[r][12]++;
				} else if (s.charAt(1) == 'K') {
					arr[r][13]++;
				} else {
					arr[r][s.charAt(1) - '0']++;
				}
			}
			System.out.print("#" + t + " ");
			if (straightFlush()) {
				System.out.println("Straight Flush");
				continue;
			}
			if (fourKind()) {
				System.out.println("Four of a Kind");
				continue;
			}

			if (fullHouse()) {
				System.out.println("Full House");
				continue;
			}
			
			if(flush()) {
				System.out.println("Flush");
				continue;
			}

			if(straight()) {
				System.out.println("Straight");
				continue;
			}
			
			if(threeKind()) {
				System.out.println("Three of a kind");
				continue;
			}
			
			if(twoPair()) {
				System.out.println("Two pair");
				continue;
			}
			
			if(onePair()) {
				System.out.println("One pair");
				continue;
			}
			
			System.out.println("High card");
		}
	}

	private static boolean straightFlush() {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 11; j++) {
				int cnt = 0;
				while (arr[i][j] != 0) {
					cnt++;
					j++;
					if (cnt == 5)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean fourKind() {
		for (int i = 1; i < 14; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				if (arr[j][i] == 0)
					break;
				cnt++;
			}
			if (cnt == 4)
				return true;
			
			if(cnt != 0) return false;
		}

		return false;
	}

	private static boolean fullHouse() {
		boolean two = false;
		boolean three = false;
		for (int i = 1; i < 14; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				if (arr[j][i] != 0)
					cnt++;
			}
			if (cnt == 2)
				two = true;
			if (cnt == 3)
				three = true;
		}
		return two && three ? true : false;
	}

	private static boolean flush() {
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			for (int j = 1; j < 14; j++) {
				if (arr[i][j] != 0)
					cnt++;
			}

			if (cnt == 5)
				return true;
		}
		return false;
	}

	private static boolean straight() {
		
		for (int i = 1; i < 11; i++) {
			int check = 0;
			for (int j = 0; j < 4; j++) {
				if (arr[j][i] != 0)
					check++;
			}

			if (check >= 2)
				return false;
			if (check == 1) {
				int sum = 1;
				while (true) {
					int chk = 0;
					i++;
					for (int k = 0; k < 4; k++) {
						if(arr[k][i] != 0) {
							chk++;
						}
					}
					if(chk >= 2) return false;
					if(chk == 0) break;
					sum++;
					if(sum == 5) return true;
				}

			}

		}

		return false;
	}

	private static boolean threeKind() {
		for (int i = 1; i < 14; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				if(arr[j][i] != 0) cnt++;
			}

			if (cnt == 3)
				return true;
		}

		return false;
	}

	private static boolean twoPair() {
		int a = 0;
		int b = 0;
		for (int i = 1; i < 14; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				if(arr[j][i] != 0) cnt++;
			}
			if (cnt == 2) {
				if(a == 2) {
					b = 2;
				}else if (a != 2) {
					a = 2;
				}
			}
		}

		return a == 2 && b == 2 ? true : false;

	}

	private static boolean onePair() {
		for (int i = 1; i < 14; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				if(arr[j][i] != 0) cnt++;
			}
			if (cnt == 2) return true;
		}

		return false;
	}
}
