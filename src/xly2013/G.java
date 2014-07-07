package xly2013;

import java.util.Scanner;

public class G {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				arr[i][j] = scan.nextInt();
			}
		}
		for(int i=N-2;i>=0;i--){
			for(int j=0;j<=i;j++){
				arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
			}
		}
		System.out.println(arr[0][0]);
	}
}
