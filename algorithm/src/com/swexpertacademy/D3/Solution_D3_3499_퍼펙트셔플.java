package com.swexpertacademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> result = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list1.clear();
			list2.clear();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int Max = st.countTokens();
			for (int i = 0; i < Max; i++) {
				if (Max % 2 == 0) {
					if (i < Max / 2) {
						list1.add(st.nextToken());
					} else {
						list2.add(st.nextToken());
					}

				} else {
					if (i <= Max / 2) {
						list1.add(st.nextToken());
					} else {
						list2.add(st.nextToken());
					}
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < list1.size(); i++) {
				System.out.print(list1.get(i) + " ");
				if (list1.size() != list2.size()) {
					if (i < list1.size() - 1)
						System.out.print(list2.get(i) + " ");
				} else {
					System.out.print(list2.get(i) + " ");
				}
			}
			System.out.println();
		}
	}
}
