package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675_문자열반복 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
	
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i < s.length(); i++) {
				for(int j = 0; j < N; j++) {
					sb.append(s.charAt(i));
				}
			}
			
			System.out.println(sb);
		}
	}

}
