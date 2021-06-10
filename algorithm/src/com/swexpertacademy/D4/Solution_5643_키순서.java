package com.swexpertacademy.D4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5643_키순서 {
	static int N, M, cnt, answer;
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer>[][] result;
	static int[] check;
	static boolean[] visited;
	static int[] memo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			M = sc.nextInt();

			arr = new ArrayList[N + 1];
			visited =  new boolean[N + 1];
			check = new int[N + 1];
			memo = new int[N + 1];
			result = new ArrayList[N + 1][2];
			for (int i = 1; i <= N; i++) {
				arr[i] = new ArrayList<>();
				for(int j = 0; j < 2; j++) {
					result[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a].add(b);
			}

			for (int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				bfs(i, 1);
			}
			
			for(int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				cnt = 0;
				dfs(i, 0);
				dfs(i, 1);
				check[i] = cnt;
			}
			answer = 0;
			for(int i = 1; i <= N; i++) {
				if(check[i] + 1 == N) answer++;
			} 
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int row, int index) {
		for(int i = 0; i < result[row][index].size(); i++) {
			int temp = result[row][index].get(i);
			if(visited[temp]) continue;
			cnt++;
			visited[temp] = true;
			dfs(temp, index);
		}
		
	}
	private static void bfs(int row, int order) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(row);
		visited[row] = true;
		while(!q.isEmpty()) {
			int r = q.poll();
			for(int i = 0; i < arr[r].size(); i++) {
				int t = arr[r].get(i);
				result[t][1].add(r);// 다음 것 보다 작은값이 있다
				result[r][0].add(t);//  현재 값보다 큰 것이 존재
				if(visited[t]) continue;
				q.offer(t);
				visited[t] = true;
			}
		}
	}
}

/*
 * 
1      
7     
7
7 3
1 5    
3 4    
5 4
4 2
4 6
5 2


1      
6
6
1 5    
3 4    
5 4
4 2
4 6
5 2

1      
6
5
1 5       
5 4
4 2
4 6
5 2
 */



