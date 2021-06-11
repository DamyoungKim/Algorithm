package net.acmicpc.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809_알파벳찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int[] arr = new int['z' - 'a' + 1];
		Arrays.fill(arr, -1);
		for(int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i) - 'a'] != -1) continue;
			arr[s.charAt(i) - 'a'] = i;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
		}
		
	}

}
