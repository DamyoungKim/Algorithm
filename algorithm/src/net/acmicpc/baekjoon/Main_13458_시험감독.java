package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	static int N;
	static int[] room;
	static int[] director = new int[2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 2; i++) {
			director[i] = Integer.parseInt(st.nextToken());
		}
		
		long count = 0;
		for(int i = 0; i < N; i++) {
			int temp = room[i];
			
			int sup = (temp - director[0]);
			if(sup <= 0) {
				count++;
				continue;
			}
			count++;
			
			int remain = temp - director[0];
			int sub = remain / director[1];
			if(sub == 0) {
				count++;
				continue;
			}
			count += sub;
			
			if(remain % director[1] != 0) count++;
		}
		System.out.println(count);	
		
	}

}
