package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13913_숨바꼭질4 {
	static int N, K, result;
	static boolean[] visited = new boolean[100001];
	static Queue<ArrayList<Integer>> q = new LinkedList<>();
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		if(N > K) {
			sb.append(N - K);
			sb.append('\n');
			for(int i = N; i >= K; i--) {
				sb.append(i);
				sb.append(" ");
			}
			System.out.println(sb);
		}else {
			bfs();
		}
	}

	private static void bfs() {
		visited[N] = true;
		ArrayList<Integer> tempList = new ArrayList<>();
		tempList.add(N);
		q.offer(tempList);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				ArrayList<Integer> list = q.poll();
				int listSize = list.size();
				int pos = list.get(list.size() - 1);
				if (pos == K) {
					
					sb.append(result);
					sb.append('\n');
					for (int i = 0; i < listSize; i++) {
						sb.append(list.get(i));
						sb.append(" ");
					}
					System.out.println(sb);
					return;
				}
				
				if(pos * 2 <= 100000 && !visited[pos * 2]) {
					visited[pos * 2] = true;
					tempList = new ArrayList<>();
					for(int i = 0; i < listSize; i++) {
						tempList.add(list.get(i));
					}
					tempList.add(pos * 2);
					q.offer(tempList);
				}
				
				if(pos + 1 <= 100000 && !visited[pos + 1]) {
					visited[pos + 1] = true;
					tempList = new ArrayList<>();
					for(int i = 0; i < listSize; i++) {
						tempList.add(list.get(i));
					}
					tempList.add(pos + 1);
					q.offer(tempList);
				}
				
				if(pos - 1 >= 0 && !visited[pos - 1]) {
					visited[pos - 1] = true;
					tempList = new ArrayList<>();
					for(int i = 0; i < listSize; i++) {
						tempList.add(list.get(i));
					}
					tempList.add(pos - 1);
					q.offer(tempList);
				}
			}
			result++;

		}

	}

}
