package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16916_부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] P = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		
		int pLen = P.length, sLen = S.length;
		int[] fail = new int[sLen];
		
		for(int i = 1, j = 0; i < sLen; i++) {
		
			while(j > 0 && S[i] != S[j]) {
				j = fail[j - 1];
			}
			if(S[i] == S[j]) fail[i] = ++j;
		
		}
		boolean check = false;
		for(int i = 0, j = 0; i < pLen; i++) {
			while(j > 0 && P[i] != S[j]) {
				j = fail[j - 1];
			}
			
			if(P[i] == S[j] && j == sLen - 1) {
				check = true;
				break;
			} else {
				j++;
			}
			
		}
		System.out.println(check ? 1 : 0);
		
	}

}
