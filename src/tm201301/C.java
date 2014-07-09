package tm201301;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String a = scan.next();
			String b = scan.next();
			build(a, b);
			System.out.println();
		}
	}
	
	public static void build(String a,String b){
        int len = a.length();
        if(len==1){
            System.out.print(a);
        }
        else if(len>1){
            char c = a.charAt(0);
            String[] temp = b.split(c+"");
            int len0 = temp[0].length();
            int len1 = temp[1].length();
            build(a.substring(1, 1+len0),temp[0]);
            build(a.substring(len-len1),temp[1]);
            System.out.print(c);
        }   
    }
}
