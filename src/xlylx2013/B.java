package xlylx2013;

import java.util.Arrays;
import java.util.Scanner;

// http://bailian.openjudge.cn/xlylx2013/B/

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int L = scan.nextInt();
		int N = scan.nextInt();
		int[] arr = new int[L+1];
		Arrays.fill(arr, 0);
		int[] k = new int[N];
		for(int i=0;i<N;i++){
			k[i] = scan.nextInt();
		}
		for(int i=0;i<N;i++){
			int f = scan.nextInt();
			arr[k[i]] += f;
			for(int j=1;j<f;j++){
				if(k[i] + j <= L)
					arr[k[i] + j] += f - j;
				if(k[i] - j >= 0)
					arr[k[i] - j] += f - j;
			}
		}
		int idx = 0;
		for(int i=1;i<=L;i++){
			if(arr[i] < arr[idx]){
				idx = i;
			}
		}
		System.out.println(idx);
		System.out.println(arr[idx]);
	}
}
