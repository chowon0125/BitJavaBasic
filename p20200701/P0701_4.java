package p20200701;

import java.util.StringTokenizer;

public class P0701_4 {
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("this \t is a \n String");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("=====================");
		
		String str = "80::95:70";
		StringTokenizer st2 = new StringTokenizer(str,":",false);
		int i=0;
		while(st2.hasMoreTokens()) {
			System.out.println(i+":"+st2.nextToken());
			i++;
		}
		
		System.out.println("=====================");
		
		String[] result = str.split(":");
		for(int j=0; j<result.length; j++) {
			System.out.println(j+":"+result[j]);
		}
		
		System.out.println("=====================");
		
		String str2 = "81-2-010-1234-5678-";
		String[] arr2 = str2.split("-",6);
		for(int k=0; k<arr2.length; k++) {
			System.out.println(k+":"+arr2[k]);
		}
		
		
		
	}

}
