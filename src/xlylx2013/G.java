package xlylx2013;

import java.util.Arrays;
import java.util.Scanner;

public class G {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		for(int k=0;k<K;k++){
			int N = scan.nextInt();
			int[] h = new int[N];
			int[] inc = new int[N];
			int[] dec = new int[N];
			Arrays.fill(inc, 1);
			Arrays.fill(dec, 1);
			for(int n=0;n<N;n++){
				h[n] = scan.nextInt();
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<i;j++){
					if(h[j]<h[i]&&inc[j]+1>inc[i]){
						inc[i] = inc[j] + 1;
					}
					if(h[j]>h[i]&&dec[j]+1>dec[i]){
						dec[i] = dec[j] + 1;
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++){
				if(inc[i] > max)
					max = inc[i];
				if(dec[i] > max)
					max = dec[i];
			}
			System.out.println(max);
		}
	}
}
