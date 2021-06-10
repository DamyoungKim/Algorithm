package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2628_종이자르기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();

		int M = sc.nextInt();
		int N = sc.nextInt();
		int T = sc.nextInt();
		row.add(0);
		col.add(0);
		for (int t = 0; t < T; t++) {
			int mode = sc.nextInt();
			int pos = sc.nextInt();

			if (mode == 0) {
				row.add(pos);
			} else {
				col.add(pos);
			}
		}
		col.add(M);
		row.add(N);
		Collections.sort(row);
		Collections.sort(col);
		
		int n = (row.size() - 1) * (col.size() -1);
		
		int[] arr = new int[n];

		int cnt = 0;
		for(int i = 1; i < row.size(); i++) {
			for(int j = 1; j < col.size(); j++) {
				int x = row.get(i) - row.get(i - 1) ;
				int y = col.get(j) - col.get(j - 1) ;
				arr[cnt] = x * y;
				cnt++;
			}
		}
	
		Arrays.sort(arr);
		System.out.println(arr[cnt - 1]);
	}

}
