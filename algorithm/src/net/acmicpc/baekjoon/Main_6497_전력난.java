package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_6497_전력난 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0) break;
			ArrayList<int[]>[] adj = new ArrayList[n];
			int[] minEdge = new int[n];
			
			
			for(int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			
			int result = 0;
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y =  Integer.parseInt(st.nextToken());
				int z =  Integer.parseInt(st.nextToken());
				result += z;
				adj[x].add(new int[] {y, z});
				adj[y].add(new int[] {x, z});
			}
			
			minEdge[0] = 0;
			
			boolean visited[] = new boolean[n];
			for(int c = 0; c < n; c++) {
				int min = Integer.MAX_VALUE;
				int minVertex = 0;
				
				for(int i = 0; i < n; i++) {
					if(!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				
				result -= min;
				visited[minVertex] = true;
				
				for(int i = 0; i < adj[minVertex].size(); i++) {
					int temp[] = adj[minVertex].get(i);
					if(!visited[temp[0]] && minEdge[temp[0]] > temp[1]) {
						minEdge[temp[0]] = temp[1];
					}
				}
			}
			
			System.out.println(result);
			
		}
		
	}
}