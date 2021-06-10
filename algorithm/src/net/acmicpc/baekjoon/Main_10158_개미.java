package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());


		System.out.print(((p + t) / w) % 2 == 0 ? (p + t) % w : w - (p + t) % w);
		System.out.print(" ");
		System.out.println(((q + t) / h) % 2 == 0 ? (q + t) % h : h - (q + t) % h);

	}
}