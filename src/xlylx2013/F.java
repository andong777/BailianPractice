package xlylx2013;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class F {
	static boolean[] visit = new boolean[100005];
	static int[] step = new int[100005];
	public static void main(String[] args) {
		Arrays.fill(visit, false);;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		if(N >= K){
			System.out.println(N - K);
		}else{
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(N);
			step[N] = 0;
			while(!q.isEmpty()){
				int t = q.remove();
				if(t == K){
					System.out.println(step[t]);
					break;
				}
				if(t-1>=0&&!visit[t-1]){
					q.add(t - 1);
					visit[t-1] = true;
					step[t-1] = step[t]+1;
				}
				if(t+1<=100000&&!visit[t+1]){
					q.add(t + 1);
					visit[t+1] = true;
					step[t+1] = step[t]+1;
				}
				if(2*t<=100000&&!visit[2*t]){
					q.add(2*t);
					visit[2*t] = true;
					step[2*t] = step[t]+1;
				}
			}
//			System.out.println(step);
		}
	}
}
