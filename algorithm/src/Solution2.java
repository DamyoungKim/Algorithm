import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution2 {
	static int T, N, min;
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int len;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Node o) {
			return this.len - o.len;
		}
	}
	static Node A, B;
	static List<Node> list;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int exitCnt = 0;
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						list.add(new Node(i, j));
					}
					if (temp == 2) {
						if (exitCnt == 0) {
							A = new Node(i, j);
							exitCnt++;
						} else {
							B = new Node(i, j);
						}
					}
				}
			}
			min = Integer.MAX_VALUE;
			visited = new boolean[list.size()];
			powerset(0);
			System.out.println("#" + t + " " + min);
		}
		
		
	}
	private static void powerset(int cnt) {
		if (cnt == list.size()) {
			PriorityQueue<Node> a = new PriorityQueue<>();
			PriorityQueue<Node> b = new PriorityQueue<>();
			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);
				if (visited[i]) {
					node.len = Math.abs(A.y - node.y) + Math.abs(A.x - node.x);
					a.offer(node);
				} else {
					node.len = Math.abs(B.y - node.y) + Math.abs(B.x - node.x);
					b.offer(node);
				}
			}
			int timeA = solve(a);
			if (timeA == Integer.MAX_VALUE) return;
			int timeB = solve(b);
			int time = Math.max(timeA, timeB);
			min = Math.min(min, time);
			return;
		}
		
		visited[cnt] = true;
		powerset(cnt + 1);
		visited[cnt] = false;
		powerset(cnt + 1);
	}
	private static int solve(PriorityQueue<Node> q) {
		if (q.size() == 0) return 0;
		int[] time = new int[q.size()];
		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cnt == 0) {
				time[cnt] = cur.len + 1;
			} else {
				if (time[cnt - 1] < cur.len) {
					time[cnt] = cur.len + 1;
				} else {
					time[cnt] = cur.len + 1 + (time[cnt - 1] - cur.len);
				}
			}
			if (time[cnt] >= min) return Integer.MAX_VALUE;
			cnt++;
		}
		return time[time.length - 1];
	}
}
