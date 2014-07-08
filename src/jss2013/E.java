package jss2013;

import java.util.Scanner;

public class E {
	static int[][] os = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static int[][] arr;
	static int m,n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			m = scan.nextInt();
			n = scan.nextInt();
			if(m==0)
				break;
			scan.nextLine();
			arr = new int[m][n];

			int[][] quick = new int[n*m][2];
			int k=0;
			for(int i=0;i<m;i++){
				String s = scan.nextLine();
				for(int j=0;j<n;j++){
					char c = s.charAt(j);
					if(c=='@'){
						arr[i][j] = k+1;
						quick[k][0] = i;
						quick[k++][1] = j;
					}
				}
			}
			for(int i=0;i<k;i++){
				int x = quick[i][0];
				int y = quick[i][1];
				for(int ii=0;ii<os.length;ii++){
					int xx = x + os[ii][0];
					int yy = y + os[ii][1];
					if(check(xx,yy)&&arr[xx][yy]!=0){
						union(x,y,xx,yy);
					}
				}
			}
			int sum = 0;
			for(int i=0;i<k;i++){
				int x = quick[i][0];
				int y = quick[i][1];
				if(arr[x][y]==i+1){
					sum ++;
				}
			}
			System.out.println(sum);
		}
		
	}
	
	static boolean check(int x, int y){
		return x>=0&&x<m&&y>=0&&y<n;
	}
	
	static void union(int x, int y, int xx, int yy){
		arr[xx][yy] = arr[x][y];
	}
}
