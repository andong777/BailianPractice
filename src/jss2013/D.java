package jss2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {
	static int[] arr;
	static StreamTokenizer st;
	static PrintWriter out;
	public static void main(String[] args) throws IOException {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = nextInt();
		int k = nextInt();
		arr = new int[n];
		PriorityQueue<Integer> qmin = new PriorityQueue<Integer>(1);
		Comparator<Integer> com = new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1 - arg0;
			}
			
		};
		PriorityQueue<Integer> qmax = new PriorityQueue<Integer>(1, com);
		for(int i=0;i<n;i++)
			arr[i] = nextInt();
		
		for(int i=0;i<k;i++){
			qmin.add(arr[i]);
			qmax.add(arr[i]);
		}
//		int cur = 0;
		for(int i=k;i<n;i++){
			int x = qmin.peek();
			out.print(x+" ");
			qmin.remove(arr[i-k]);
			qmin.add(arr[i]);
		}
		out.println(qmin.peek());
		
		for(int i=k;i<n;i++){
			int x = qmax.peek();
			out.print(x+" ");
			qmax.remove(arr[i-k]);
			qmax.add(arr[i]);
		}
		out.println(qmax.peek());
		out.flush();
		out.close();
	}
	
	static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
}
