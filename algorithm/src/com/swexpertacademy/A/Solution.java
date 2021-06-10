package com.swexpertacademy.A;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cancer {
	int[] index;
	int x1;
	int y1;
	int x2;
	int y2;

	public Cancer(int[] index) {
		super();
		this.index = index;
	}
}

public class Solution {
	static List<Cancer> cancerList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				cancerList.add(new Cancer(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() }));
			}
		}
		boolean[] isSelected = new boolean[4];
		int[] numbers = new int[4];
		p(0, 0, isSelected, numbers);
	}

	private static void p(int index, int cnt, boolean[] checked, int[] numbers) {
		if (index == cancerList.size()) {
			return;
		}
		if (cnt == 4) {
			
			
			
			int x1 = cancerList.get(index).x1 = numbers[0];
			int y1 = cancerList.get(index).y1 = numbers[1];
			int x2 = cancerList.get(index).x2 = numbers[2];
			int y2 = cancerList.get(index).y2 = numbers[3];
			
			if(x1 == x2 && y1 == y2) {
				return;
			}
			if(Math.abs(x1 - x2) * Math.abs(y1 - y2) == 0) {
				return;
			}
			
			p(index + 1, 0, new boolean[4], new int[4]);
			
			
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (checked[i])
				continue;
			checked[i] = true;
			numbers[cnt] = cancerList.get(index).index[i];
			p(index, cnt + 1, checked, numbers);
			checked[i] = false;
		}
	}

}
