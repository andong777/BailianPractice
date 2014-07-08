package xly2013;

import java.util.Arrays;
import java.util.Scanner;

public class E {
	static int[][] arr = new int[9][9];
	static boolean[] can = new boolean[10];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		for(int t=0;t<T;t++){
			
			for(int i=0;i<9;i++){
				String s = scan.nextLine();
				for(int j=0;j<9;j++){
					arr[i][j] = s.charAt(j)-48;
				}
			}
			P2 p = find(0,-1);
			func(p.x, p.y);
		}
	}
	
	static void func(int x, int y){
		check(x,y);
		for(int i=1;i<=9;i++){
			if(!can[i])
				continue;
			arr[x][y] = i;
			P2 p = find(x,y);
			if(p == null){
				for(int ai=0;ai<9;ai++){
					for(int bi=0;bi<9;bi++){
						System.out.print(arr[ai][bi]);
					}
					System.out.println();
				}
				return;
			}
			System.out.println("func("+p.x+","+p.y+"), "+arr[x][y]);
			func(p.x, p.y);
			arr[x][y] = 0;
		}
	}
	
	static P2 find(int x, int y){
//		System.out.println("find("+x+","+y+")");
		for(int i=x*9+y+1;i<81;i++)
			if(arr[i/9][i%9]==0)
				return new P2(i/9,i%9);
		return null;
	}
	
	static void check(int i,int j){
//		System.out.println("check("+i+","+j+")");
		Arrays.fill(can, true);
		for(int k=0;k<9;k++){
			if(arr[i][k]>0)
				can[arr[i][k]] = false;
			if(arr[k][j]>0)
				can[arr[k][j]] = false;
		}
		int r0 = i / 3 * 3;
		int c0 = j / 3 * 3;
		for(int di=0;di<3;di++){
			for(int dj=0;dj<3;dj++){
				if(arr[r0+di][c0+dj]>0)
					can[arr[r0+di][c0+dj]] = false;
			}
		}
	}
}

class P2{
	int x,y;
	P2(int x,int y){
		this.x = x;
		this.y = y;
	}
}
