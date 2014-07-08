package jss2013;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * HashMap：无序
 * LinkedHashMap：保持输入顺序
 * TreeMap：按照键值排序
 * 
 * TreeMap的用法：
 * put, remove, clear等；
 * higherEntry和lowerEntry获得最近的更大值和更小值
 */

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(100000, 1);
		int n = scan.nextInt();
		for(int t=0;t<n;t++){
			int id = scan.nextInt();
			int power = scan.nextInt();
			map.put(power, id);
			Entry el = map.lowerEntry(power);
			Entry eh = map.higherEntry(power);
			if(el != null && eh != null){
				int dl = Math.abs((int)el.getKey()-power);
				int dh = Math.abs((int)eh.getKey()-power);
				if(dl > dh){
					System.out.println(id+" "+eh.getValue());
				}else{
					System.out.println(id+" "+el.getValue());
				}
			}else if(el != null && eh == null){
				System.out.println(id+" "+el.getValue());
			}else if(el == null && eh != null){
				System.out.println(id+" "+eh.getValue());
			}
		}
		
	}
}
