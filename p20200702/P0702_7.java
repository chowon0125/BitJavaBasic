package p20200702;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point implements Comparable{
	int x,y;
	public Point(int x, int y) {
		this.x=x; this.y=y;
	}
	
	@Override
	public String toString() {
		return "(x="+x+", y="+y+")";
	}
	
	@Override
	public int compareTo(Object o) {
		if(this.x > ((Point)o).x){
			return 1; //x에 대해서는 오름차순
		}
		else if(this.x == ((Point)o).x) {
			if(this.y < ((Point)o).y) {
				return 1; //y에 대해서는 내림차순
			}
		}
		return -1;
	}
}

public class P0702_7 {
	public static void main(String[] args) {
		List pointList = new ArrayList();
		pointList.add(new Point(5,6));
		pointList.add(new Point(7,9));
		pointList.add(new Point(2,5));
		Collections.sort(pointList);
		System.out.println(pointList);
	}
}
