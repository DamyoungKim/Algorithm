package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int[][] arr, mode;
	static int K;
	static Queue<Node> q;
	static class Node {
		int no;
		int dir;
		public Node(int no, int dir) {
			super();
			this.no = no;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = s.charAt(j) - '0'; // N = 0, S = 1
			}
		}
		q = new LinkedList<>();
		K = Integer.parseInt(br.readLine());
		mode = new int[K][2];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mode[i][0] = Integer.parseInt(st.nextToken()) - 1;
			mode[i][1] = Integer.parseInt(st.nextToken()); // 1 시계 , -1 반시계
		}
		
		for (int i = 0; i < K; i++) {
			bfs(i);
		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += (arr[i][0] * Math.pow(2, i));
		}
		System.out.println(result);
	}

	
	private static void bfs(int num) {
		boolean[] visited = new boolean[4];
		q.offer(new Node(mode[num][0], mode[num][1]));
		visited[mode[num][0]] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = -1; i <= 1; i += 2) {
				int nextNo = cur.no + i;
				int nextDir = cur.dir * -1;
				if (nextNo >= 4 || nextNo < 0 || visited[nextNo]) continue;
				if (i == -1) {
					if (arr[cur.no][6] == arr[nextNo][2]) continue;
				} else if (i == 1) {
					if (arr[cur.no][2] == arr[nextNo][6]) continue;
				}
				q.offer(new Node(nextNo, nextDir));
				visited[nextNo] = true;
				
			}
			rotate(cur.no, cur.dir);
		}
	}


	private static void rotate(int no, int dir) {
		if (dir == 1) {
			int temp = arr[no][7];
			for (int i = 7; i >= 1; i--) {
				arr[no][i] = arr[no][i - 1];
			}
			arr[no][0] = temp;
		} else {
			int temp = arr[no][0];
			for (int i = 0; i < 7; i++) {
				arr[no][i] = arr[no][i + 1];
			}
			arr[no][7] = temp;
		}
	}
}
