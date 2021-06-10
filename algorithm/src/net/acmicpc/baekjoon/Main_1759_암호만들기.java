package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int L, C;
	static int[] selected;
	static int[] arr;
	static String s= "aeiou";
	static boolean check;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[C];
		selected = new int[L];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		c(0, 0);
		
	}
	
	
	public static void c(int cnt, int start) {
		if(cnt == L) {
			for(int i = 0; i < L; i++) {
				if(s.indexOf((char)selected[i]) != -1) {
					check = true;
				}
				if(s.indexOf((char)selected[i]) == -1) {
					count++;
				}
			}
			if(!check || count < 2) {
				check = false;
				count = 0;
				return;
			}
			for(int i = 0; i < L; i++) {
				System.out.print((char)selected[i]);
			}
			System.out.println();
			check = false;
			count = 0;

			return;
		}
		for(int i = start; i < C; i++) {
			
			selected[cnt] = arr[i];
			c(cnt + 1, i + 1);
		}
	}

}