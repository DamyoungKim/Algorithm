package kr.co.jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1205_조커 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];
		int zeroCnt = 0;
		for (int t = 0; t < T; t++) {
			arr[t] = sc.nextInt();
			if (arr[t] == 0)
				zeroCnt++;
		}

		Arrays.sort(arr);
		int result = 0;
		if (zeroCnt == 0) {
			for (int i = 0; i < T - 1; i++) {
				int temp = 1;
				while (i + 1 < T && arr[i] + 1 == arr[i + 1] || arr[i] == arr[i + 1]) {
					if (arr[i] == arr[i + 1]) {
						i++;
						continue;
					}
					i++;
					temp++;
				}
				result = Math.max(temp, result);

			}
			System.out.println(result);
			return;
		} else {
			for (int i = zeroCnt; i < T - 1; i++) {
				int temp = 1;
				int I = i;
				while (I + 1 < T && arr[I] + 1 == arr[I + 1]) {
					I++;
					temp++;
				}
				int j = 0;
				int max = zeroCnt;
				while (I + 1 < T && max > j) {
					j++;
					if (arr[I] + 1 + j == arr[I + 1]) {
						I++;
						temp++;
						while (I + 1 < T && arr[I] + 1 == arr[I + 1]) {
							I++;
							temp++;
						}
						j--;
						max--;
					}
				}
				result = Math.max(temp, result);
			}
			System.out.println(result + zeroCnt);
		}

	}
}
