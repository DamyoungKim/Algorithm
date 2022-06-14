package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1911_트리순회 {
	static int N;
	static int[][] arr;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parents = st.nextToken().charAt(0);
			for (int j = 0; j < 2; j++) {
				int child = st.nextToken().charAt(0);
				if (child == '.') arr[parents - 'A'][j] = -1;
				else arr[parents - 'A'][j] = child - 'A';
			}
		}
		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);
		System.out.print(sb);
	}

	public static void preorder(int node) {
		if (node == -1) return;
		sb.append((char) (node + 'A'));
		preorder(arr[node][0]);
		preorder(arr[node][1]);
	}

	public static void inorder(int node) {
		if (node == -1) return;
		inorder(arr[node][0]);
		sb.append((char) (node + 'A'));
		inorder(arr[node][1]);
	}
	public static void postorder(int node) {
		if (node == -1) return;
		postorder(arr[node][0]);
		postorder(arr[node][1]);
		sb.append((char) (node + 'A'));
	}
}
