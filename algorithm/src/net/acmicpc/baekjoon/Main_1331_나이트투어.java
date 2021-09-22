package net.acmicpc.baekjoon;

import java.io.*;
import java.util.*;

public class Main_1331_나이트투어 {
	static class Node {
		int y;
		int x;

		public Node(int x, int y) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2 }, dy = { -2, -2, -1, 1, 2, 2, 1, -1 };
		boolean[][] visited = new boolean[6][6];
		String[] arr = new String[36];
		String result = "Valid";
		for (int i = 0; i < 36; i++) {
			arr[i] = br.readLine();
		}
		Node start = new Node(arr[0].charAt(0) - 'A', 5 - (arr[0].charAt(1) - '1'));
		Node cur = start;
		Node end = new Node(arr[35].charAt(0) - 'A', 5 - (arr[35].charAt(1) - '1'));
		boolean check = false;
		for (int i = 0; i < 35; i++) {
			Node next = new Node(arr[i + 1].charAt(0) - 'A', 5 - (arr[i + 1].charAt(1) - '1'));
			check = false;
			for (int j = 0; j < 8; j++) {
				if (cur.y + dy[j] == next.y && cur.x + dx[j] == next.x && !visited[next.y][next.x]) {
					check = true;
					visited[cur.y][cur.x] = true;
					visited[next.y][next.x] = true;
					break;
				}
			}
			if (!check) {
				result = "Invalid";
				break;
			}
			cur = next;
		}
		if (result.equals("Valid")) {
			check = false;
			for (int i = 0; i < 8; i++) {
				if (end.y + dy[i] == start.y && end.x + dx[i] == start.x) {
					check = true;
					break;
				}
			}
			if(!check) result = "Invalid"; 
		}
		if (result.equals("Valid")) {
			check = true;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j]) {
						check = false;
						result = "Invalid";
						break;
					}
				}
				if (!check)
					break;
			}
		}
		System.out.println(result);
	}

}
