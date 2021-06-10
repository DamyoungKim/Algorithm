package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int[] arr;
	static int[] numbers;
	static boolean[] isSelected;
	static int in, gue,inWin, gueWin;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			arr = new int[9];
			isSelected = new boolean[19];
			numbers = new int[9];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				isSelected[arr[i]] = true;
			}
			c(0);
			System.out.println("#" + t + " " + gueWin + " " + inWin);
			gueWin = 0;
			inWin = 0;
		}
	}

	private static void c(int cnt) {
		if(cnt == 9) {
			in = 0;
			gue = 0;
			for(int i = 0; i < 9; i++) {
				if(arr[i] > numbers[i]) gue += (arr[i] + numbers[i]);
				if(arr[i] < numbers[i]) in += (arr[i] + numbers[i]);
			}
			if(gue > in) gueWin++;
			if(gue < in) inWin++;
			return;
		}
	
			for (int i = 1; i < isSelected.length; i++) {
				if (isSelected[i])
					continue;
				numbers[cnt] = i;
				isSelected[i] = true;
				c(cnt + 1);
				isSelected[i] = false;
			}
	}
}
