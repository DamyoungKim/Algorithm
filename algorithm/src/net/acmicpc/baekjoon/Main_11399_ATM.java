package net.acmicpc.baekjoon;

import java.io.*;
import java.util.*;

public class Main_11399_ATM {
//	static int N, result = Integer.MAX_VALUE;
//	static boolean[] isSelected;
//	static int[] arr;
//	static int[] temp;
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		arr = new int[N];
//		temp = new int[N];
//		isSelected = new boolean[N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		//solve(0);
//		Arrays.sort(arr);
//		int sum = 0;
//		for(int i = 1; i < N; i++) {
//			arr[i] += arr[i -1];
//			sum += arr[i];
//		}
//		sum += arr[0];
//		
//		System.out.println(sum);
//
//	}
//	
//	
//	public static void solve(int cnt) {
//		if(cnt == N) {
//			int sum = 0;
//			for(int i = 1; i < N; i++) {
//				temp[i] +=temp[i - 1]; 
//			}
//			
//			for(int i = 1; i < N; i++) {
//				sum += temp[i]; 
//			}
//			
//			result = Math.min(result, sum);
//			
//			return;
//		}
//		
//		for(int i = 0; i < N; i++) {
//			if(isSelected[i]) continue;
//			temp[cnt] = arr[i];
//			isSelected[i] = true;
//			solve(cnt + 1);
//			isSelected[i] = false;
//		}
//	}
	static int N;
	static int[] arr, sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = arr[0];
		sum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + arr[i];
			ans += sum[i];
		}
		System.out.print(ans);
	}

}