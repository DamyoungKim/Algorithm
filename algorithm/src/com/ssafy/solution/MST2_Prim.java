package com.ssafy.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * MST - prim : 정점을 중심으로 해결하는 알고리즘 (그래프 자료구조 : 인접행렬, 인접 리스트), N 개의 정점을 모두 고립되지
 * 않도록 연결, 가중치의합 최소
 * 
 */
public class MST2_Prim {

   public static void main(String[] args) throws Exception, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      int[][] adjMatrix = new int[N][N];
      boolean[] visited = new boolean[N];
      int[] minEdge = new int[N]; // 신장트리에 연결된 정점에서 자신으로의 최소간선비용

      StringTokenizer st = null;

      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            adjMatrix[i][j] = Integer.parseInt(st.nextToken());
         }
         minEdge[i] = Integer.MAX_VALUE;
      }

      int result = 0;
      minEdge[0] = 0; // 0을 시작정점으로 처리하기 위해 0세팅

      for (int c = 0; c < N; c++) {
         int min = Integer.MAX_VALUE;
         int minVertex = 0;
         // 신장트리에 연결되지 않은 정점중 minEdge비용이 최소인 정점
         for (int i = 0; i < N; i++) {
            if (!visited[i] && min > minEdge[i]) {
               min = minEdge[i];
               minVertex = i;
            }
         }

         result += min;
         visited[minVertex] = true;

         for (int i = 0; i < N; i++) {
            if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
               minEdge[i] = adjMatrix[minVertex][i];
            }
         }
      }

      System.out.println(result);

   }

}
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175

*/