package jss2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class G {
	static StreamTokenizer st;
	static int n, x, y, max;
	static Board[] board = new Board[1001];
	static int[] lt = new int[1001];
	static int[] rt = new int[1001];
	public static void main(String[] args) throws IOException {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		while(t-->0){
			n = nextInt();
			x = nextInt();
			y = nextInt();
			max = nextInt();
			
			Arrays.fill(lt, -1);
			Arrays.fill(rt,  -1);
			for(int i=1;i<=n;i++){
				int lx = nextInt();
				int rx = nextInt();
				int y = nextInt();
				board[i] = new Board(lx, rx, y);
			}
			
			board[0] = new Board(x, x, y);
			Arrays.sort(board, 0, n);
			
			System.out.println(mintime(0, true));
		}
	}
	
	static int mintime(int idx, boolean left){
		int x,y;
		if(left)
			x = board[idx].lx;
		else
			x = board[idx].rx;
		y = board[idx].y;
		int i;
		for(i=idx+1;i<=n;i++)
			if(board[i].lx <= x && board[i].rx >= x)
				break;
		if(i>n){
			if(y > max)
				return Integer.MAX_VALUE;
			else
				return y;
		}
		if(y - board[i].y > max)
			return Integer.MAX_VALUE;
		
		if(lt[i] < 0)
			lt[i] = mintime(i, true);
		if(rt[i] < 0)
			rt[i] = mintime(i, false);
		
		int fall = y - board[i].y;
		int lefttime = fall + x - board[i].lx + lt[i];
		int righttime = fall + board[i].rx - x + rt[i];
		
		return Math.min(lefttime, righttime);
	}
	
	static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	
}

class Board implements Comparable<Board>{
	int lx, rx, y;
	Board(int l, int r, int h){
		lx = l;
		rx = r;
		y = h;
	}
	@Override
	public int compareTo(Board arg0) {
		return arg0.y - this.y;
	}
}