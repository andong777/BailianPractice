package tm201301;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n-->0){
			int x = scan.nextInt();
			System.out.println(to6(x));
		}
	}
	
	static String to6(int x){
		StringBuilder sb = new StringBuilder();
		while(x>0){
			sb.append(x%6);
			x /= 6;
		}
		return sb.reverse().toString();
	}
}
