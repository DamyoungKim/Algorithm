package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {
   static int N, K;
   static int[] arr;
   static boolean[] isExist;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      arr = new int[N * 2];
      isExist = new boolean[N];
      for(int i = 0; i < N * 2; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }
      int result = 0;
      while(true) {
         result++;
         moveBelt();
         moveRobot();
         putRobot();
         if(checkEnd()) {
            System.out.println(result);
            return;
         }
      }
   }
   
   
   
   private static void moveBelt() {
      int temp = arr[2 * N - 1];
      for(int i = 2 * N - 1; i > 0; i--) {
         arr[i] = arr[i - 1];
      }
      arr[0] = temp;
      for(int i = N - 1; i > 0; i--) {
         isExist[i] = isExist[i - 1];
      }
      isExist[N - 1] = false;
      isExist[0] = false;

   }
   
   private static void moveRobot() {
      for(int i = N - 2; i > 0; i--) {
         if(!isExist[i]) continue;
         if(isExist[i + 1] || arr[i + 1] <= 0) continue;
         isExist[i] = false;
         arr[i + 1]--;
         isExist[i + 1] = true;
      }
      isExist[N - 1] = false;
   }
   
   private static void putRobot() {
      if(arr[0] > 0) {
         arr[0]--;
         isExist[0] = true;
      }
   }
   
   private static boolean checkEnd() {
      int cnt = 0;
      for(int i = 0; i < N * 2; i++) {
         if(arr[i] <= 0) cnt++;
         if(cnt == K) return true;
      }
      return false;
   }
}