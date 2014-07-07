package xly2013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class F {
	static int[][] off = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
	static int L, R, C;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			L = scan.nextInt();
			R = scan.nextInt();
			C = scan.nextInt();
			scan.nextLine();
			if(L==0&&R==0&&C==0)
				break;
			Point2 start = new Point2(0, 0, 0, 0), end = new Point2(0, 0, 0, 0);
			boolean[][][] way = new boolean[L][R][C]; 
			for(int i=0;i<L;i++){
				for(int j=0;j<R;j++){
					String s = scan.nextLine();
					for(int k=0;k<C;k++){
						char c = s.charAt(k);
						if(c == 'S'){
							start = new Point2(i,j,k, 0);
							way[i][j][k] = true;
						}else if(c == 'E'){
							end = new Point2(i,j,k, 0);
							way[i][j][k] = true;
						}else if(c == '.'){
							way[i][j][k] = true;
						}else{
							way[i][j][k] = false;
						}
					}
				}
				scan.nextLine();
			}
			
			Queue<Point2> q = new LinkedList<Point2>();
			q.add(start);
			boolean noAns = true;
			while(!q.isEmpty()){
				Point2 p = q.remove();
				if(p.x==end.x&&p.y==end.y&&p.z==end.z){
					System.out.println("Escaped in "+p.cnt+" minute(s).");
					noAns = false;
				}
				for(int i=0;i<6;i++){
					int x = p.x + off[i][0];
					int y = p.y + off[i][1];
					int z = p.z + off[i][2];
					if(check(x,y,z)&&way[x][y][z]){
						q.add(new Point2(x,y,z, p.cnt+1));
						way[x][y][z] = false;
					}
				}
			}
			if(noAns)
				System.out.println("Trapped!");

		}
	}
	
	static boolean check(int a, int b, int c){
		if(a>=0&&a<L&&b>=0&&b<R&&c>=0&&c<C)
			return true;
		return false;
	}
	
}

class Point2{
	int x,y,z;
	int cnt;
	Point2(int x, int y, int z, int cnt){
		this.x = x;
		this.y = y;
		this.z = z;
		this.cnt = cnt;
	}
}
