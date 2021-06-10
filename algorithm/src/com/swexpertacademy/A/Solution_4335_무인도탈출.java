package com.swexpertacademy.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_4335_무인도탈출 {
	static class Box {
		int w;
		int l;
		int h;
		public Box(int w, int l, int h) {
			super();
			this.w = w;
			this.l = l;
			this.h = h;
		}
	}
	static int n;
	static List<Box> list;
	static boolean[] selected;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			n = sc.nextInt();
			list = new ArrayList<>();
			selected = new boolean[n];
			for(int i = 0; i < n; i++) {
				list.add(new Box(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			
		}
		
	}

}
