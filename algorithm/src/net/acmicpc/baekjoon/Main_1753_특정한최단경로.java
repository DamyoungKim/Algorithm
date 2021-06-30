package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_특정한최단경로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<int[]>[] adj = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			adj[start].add(new int[] { end, val });
			adj[end].add(new int[] { start, val });
		}

		st = new StringTokenizer(br.readLine());
		int des1 = Integer.parseInt(st.nextToken());
		int des2 = Integer.parseInt(st.nextToken());
		int[] start = new int[] { 1, des1, des2 };

		int[][] distance = new int[3][N + 1];
		for (int loop = 0; loop < 3; loop++) {
			boolean[] visited = new boolean[N + 1];
			Arrays.fill(distance[loop], Integer.MAX_VALUE);
			distance[loop][start[loop]] = 0;

			for (int i = 1; i < N + 1; i++) {
				int min = Integer.MAX_VALUE;
				int current = 0;
				for (int j = 1; j < N + 1; j++) {
					if (!visited[j] && min > distance[loop][j]) {
						min = distance[loop][j];
						current = j;
					}
				}
				visited[current] = true;

				for (int j = 0; j < adj[current].size(); j++) {
					if (!visited[adj[current].get(j)[0]]
							&& distance[loop][adj[current].get(j)[0]] > min + adj[current].get(j)[1]) {
						distance[loop][adj[current].get(j)[0]] = min + adj[current].get(j)[1];
					}
				}
			}
		}
		int resultA = 0;
		int resultB = 0;
		if(distance[0][des1]!= Integer.MAX_VALUE && distance[1][des2] != Integer.MAX_VALUE && distance[2][N] != Integer.MAX_VALUE)
			resultA = distance[0][des1] + distance[1][des2] + distance[2][N];
		if(distance[0][des2]!= Integer.MAX_VALUE && distance[2][des1] != Integer.MAX_VALUE && distance[1][N] != Integer.MAX_VALUE)
			resultB = distance[0][des2] + distance[2][des1] + distance[1][N];
		
		if(resultA == 0 && resultB == 0) System.out.println(-1);
		else System.out.println(Math.min(resultA, resultB));
	}
}


