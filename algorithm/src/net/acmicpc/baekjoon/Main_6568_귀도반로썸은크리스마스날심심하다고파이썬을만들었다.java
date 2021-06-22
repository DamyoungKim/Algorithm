package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_6568_귀도반로썸은크리스마스날심심하다고파이썬을만들었다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int adder = 0;
		boolean end = false;
		int[] commands = new int[32];
		while (sc.hasNext()) {
			adder = 0;
			count = 0;
			for (int i = 0; i < 32; i++) {
				commands[i] = Integer.parseInt(sc.next(), 2);
			}
			while (true) {
				int command = commands[count] / 32;
				int address = commands[count] % 32;
				count++; // 명령 시작 전 PC + 1
				if(count == 32) count = 0; 
				switch (command) {
				case 0:
					commands[address] = adder;
					break;
				case 1:
					adder = commands[address];
					break;
				case 2:
					if (adder == 0)
						count = address;
					break;
				case 3:
					break;
				case 4:
					adder--;
					if(adder < 0) adder = (int) Math.pow(2, 8) - 1;
					break;
				case 5:
					adder++;
					if (adder == Math.pow(2, 8))
						adder = 0;
					break;
				case 6:
					count = address;
					break;
				case 7:
					end = true;
					break;
				}
				
				if(end) {
					print(adder);
					end = false;
					break;
				}
			}
		}
	}

	private static int toInt(String s) {
		return (s.charAt(4) - '0') + (s.charAt(3) - '0') * 2 + (s.charAt(2) - '0') * 4 + (s.charAt(1) - '0') * 8
				+ (s.charAt(0) - '0') * 16;
	}

	private static void print(int adder) {
		StringBuffer sb = new StringBuffer();
		String s = Integer.toBinaryString(adder);
		for(int i = 0; i < 8 - s.length(); i++) {
			sb.append("0");
		}
		sb.append(s);
		System.out.println(sb);
	}
}