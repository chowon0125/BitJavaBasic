package test;

public class Memo {
	public static void main(String[] args) {
		
		int i = 1;
		
		int[] arr = new int[3];
		
		arr[0] = i;
		
		System.out.println(arr[i-1]);
		
		System.out.println(i);
		
		System.out.println(arr[--i]);
		
		System.out.println(i);
	}
}
