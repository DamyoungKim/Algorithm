package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] box = new int[100];
		int result = 0;
		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			for (int i = 0; i < box.length; i++) {
				box[i] = sc.nextInt();
			}
			int count = 0;
			int min = box[0];
			int max = box[0];
			while (count <= dump) {
				count++;
				max = box[0];
				min = box[0];
				for (int j = 1; j < box.length; j++) {
					if (min > box[j])
						min = box[j];
					if (max < box[j])
						max = box[j];
				}
				if (max - min == 0) {
					result = 0;
					continue;
				}
				if (max - min == 1) {
					result = 1;
					continue;
				}
				for (int j = 0; j < box.length; j++) {
					if (box[j] == min) {
						box[j]++;
						break;
					}
				}
				for (int j = 0; j < box.length; j++) {
					if (box[j] == max) {
						box[j]--;
						break;
					}
				}
			}
			min = box[0];
			max = box[0];
			for (int j = 1; j < box.length; j++) {
				if (min > box[j])
					min = box[j];
				if (max < box[j])
					max = box[j];
			}
			result = max - min;
			System.out.println("#" + t + " " + result);
		}
	}
}
