package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2290_LCDTest {
	static int s;
	static List<int[][]> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		String n = sc.next();

		for (int i = 0; i < 10; i++) {
			list.add(makeLCD(i));
		}
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 2 * s + 3; i++) {
			for (int k = 0; k < n.length(); k++) {
				int[][] arr = list.get(n.charAt(k) - '0');
				for (int j = 0; j < s + 2; j++) {
					if(arr[i][j] == 0) {
						sb.append(" ");
					}else if(arr[i][j] == 1) {
						sb.append("-");
					}else if(arr[i][j] == -1)  {
						sb.append("|");
					}
				}
				sb.append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	private static int[][] makeLCD(int N) {
		int temp[][] = new int[2 * s + 3][s + 2];
		for (int i = 0; i < 2 * s + 3; i++) {
			for (int j = 0; j < s + 2; j++) {
				switch (N) {

				case 1:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1)
						continue;
					if (j == s + 2 - 1) {
						temp[i][j] = -1;
					}
					break;
				case 2:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (i <= s && j == s + 2 - 1)
							temp[i][j] = -1;
						else if (i > s && j == 0)
							temp[i][j] = -1;
					}
					break;
				case 3:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (j == s + 2 - 1)
							temp[i][j] = -1;
					}
					break;
				case 4:
					if (i == 0 || i == 2 * s + 3 - 1)
						continue;
					if (i == s + 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (i <= s) {
							if (j == 0 || j == s + 2 - 1)
								temp[i][j] = -1;
						} else {
							if (j == s + 2 - 1)
								temp[i][j] = -1;
						}
					}
					break;
				case 5:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (i <= s && j == 0)
							temp[i][j] = -1;
						else if (i > s && j == s + 2 - 1)
							temp[i][j] = -1;
					}
					break;
				case 6:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (i <= s) {
							if (j == 0)
								temp[i][j] = -1;
						} else {
							if (j == 0 || j == s + 2 - 1)
								temp[i][j] = -1;
						}
					}
					break;
				case 7:
					if (i == s + 1 || i == 2 * s + 3 - 1)
						continue;
					if (i == 0) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (j == s + 2 - 1) {
							temp[i][j] = -1;
						}
					}
					break;
				case 8:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (j == 0 || j == s + 2 - 1)
							temp[i][j] = -1;
					}
					break;
				case 9:
					if (i == 0 || i == s + 1 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (i <= s) {
							if (j == 0 || j == s + 2 - 1)
								temp[i][j] = -1;
						} else {
							if (j == s + 2 - 1)
								temp[i][j] = -1;
						}
					}
					break;
				case 0:
					if (i == 0 || i == 2 * s + 3 - 1) {
						if (j == 0 || j == s + 2 - 1)
							continue;
						temp[i][j] = 1;
					} else {
						if (i == s + 1)
							continue;
						if (j == 0 || j == s + 2 - 1)
							temp[i][j] = -1;
					}
					break;
				}
			}
		}
		return temp;
	}
}
