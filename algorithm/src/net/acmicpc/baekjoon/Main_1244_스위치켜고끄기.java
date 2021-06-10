package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] sw = new boolean[T];
		for (int t = 0; t < T; t++) {
			if (sc.nextInt() == 1)
				sw[t] = true;
			else
				sw[t] = false;
		}
		int stu = sc.nextInt();
		for (int i = 0; i < stu; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			switch (gender) {
			case 1:
				for (int j = 1; j < T + 1; j++) {
					if (j % num == 0) {
						sw[j - 1] = !sw[j - 1];
					}
				}
				break;
			case 2:
				int j = 0;
				while (num - 1 - j >= 0 && num - 1 + j < T && sw[num - 1 - j] == sw[num - 1 + j]) {
					if (j == 0) {
						sw[num - 1] = !sw[num - 1];
						j++;
						continue;
					}
					sw[num - 1 - j] = !sw[num - 1 - j];
					sw[num - 1 + j] = !sw[num - 1 + j];
					j++;
				}

				break;
			}
		}
		for (

				int i = 0; i < sw.length; i++) {
			if ((i + 1) % 20 != 0) {
				if (i == sw.length - 1) {
					if (sw[i])
						System.out.print(1);
					else
						System.out.print(0);
				} else {
					if (sw[i])
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				}
			} else {
				if (sw[i])
					System.out.print(1 + "\n");
				else
					System.out.print(0 + "\n");
			}
		}
	}
}
