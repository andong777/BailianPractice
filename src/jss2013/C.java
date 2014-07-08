package jss2013;

import java.util.Arrays;
import java.util.Scanner;

public class C {
	static int solve = 0;
	static int[] num;
	static int n,t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++)
			num[i] = sc.nextInt();
		
		for(int i=0;i<n;i++)
			func(i+1, t-num[i]);
		System.out.println(solve);
	}
	
	static void func(int begin, int rem){
		if(rem == 0){
			solve ++;
			return;
		}
		if(rem < 0 || begin >= n)
			return;
		for(int i=begin;i<n;i++){
			func(i+1, rem-num[i]);
		}
	}
}
