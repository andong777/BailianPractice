package xly2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class H {
	static Edge[] edges = new Edge[500*500];
	static int[] par;
	static BufferedReader buf;
	static StreamTokenizer st;
	
	public static void main(String[] args) throws IOException {
		buf = new BufferedReader(new InputStreamReader(System.in));
		st = new StreamTokenizer(buf);
		
		int T = nextInt();
		for(int t=0;t<T;t++){
			int N = nextInt();
			int cnt = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					int w = nextInt();
					if(i!=j)
						edges[cnt++] = new Edge(i,j,w);
				}
			}
			Arrays.sort(edges, 0, cnt);
			par = new int[N];
			for(int i=0;i<N;i++){
				par[i] = i;
			}
			int max = Integer.MIN_VALUE;
			int num = 0;
			for(int i=0;i<cnt;i++){
				int x = edges[i].x;
				int y = edges[i].y;
				int px = root(x);
				int py = root(y);
				if(px!=py){
					par[px] = py;
				if(edges[i].w > max)
					max = edges[i].w;
				if(num == N -1)
					break;
				}
			}
			
			System.out.println(max);
		}
	}
	
	static int root(int chd){
        if(par[chd]==chd)
            return chd;
        else
            return root(par[chd]);
}
	
	static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	
}

class Edge implements Comparable<Edge>{
	int x,y,w;
	public Edge(int x, int y, int w){
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public int compareTo(Edge other) {
		return this.w - other.w;
	}
}