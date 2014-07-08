package xly2013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class F {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int L = scan.nextInt();
			int R = scan.nextInt();
			int C = scan.nextInt();
			scan.nextLine();
			if(L==0&&R==0&&C==0)
				break;
			Point start = new Point(0, 0, 0), end = new Point(0, 0, 0);
			boolean[][][] way = new boolean[L][R][C]; 
			for(int i=0;i<L;i++){
				for(int j=0;j<R;j++){
					String s = scan.nextLine();
					for(int k=0;k<C;k++){
						char c = s.charAt(k);
						if(c == 'S'){
							start = new Point(i,j,k);
							way[i][j][k] = true;
						}else if(c == 'E'){
							end = new Point(i,j,k);
							way[i][j][k] = true;
						}else if(c == '.'){
							way[i][j][k] = true;
						}else{
							way[i][j][k] = false;
						}
					}
				}
			}
			
			Queue<Point> q = new LinkedList<Point>();
			q.add(start);
			
		}
	}
	
}

class Point{
	int x,y,z;
	Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
