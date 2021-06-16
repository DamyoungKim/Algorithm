package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_1613_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean[] alpha = null;

		int T = sc.nextInt();

		int result = 0;
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			boolean check = true;
			alpha = new boolean['z' - 'a' + 1];
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);

				if (!alpha[temp - 'a'])
					alpha[temp - 'a'] = true;

				else {
					if(s.charAt(i - 1) != temp) {
						check = false;
						break;
					}
				}
			}
			
			if(check) result++;
		}
		
		System.out.println(result);
	}

}