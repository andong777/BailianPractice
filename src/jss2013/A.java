package jss2013;

import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] arr = new int[N];
		int[] cnt = new int[M+1];
		Arrays.fill(arr, 0);
		for(int i=0;i<N;i++){
			int t = scan.nextInt();
			arr[i] = t;
			cnt[t] ++;
		}
		for(int i=0;i<N;i++){
			int t = arr[i];
			System.out.println(cnt[t]-1>0?cnt[t]-1:"BeiJu");
		}
	}
}
