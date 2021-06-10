package com.swexpertacademy.D4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Name {
	String name;

	public Name(String name) {
		super();
		this.name = name;
	}
}

public class Solution_D4_7701_염라대왕의이름정렬 {
	static List<Name> nameList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			set.clear();
			nameList.clear();

			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				set.add(sc.next());
			}
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				nameList.add(new Name(iter.next()));
			}

			Collections.sort(nameList, new Comparator<Name>() {

				@Override
				public int compare(Name o1, Name o2) {
					// TODO Auto-generated method stub
					if (o1.name.length() == o2.name.length()) {
						return solve(o1.name, o2.name, 0);
					}

					return o1.name.length() - o2.name.length();
				}

				private int solve(String a, String b, int index) {
					// TODO Auto-generated method stub
					if (a.charAt(index) == b.charAt(index)) {
						return solve(a, b, index + 1);
					}
					if (a.charAt(index) > b.charAt(index)) {
						return 1;
					}

					if (a.charAt(index) < b.charAt(index)) {
						return -1;
					}

					return 0;
				}

			});
			;

			Iterator<Name> name = nameList.iterator();
			System.out.println("#" + t + " ");
			while (name.hasNext()) {
				System.out.println(name.next().name);
			}
		}
	}
}
