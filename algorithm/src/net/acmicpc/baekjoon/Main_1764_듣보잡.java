package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		String[] arr1 = new String[N];
//		String[] arr2 = new String[M];
//		for(int i = 0; i < N; i++) {
//			arr1[i] = br.readLine();
//		}
//		Arrays.sort(arr1);
//		List<String> list = new ArrayList<>();
//		for(int i = 0; i < M; i++) {
//			arr2[i] = br.readLine();
////			if(Arrays.binarySearch(arr1, arr2[i]) >= 0) list.add(arr2[i]);
//			int start = 0, end = arr1.length - 1;
//			boolean check = false;
//			while(start <= end) {
//				int mid = (start + end) / 2;
//				
//				if(arr1[mid].equals(arr2[i])) {
//					check = true;
//					break;
//				}
//				else if(arr1[mid].compareTo(arr2[i]) > 0) end = mid - 1;
//				else if(arr1[mid].compareTo(arr2[i]) < 0) start = mid + 1;
//			}
//		
//			if(check) list.add(arr2[i]);
//		}
//		
//		
//		
//		System.out.println(list.size());
//		Collections.sort(list, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//		});
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
//	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		TreeMap<String, Integer> map = new TreeMap<>();
//		
//		for (int i = 0; i < N; i++) {
//			String name = br.readLine();
//			map.put(name, 1);
//		}
//		int cnt = 0;
//		for (int i = 0; i < M; i++) {
//			String name = br.readLine();
//			if (map.containsKey(name)) {
//				cnt++;
//				map.replace(name, 2);
//			} else {
//				map.put(name, 1);
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		sb.append(cnt);
//		sb.append('\n');
//		for (Map.Entry<String, Integer> entry : map.entrySet()) {
//			if (entry.getValue() == 2) {
//				sb.append(entry.getKey());
//				sb.append('\n');
//			}
//		}
//		
//		System.out.println(sb);
//		
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, 1);
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (map.containsKey(name)) {
				cnt++;
				map.replace(name, 2);
			} else {
				map.put(name, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		sb.append('\n');
		List<String> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 2) {
				list.add(entry.getKey());
			}
		}
		Collections.sort(list);
		for (int i = 0, size = list.size(); i < size; i++) {
			sb.append(list.get(i));
			sb.append('\n');
		}
		System.out.println(sb);
		
	}

}
