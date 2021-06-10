package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static  Queue<int[]> q = new LinkedList<>();
	   static int N, M, result = Integer.MAX_VALUE;
	   static int[][] arr;
	   static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	   public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      N = Integer.parseInt(st.nextToken());
	      M = Integer.parseInt(st.nextToken());
	      arr = new int[N][M];
	      int ry = 0, rx = 0, by = 0, bx = 0;
	      for(int i = 0; i < N; i++) {
	         String s = br.readLine();
	         for(int j = 0; j < M; j++) {
	            arr[i][j] = s.charAt(j);
	            if(arr[i][j] == 'B') {
	               by = i;
	               bx = j;
	            }
	            if(arr[i][j] == 'R') {
	               ry = i;
	               rx = j;
	            }
	         }
	      }
	      
	     q.offer(new int[] {ry, rx, by, bx, 1});
//	      solve2(ry, rx, by, bx, 1, arr);
	      
//	      System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	     
	     System.out.println(bfs() ? result : -1);
	      
	   }
	   private static void solve2(int ry, int rx, int by, int bx, int count, int[][] map) {
		   if(count == 11 ) {
			   
			   return;
		   }
		   
		   
		     List<int[][]> tempR = null;
		     List<int[][]> tempB = null;
		      
		      for(int i = 0; i < 4; i++) {
		    	  if(i == 0) {
		    		  if(ry < by) {
		    		         tempR = moveR(ry, rx, 0, map);
		    		         tempB = moveB(by, bx, 0, tempR.get(1));
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempB.get(1));
		    		      }else {
		    		         tempB = moveB(by, bx, 0, map);
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         tempR = moveR(ry, rx, 0, tempB.get(1));
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempR.get(1));
		    		      }
		    	  } else if ( i == 1) {
		    		  if(rx > bx) {
		    		         tempR = moveR(ry, rx, 1, map);
		    		         tempB = moveB(by, bx, 1, tempR.get(1));
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempB.get(1));
		    		      }else {
		    		         tempB = moveB(by, bx, 1, map);
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         tempR = moveR(ry, rx, 1, tempB.get(1));
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempR.get(1));
		    		      }
		    	  } else if ( i == 2) {
		    		  if(ry > by) {
		    		         tempR = moveR(ry, rx, 2, map);
		    		         tempB = moveB(by, bx, 2, tempR.get(1));
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempB.get(1));
		    		      }else {
		    		         tempB = moveB(by, bx, 2, map);
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         tempR = moveR(ry, rx, 2, tempB.get(1));
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempR.get(1));
		    		      }
		    		  
		    	  } else if (i == 3 ) {
		    		  if(rx < bx) {
		    		         tempR = moveR(ry, rx, 3, map);
		    		         tempB = moveB(by, bx, 3, tempR.get(1));
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempB.get(1));
		    		      }else {
		    		         tempB = moveB(by, bx, 3, map);
		    		         if(tempB.get(0)[0][0] == -1) continue;
		    		         tempR = moveR(ry, rx, 3, tempB.get(1));
		    		         if(tempR.get(0)[0][0] == -1) {
		    		            result = result > count ? count : result;
		    		            continue;
		    		         }
		    		         solve2(tempR.get(0)[0][0], tempR.get(0)[0][1], tempB.get(0)[0][0], tempB.get(0)[0][1], count + 1, tempR.get(1));
		    		      }
		    		  
		    		  
		    	  }
		    	  
		      }
		      
	   }
	   
		   public static boolean  bfs() {
			   while(!q.isEmpty()) {
				   int[] temp = q.poll();
				   int ry = temp[0];
				   int rx = temp[1];
				   int by = temp[2];
				   int bx = temp[3];
				   int count = temp[4];
				   
				   if(count == 11) return false;
				  
				   for(int i = 0; i < 4; i++) {
					   int[] tempR = null;
					   int[] tempB = null;
					   if(i == 0) {
				    		  if(ry < by) {
				    		         tempR = moveR2(ry, rx, by, bx, i);
				    		         tempB = moveB2(tempR[0], tempR[1], by, bx, i);
				    		         if(tempB[0] == -1) continue;
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
				    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }else {
				    		    	  tempB = moveB2(ry, rx, by, bx, i);
				    		    	  if(tempB[0] == -1) continue;
				    		         tempR = moveR2(ry, rx, tempB[0], tempB[1], i);
				    		         if(tempR[0] == -1l) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
					    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }
				    	  } else if ( i == 1) {
				    		  if(rx > bx) {
				    		         tempR = moveR2(ry, rx, by, bx, i);
				    		         tempB = moveB2(tempR[0], tempR[1], by, bx, i);
				    		         if(tempB[0] == -1) continue;
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
				    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1],  count + 1});
				    		      }else {
				    		    	  tempB = moveB2(ry, rx, by, bx, i);
				    		    	  if(tempB[0] == -1) continue;
					    		         tempR = moveR2(ry, rx, tempB[0], tempB[1], i);
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
					    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }
				    	  } else if ( i == 2) {
				    		  if(ry > by) {
				    		         tempR = moveR2(ry, rx, by, bx, i);
				    		         tempB = moveB2(tempR[0], tempR[1], by, bx, i);
				    		         if(tempB[0] == -1) continue;
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
				    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }else {
				    		    	  tempB = moveB2(ry, rx, by, bx, i);
				    		    	  if(tempB[0] == -1) continue;
					    		         tempR = moveR2(ry, rx, tempB[0], tempB[1], i);
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
					    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }
				    	  } else if (i == 3) {
				    		  if(rx < bx) {
				    		         tempR = moveR2(ry, rx, by, bx, i);
				    		         tempB = moveB2(tempR[0], tempR[1], by, bx, i);
				    		         if(tempB[0] == -1) continue;
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
				    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }else {
				    		    	  tempB = moveB2(ry, rx, by, bx, i);
				    		    	  if(tempB[0] == -1) continue;
					    		         tempR = moveR2(ry, rx, tempB[0], tempB[1], i);
				    		         if(tempR[0] == -1) {
//					    		            result = result > count ? count : result;
				    		        	 	result = count;
					    		            return true;
					    		         }
				    		         q.offer(new int[] {tempR[0], tempR[1], tempB[0], tempB[1], count + 1});
				    		      }
				    	  }
				   }
			   }
			   return false;
		   }
		   
	   private static List<int[][]> moveR(int ry, int rx, int dir, int[][] map) {
	      int ny = ry;
	      int nx = rx;
	      int[][] tempMap = new int[N][M];
	      for(int i = 0; i < N; i++) {
	         for (int j = 0; j < M; j++) {
	            tempMap[i][j] = map[i][j];
	         }
	      }
	      List<int[][]> list = new ArrayList<>();
	      while(true) {
	         ny += dy[dir];
	         nx += dx[dir];
	         if(ny >= N || nx >= M || ny < 0 || nx < 0 || map[ny][nx] == '#' || map[ny][nx] == 'B') {
	            list.add(new int[][] {{ny - dy[dir], nx - dx[dir]}});
	            list.add(tempMap);
	            return list;
	         }
	         if(map[ny][nx] == 'O') {
	            tempMap[ny - dy[dir]][nx - dx[dir]] = '.';   
	            list.add(new int[][] {{-1, -1}});
	            list.add(tempMap);
	            return list;
	         }
	         
	         tempMap[ny][nx] = 'R';
	         tempMap[ny - dy[dir]][nx - dx[dir]] = '.';   
	         
	         
	      }
	   }
	   
	   private static List<int[][]> moveB(int ry, int rx, int dir, int[][] map) {
	      int ny = ry;
	      int nx = rx;
	      int[][] tempMap = new int[N][M];
	      for(int i = 0; i < N; i++) {
	         for (int j = 0; j < M; j++) {
	            tempMap[i][j] = map[i][j];
	         }
	      }
	      List<int[][]> list = new ArrayList<>();
	      while(true) {
	         ny += dy[dir];
	         nx += dx[dir];
	         if(ny >= N || nx >= M || ny < 0 || nx < 0 || map[ny][nx] == '#' || map[ny][nx] == 'R') {
	            list.add(new int[][] {{ny - dy[dir], nx - dx[dir]}});
	            list.add(tempMap);
	            return list;
	         }
	         if(map[ny][nx] == 'O') {
	            tempMap[ny - dy[dir]][nx - dx[dir]] = '.';   
	            list.add(new int[][] {{-1, -1}});
	            list.add(tempMap);
	            return list;
	         }
	         
	         tempMap[ny][nx] = 'B';
	         tempMap[ny - dy[dir]][nx - dx[dir]] = '.';   
	         
	         
	      }
	   }
	   
	   private static int[] moveR2(int ry, int rx, int by, int bx, int dir) {
		      int ny = ry;
		      int nx = rx;
		      while(true) {
		         ny += dy[dir];
		         nx += dx[dir];
		         if(ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == '#' || (ny == by  && nx == bx)) {
		            return new int[] {ny - dy[dir], nx - dx[dir]};
		         }
		         if(arr[ny][nx] == 'O') {
//		            tempMap[ny - dy[dir]][nx - dx[dir]] = '.';   
//		            list.add(new int[][] {{-1, -1}});
//		            list.add(tempMap);
		            return new int[] {-1, -1};
		         }
		      }
		   }
		   
	   private static int [] moveB2(int ry, int rx, int by, int bx, int dir) {
		      int ny = by;
		      int nx = bx;
		      while(true) {
		         ny += dy[dir];
		         nx += dx[dir];
		         if(ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == '#' || (ny == ry  && nx == rx)) {
		            return new int[] {ny - dy[dir], nx - dx[dir]};
		         }
		         if(arr[ny][nx] == 'O') {
//		            tempMap[ny - dy[dir]][nx - dx[dir]] = '.';   
//		            list.add(new int[][] {{-1, -1}});
//		            list.add(tempMap);
		            return new int[] {-1, -1};
		         }
		      }
		   }
	   
	}