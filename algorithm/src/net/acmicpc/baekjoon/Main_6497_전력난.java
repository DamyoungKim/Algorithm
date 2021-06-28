package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_6497_전력난 { // Prim
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) // 종료 조건
				break;
			ArrayList<int[]>[] adj = new ArrayList[n]; // 인접 리스트 
			int[] minEdge = new int[n];

			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
				minEdge[i] = Integer.MAX_VALUE;
			}

			int result = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				result += z; // 문제에서 절약할 수 있는 최대 액수라 하였기 때문에 불을 모두 켰을 때의 값이 필요
				adj[x].add(new int[] { y, z });
				adj[y].add(new int[] { x, z });
			}

			minEdge[0] = 0;

			boolean visited[] = new boolean[n];
			for (int c = 0; c < n; c++) {
				int min = Integer.MAX_VALUE;
				int minVertex = 0;

				for (int i = 0; i < n; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}

				result -= min; // 최소 비용(최소 거리) 값을 빼줌 --> 절약한 비용
				visited[minVertex] = true;

				for (int i = 0; i < adj[minVertex].size(); i++) {
					int temp[] = adj[minVertex].get(i);
					if (!visited[temp[0]] && minEdge[temp[0]] > temp[1]) {
						minEdge[temp[0]] = temp[1];
					}
				}
			}

			System.out.println(result);

		}

	}
}