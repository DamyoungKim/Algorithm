package net.acmicpc.baekjoon;
import java.util.*;
public class Main_2089_마이너스2진수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		if (N == 0) {
			System.out.println(0);
			return;
		}
		while (N != 1) {
			int divN = N / -2;
			int modN = N % -2;
			if (N > 0) {
				N = divN;
				sb.append(modN);
			} else if (N < 0) {
				if (modN == 0) {
					N = divN;
					sb.append(modN);
				} else {
					N = divN + 1;
					sb.append(1);
				}
			} 
		}
		sb.append(1);
		System.out.println(sb.reverse());
	}
}
