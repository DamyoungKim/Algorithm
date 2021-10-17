package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호 {
	static int T, N, K;
	static char[][] arr;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			String s = br.readLine();

			arr = new char[4][N / 4];
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N / 4; j++) {
					arr[i][j] = s.charAt(cnt++);
				}
			}
			for (int i = 0; i < N / 4; i++) {
				solve(0, 1, arr[0][0]);
				for (int j = 0; j < 4; j++) {
					int deceimal = charToDec(arr[j]);
					if(!checkExsist(deceimal)) {
						list.add(deceimal);
					}
				}
			}
			
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			System.out.println("#" + t + " " + list.get(K - 1));
		}
	}

	private static boolean checkExsist(int deceimal) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == deceimal) {
				return true;
			}
		}
		return false;
	}

	private static void solve(int y, int x, char pre) {
		if (x == N / 4) {
			if (y == 3) {
				arr[0][0] = pre;
			} else {
				solve(y + 1, 0, pre);
			}
			return;
		}
		char cur = arr[y][x];
		arr[y][x] = pre;
		solve(y, x + 1, cur);
	}
	
	private static int charToDec (char[] charArr) {
		int result = 0;
		for (int i = 0; i < charArr.length; i++) {
			char temp = charArr[i];
			int offset = 0;
			if ('A' <= temp && temp <= 'F') {
				offset = temp - 'A' + 10;
			} else {
				offset = temp - '0';
			}
			result += (Math.pow(16, charArr.length - 1 - i) * offset);
		}
		
		return result;
	}
}
