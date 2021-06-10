package net.acmicpc.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer br = new StringBuffer();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 0; i < N ; i++) {
			q.offer(i + 1);
		}
		int cnt = 0;
		br.append('<');
		while(!q.isEmpty()) {
			cnt++;
			if(cnt == K) {
				cnt = 0;
				br.append(q.poll());
				br.append(", ");
				continue;
			}
			q.offer(q.poll());
		}
		br.deleteCharAt(br.length() - 1);
		br.deleteCharAt(br.length() - 1);
		br.append('>');
		System.out.println(br);
	}
}