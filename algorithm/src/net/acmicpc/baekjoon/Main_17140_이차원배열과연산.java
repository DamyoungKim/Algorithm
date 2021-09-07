package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	static int r, c, k, rowSize = 3, colSize = 3, max;
	static int[][] arr = new int[100][100];
	static int[] number = new int[101];
	static List<N> list = new ArrayList<>();
	static class N implements Comparable<N>{
		int val;
		int count;
		public N(int val, int count) {
			super();
			this.val = val;
			this.count = count;
		}
		@Override
		public int compareTo(N o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(arr[r][c] == k) {
			System.out.println(0);
			return;
		}

		for(int i = 1; i <= 100; i++) {
			max = 0;
			
			if (rowSize >= colSize) {
				calR();
				colSize = max;
			} else if (rowSize < colSize) {
				calC();
				rowSize = max;
			}
			if(arr[r][c] == k) {
				System.out.println(i);
				return;
			}
			
		}
		System.out.println(-1);
	}
	private static void calR() {
		for (int i = 0; i < rowSize; i++) {
			Arrays.fill(number, 0);
			for (int j = 0; j < colSize; j++) {
				number[arr[i][j]]++;
			}
			checkElement();
			setR(i);
		}
		
	}
	
	private static void calC() {
		for (int j = 0; j < colSize; j++) {
			Arrays.fill(number, 0);
			for (int i = 0; i < rowSize; i++) {
				number[arr[i][j]]++;
			}
			checkElement();
			setC(j);
		}
		
	}
	
	
	private static void checkElement() {
		list.clear();
		for(int i = 1; i < 101; i++) {
			if(number[i] == 0) continue;
			list.add(new N(i, number[i]));
		}
		Collections.sort(list);
	}
	
	private static void setR(int index) {
		int size = list.size() ;
		max = max > size * 2 ? max : size * 2;
		int range = size < 50 ? size : 50;
		int cnt = 0;
		for(int i = 0; i < range; i++) {
			arr[index][cnt++] = list.get(i).val;
			arr[index][cnt++] = list.get(i).count;
		}
		for(int i = cnt; i < 100; i++) {
			arr[index][i] = 0;
		}
	}
	
	private static void setC(int index) {
		int size = list.size();
		max = max > size * 2 ? max : size * 2;
		int range = size < 50 ? size : 50;
		int cnt = 0;
		for(int i = 0; i < range; i++) {
			arr[cnt++][index] = list.get(i).val;
			arr[cnt++][index] = list.get(i).count;
		}
		for(int i = cnt; i < 100; i++) {
			arr[i][index] = 0;
		}
	}
}
