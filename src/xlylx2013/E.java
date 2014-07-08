package xlylx2013;

import java.util.Arrays;
import java.util.Scanner;

public class E {
	
	static boolean[][] chess;
	static boolean[] visit;
	static int solve;
	static int n;
	static int k;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			solve = 0;
			n = scan.nextInt();
			k = scan.nextInt();
			scan.nextLine();
			if(n == -1 && k == -1)
				break;
			visit = new boolean[n];
			Arrays.fill(visit, false);
			chess = new boolean[n][n];
			for(int i=0;i<n;i++){
				String line = scan.nextLine();
				for(int j=0;j<n;j++){
					chess[i][j] = line.charAt(j)=='#'?true:false;
				}
			}
			if(k>n){
				System.out.println(0);
				continue;
			}
//			for(int i=0;i<n;i++){
//				func(i, 1);
//			}
			func(-1, 0);
			System.out.println(solve);
		}
	}
	
	static void func(int line, int sum){
		if(sum == k){
			solve ++;
			return;
		}
		for(int i=line+1;i<n;i++){
			for(int j=0;j<n;j++){
				if(chess[i][j]&&!visit[j]){
					visit[j] = true;
					func(i, sum+1);
					visit[j] = false;
				}
			}
		}
	}
}
