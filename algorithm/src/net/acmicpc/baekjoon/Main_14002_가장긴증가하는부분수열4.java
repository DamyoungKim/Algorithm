package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			List<Integer> temp = new ArrayList<>();
			temp.add(arr[i]);
			list.add(temp);
		}
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					List<Integer> temp = new ArrayList<>();
					temp.addAll(list.get(j));
					temp.add(arr[i]);
					list.remove(i);
					list.add(i, temp);
					LIS[i] = LIS[j] + 1;
				}
			}

			if (max < LIS[i]) {
				maxIndex = i;
				max = LIS[i];
			}
		}

		System.out.println(max);
		for (int i = 0; i < list.get(maxIndex).size(); i++) {
			System.out.print(list.get(maxIndex).get(i) + " ");
		}
	}

}
