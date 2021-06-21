package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5430_AC {
	static int N, start, end;
	static boolean reverse;
	static Deque<Integer> dq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (int t = 1; t <= T; t++) {
			String s1 = br.readLine();
			s1 = s1.replace("RR", "");
			N = Integer.parseInt(br.readLine());
			String s2 = br.readLine();
			String sArr = s2.substring(1, s2.length() - 1);
			StringTokenizer st = new StringTokenizer(sArr, ",");
			dq = new ArrayDeque<>();
			boolean isError = false;
//			while (st.countTokens() != 0) {
//				dq.addLast(Integer.parseInt(st.nextToken()));
//			}
			for(int i = 0; i < N; i++) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			reverse = false; // false 정 true 뒤집은거
			
			for(int i = 0; i < s1.length(); i++) {

				if(s1.charAt(i) == 'R') R();
				if(s1.charAt(i) == 'D') {
					if(!D()) {
						isError = true;
						break;
					}
				}
			}
			if(isError) {
				sb.append("error");
			}
			else {
				sb.append('[');
				if(reverse) {
					for(int i = 0, size = dq.size(); i < size; i++) {
						sb.append(dq.pollLast());
						if(i != size - 1) sb.append(",");
					}
				}else {
					for(int i = 0, size = dq.size(); i < size; i++) {
						sb.append(dq.pollFirst());
						if(i != size - 1) sb.append(",");
					}
				}
				sb.append(']');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void R() {
		reverse = !reverse;
	}
	
	private static boolean D() {
		if(dq.isEmpty()) return false;
		if(reverse) {
			dq.pollLast();
		}
		else dq.pollFirst();
		
		return true;
	}
	
/*
	static int N, start, end;
	static boolean reverse;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
		for (int t = 1; t <= T; t++) {
			String s1 = br.readLine();
			s1 = s1.replace("RR", "");
			N = Integer.parseInt(br.readLine());
			String s2 = br.readLine();
			String sArr = s2.substring(1, s2.length() - 1);
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(sArr, ",");

			
			boolean isError = false;
//			while (st.countTokens() != 0) {
//				
//				arr[cnt++] = Integer.parseInt(st.nextToken());
//			}
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			start = 0;
			reverse = false; // false 정 true 뒤집은거
			end = N - 1;
			
			for(int i = 0; i < s1.length(); i++) {
				
				if(s1.charAt(i) == 'R') R();
				if(s1.charAt(i) == 'D') {
					D();
				}
				if(start - end > 1) {
					isError = true;
					break;
				}
			}
			if(isError) {
				sb.append("error");
			}
			else {
				
				sb.append('[');
				if(reverse) {
					for(int i = end; i >= start; i--) {
						sb.append(arr[i]);
						if(i != start) sb.append(',');
					}
				}else {
					for(int i = start; i <= end; i++) {
						sb.append(arr[i]);
						if(i != end) sb.append(',');
					}
				}
				sb.append(']');
			}
            sb.append('\n');
		}
        bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void R() {
		reverse = !reverse;		
	}
	
	private static void D() {
		if(reverse) end--;
		else start++;
	}
*/
}
