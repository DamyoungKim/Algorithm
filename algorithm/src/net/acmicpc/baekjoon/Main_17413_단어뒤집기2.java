package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17413_단어뒤집기2 {

	static int N, C, result = Integer.MAX_VALUE;
	static int[] pop;
	static boolean[][] arr;
	static boolean[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N + 1][N + 1];
		pop = new int[N + 1];
		selected = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int loop = Integer.parseInt(st.nextToken());
			for(int j = 0; j < loop; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][temp] = true;
				arr[temp][i] = true;
			}
		}
		
		for(int i = 1; i < N; i++) {
			C = i;
			if(solve(0, 1)) break;
		}
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		
	}
	private static boolean solve(int cnt, int start) {
		if(cnt == C) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				if(selected[i]) A.add(i);
				else B.add(i);
			}
			
			int vertexA = A.get(0), vertexB = B.get(0);
			
			
			boolean[] visited = new boolean[N + 1];
			if(!connect(vertexA, A, visited)) return false;
			
			
			visited = new boolean[N + 1];
			if(!connect(vertexB, B, visited)) return false;
			
			int sumA = 0;
			for(int i = 0; i < A.size(); i++) {
				sumA += pop[A.get(i)];
			}
			
			int sumB = 0;
			for(int i = 0; i < B.size(); i++) {
				sumB += pop[B.get(i)];
			}
			int tempResult = Math.abs(sumA - sumB);
			
			result = result > tempResult ? tempResult : result;
			if(result == 0) return true;
			return false;
		}
		
		for(int i = start; i <= N; i++) {
			selected[i] = true;
			if(solve(cnt + 1, i + 1)) return true;
			selected[i] = false;
		}
		
		return false;
	}
	
	static boolean connect(int vertex, List<Integer> list, boolean[] visited) {
		visited[vertex] = true;
		for(int i = 0; i < list.size(); i++) {
			int tempVertex = list.get(i);
			if(visited[tempVertex]) continue;
			
			if(arr[vertex][tempVertex]) {
				if(connect(tempVertex, list, visited)) return true;
			}
			
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(visited[i]) cnt++;
		}
		
		if(cnt == list.size()) return true;
		return false;
	}

}