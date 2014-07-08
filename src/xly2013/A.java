package xly2013;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		for(int k=0;k<K;k++){
			int N = scan.nextInt();
			int NA = scan.nextInt();
			int NB = scan.nextInt();
			int[] A = new int[NA];
			int[] B = new int[NB];
			for(int i=0;i<NA;i++)
				A[i] = scan.nextInt();
			for(int i=0;i<NB;i++)
				B[i] = scan.nextInt();
			int sum = 0;
			for(int i=0;i<N;i++)
				sum += check(A[i%A.length], B[i%B.length]);
			if(sum > 0)
				System.out.println("A");
			else if(sum < 0)
				System.out.println("B");
			else
				System.out.println("draw");
		}
	}
	
	public static int check(int a, int b){
		if(a==b)
			return 0;
		if(a==0&&b==2||a==2&&b==5||a==5&&b==0)
			return 1;
		return -1;
	}
}
