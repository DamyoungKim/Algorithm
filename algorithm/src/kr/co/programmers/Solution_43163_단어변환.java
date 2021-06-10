package kr.co.programmers;

public class Solution_43163_단어변환 {
	static String begin= "hit", target = "cog";
	static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
	static boolean[][] arr;
	static int result = Integer.MAX_VALUE, targetIndex;
	static boolean[] visited = null;
	public static void main(String[] args) {
		boolean check = false;
		int temp = 0;
		for(String s : words) {
			if(s.equals(target)) {
			check = true;
			targetIndex = temp;
			break;
			}
			temp++;
		}
		arr = new boolean[words.length][words.length];
		if(check) {
			setting();
			solve();
			System.out.println(result);
		}
		else 
			System.out.println(0);
	}

	private static void solve() {
		for(int i = 0; i < words.length; i++) {
			visited = new boolean[words.length];
			if(connect(begin, words[i])) {
				visited[i] = true;
				dfs(i, 1);
			}
		}
	}

	private static void dfs(int row, int count) {
		if(row == targetIndex) {
		result = result > count ? count : result;
		return;
		}
		for(int i = 0; i < words.length; i++) {
			if(visited[i]) continue;
			if(arr[row][i]) {
				visited[i] = true;
				dfs(i, count + 1);
				visited[i] = false;
			}
		}
		
	}

	private static void setting() {
		for(int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(connect(words[i], words[j])) {
				arr[i][j] = true;
				arr[j][i] = true;
				}
			}
		}
	}
	
	private static boolean connect(String s1, String s2) {
		int cnt = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				cnt++;
			}
		}
		
		
		return cnt == 1 ? true : false;
	}

}
