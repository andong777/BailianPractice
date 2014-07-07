package xlylx2013;

import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			int n = scan.nextInt();
			if(n == 0)
				break;
			
			int[][] dis = new int[n+1][n+1];
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					if(i!=j)
						dis[i][j] = 10000;
					else
						dis[i][j] = 0;
				}
			}
			for(int i=1;i<=n;i++){
				int k = scan.nextInt();
				for(int j=1;j<=k;j++){
					int p = scan.nextInt();
					int t = scan.nextInt();
					dis[i][p] = t;
				}
			}
			for(int k=1;k<=n;k++){
				for(int i=1;i<=n;i++){
					for(int j=1;j<=n;j++){
						if(dis[i][k] + dis[k][j] < dis[i][j])
							dis[i][j] = dis[i][k] + dis[k][j];
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for(int i=1;i<=n;i++){
				int max = Integer.MIN_VALUE;
				for(int j=1;j<=n;j++){
					if(dis[i][j]>max)
						max = dis[i][j];
				}
				if(max < min){
					min = max;
					idx = i;
				}
			}
			System.out.println(idx+" "+min);
		}
	}
}
