package p20200701;

import java.util.Random;

public class P0701_5 {
	
	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];
		
		for(int i=0; i<number.length; i++) {
			System.out.print(number[i] = (int)(Math.random()*10));
		}
		System.out.println();
		
		for(int i=0; i<number.length; i++) {
			counter[number[i]]++;
		}
		for(int i=0; i<counter.length; i++) {
			System.out.println(i+"의 개수 : "+ printGraph('#',counter[i])+""+counter[i]);
		}
		
		
	}
}
