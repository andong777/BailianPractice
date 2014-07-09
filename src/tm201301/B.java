package tm201301;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for(int i=0;i<n;i++){
				int x = scan.nextInt();
				sum += x;
				max = x > max?x:max;
			}
			if(max > sum - max)
				System.out.printf("%.1f\n", sum - max + .0);
			else
				System.out.printf("%.1f\n", sum / 2.0);
		}
	}
}
