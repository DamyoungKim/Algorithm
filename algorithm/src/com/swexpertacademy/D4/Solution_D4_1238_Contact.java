package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact {
	static int start;
	static int[][] arr;
	static boolean[] check;
	static int result;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int max;
	static List<int[]> ends = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			arr = new int[101][101];
			check = new boolean[101];
			ends.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;

			}
			q.offer(start);
			check[start] = true;
			result = 0;
			max = 0;
			bfs();
			
			for(int i = 0; i < 101; i++) {
					if(arr[i][0] == max) 
						result = result > i ? result : i;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs() {
		int size = q.size();
		int cnt = 0;
		while (!q.isEmpty()) {
			if(cnt == size) {
				cnt = 0;
				size = q.size();
				max++;
			}
			boolean end = true;
			cnt++;
			int from = q.poll();
			for (int i = 1; i < 101; i++) {
				if (arr[from][i] != 0) {
					if (check[i])
						continue;
					check[i] = true;
					end = false;
					q.offer(i);
				}
			}
			if(end) {
				arr[from][0] = max;
			}
		}
	}
}
