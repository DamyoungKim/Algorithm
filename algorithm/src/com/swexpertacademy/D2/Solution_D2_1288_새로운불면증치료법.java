package com.swexpertacademy.D2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution_D2_1288_새로운불면증치료법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> list = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;
		for (int t = 1; t <= T; t++) {
			int number = sc.nextInt();
			int[] iVal = null;
			int n = 0;
			list.clear();
			while (list.size() != 10) {
				n++;
				result = number * n;
				String sresult = Integer.toString(result);
				iVal = new int[sresult.length()];
				for (int i = 0; i < iVal.length; i++) {
					iVal[i] = sresult.charAt(i) - (int) '0';
					list.add(iVal[i]);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
