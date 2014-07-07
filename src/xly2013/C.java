package xly2013;

import java.util.Scanner;

public class C {
	public static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			if(n == 0)
				break;
			ans = 0;
			
			solve(n);
			System.out.println(ans);
		}
	}
	
	public static void solve(int num){
		if(num == 0){
			ans ++;
			return;
		}else if(num < 0){
			return;
		}
		for(int i=1;i<=3;i++)
			solve(num - i);
	}
}
