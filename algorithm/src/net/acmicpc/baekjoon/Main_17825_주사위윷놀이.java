package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_17825_주사위윷놀이 {
	static int max;
	static class Node {
		boolean used;
		boolean pass25;
		int cur = 0;
		boolean end;
		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if(this.end || node.end) return false;
			if (this.cur == 40 && node.cur == 40) return true;
			if (this.used == node.used && this.cur == node.cur) {
				if (this.cur == 30 && node.cur == 30) {
					if(this.pass25 != node.pass25) return false;
				}
				return true;
			}
			return false;
		}
		

	}

	static int[] pass, selected, arr;
	static List<Node> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		pass = new int[41];
		selected = new int[10];
		pass[10] = 13;
		pass[13] = 16;
		pass[16] = 19;
		pass[19] = 25;
		pass[20] = 22;
		pass[22] = 24;
		pass[24] = 25;
		pass[28] = 27;
		pass[27] = 26;
		pass[26] = 25;
		pass[25] = 30;
		pass[30] = 35;
		pass[35] = 40;
		pass[40] = 42;
		max = 0;
		permu(0);
		System.out.println(max);
	}

	private static void permu(int cnt) {
		if (cnt == 10) {
			list = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				list.add(new Node());
			}
			int sum = solve();
			
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			selected[cnt] = i;
			permu(cnt + 1);
		}
	}

	private static int solve() {
		int result = 0;
		for (int i = 0; i < 10; i++) {
			Node node = list.get(selected[i]);
			if (node.end) return 0;
			if (!node.used) {
				for (int j = 0; j < arr[i]; j++) {
					node.cur += 2;
				}
				if (node.cur == 10 || node.cur == 20 || node.cur == 30) {
					node.used = true;
				}
				if (node.cur >= 42) {
					node.end = true;
				}
			} else {
				for (int j = 0; j < arr[i]; j++) {
					if (node.cur == 30 && !node.pass25) {
						node.cur = 28;
						continue;
					}
					int next = pass[node.cur];
					node.cur = next;
					if (next == 42) {
						node.end = true;
						break;
					}
					if (node.cur == 25) node.pass25 = true;
				}
			}
			
			for (int j = 0; j < 4; j++) {
				if (selected[i] == j) continue;
				if (list.get(j).equals(node)) {
					return 0;
				}
			}
			
			if (!node.end) {
				result += node.cur;
			}
		}
		return result;
	}

}
