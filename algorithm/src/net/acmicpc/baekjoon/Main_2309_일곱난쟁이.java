package net.acmicpc.baekjoon;
import java.util.*;
public class Main_2309_일곱난쟁이 {
	static int[] arr = new int[9];
	static int[] selected = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		solve(0, 0);
	}
	private static boolean solve(int start, int cnt) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}
			if (sum == 100)  {
				Arrays.sort(selected);
				for (int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
				}
				return true;
			}
			return false;
		}
		
		for (int i = start; i < 9; i++) {
			selected[cnt] = arr[i];
			if(solve(i + 1, cnt + 1)) return true;
		}
		return false;
	}

}
