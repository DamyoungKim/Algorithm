import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, min, maxTime, helpedTime;
	static class Node {
		int time;
		int[] prev;
		boolean helped;
		public Node(int time, int[] prev) {
			super();
			this.time = time;
			this.prev = prev;
		}
		
	}
	static List<Node> list;
	static boolean[] clear;
	static int[] delayTime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int time = Integer.parseInt(st.nextToken());
				int size = st.countTokens();
				int[] prev = new int[size];
				for (int j = 0; j < size; j++) {
					prev[j] = Integer.parseInt(st.nextToken()) - 1;
				}
				list.add(new Node(time, prev));
			}
			delayTime = new int[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				clear = new boolean[N];
				Node cur = list.get(i);
				if (cur.prev[0] != -1) continue;
				clear[i] = true;
				delayTime[i] = cur.time;
				solve(i, false, 1, cur.time);
				delayTime[i] = cur.time / 2;
				solve(i, true, 1, cur.time / 2);
				clear[i] = false;
			}
			if (min == Integer.MAX_VALUE) min = -1;
			System.out.println("#" + t + " " + min);
			
		}
	}
	private static void solve(int no, boolean helped, int cnt, int sum) {
		if (sum >= min) return;
		if (cnt == N) {
			min = Math.min(min, sum);
			return;
		}
		Node cur = list.get(no);
		for (int i = 0; i < N; i++) {
			if (clear[i]) continue;
			Node next = list.get(i);
			if (next.prev[0] == -1) {
				delayTime[i] = next.time;
				clear[i] = true;
				int nextTime = Math.max(sum, next.time);
				solve(i, helped, cnt + 1, nextTime);
				if (!helped) {
					delayTime[i] = next.time / 2;
					nextTime = Math.max(sum, next.time / 2);
					solve(i, true, cnt + 1, nextTime);
				}
				clear[i] = false;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (clear[i]) continue;
			boolean check = false;
			Node next = list.get(i);
			if (next.prev[0] == -1) continue;
			int choiceTime = 0;
			for (int j = 0; j < next.prev.length; j++) {
				if (clear[next.prev[j]]) {
					choiceTime = Math.max(delayTime[next.prev[j]], choiceTime);
					continue;
				}
				check = true;
				break;
			}
			if (check) continue;
			if (choiceTime < next.time) {
				delayTime[i] = next.time;
			} else {
				delayTime[i] = next.time + choiceTime;
			}
			int nextTime = Math.max(sum, delayTime[i]);
			clear[i] = true;
			solve(i, helped, cnt + 1, nextTime);
			if (!helped) {
				if (choiceTime < next.time / 2) {
					delayTime[i] = next.time / 2;
				} else {
					delayTime[i] = next.time / 2 + choiceTime;
				}
				nextTime = Math.max(sum, delayTime[i]);
				solve(i, true, cnt + 1, nextTime);
			}
			clear[i] = false;
		}
	}

	
}
/*
1
3
194 0
755 0
3 0

1
3
40 0
50 0
60 0

1
6
123 3
110 0
80 2 4
105 2
145 2 4
50 2

1
5
676 0
586 1 3
544 0
365 2 3 5
541 0

1
6
125 3
110 0
80 2 4
105 2
145 2 4
50 2

*/