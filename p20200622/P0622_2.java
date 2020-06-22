package p20200622;

public class P0622_2 {
	
	public static void main(String[] args) {
		
		int i=5, j=5;
		
		System.out.println(i++);
		System.out.println(++j);
		System.out.printf("i = %d j = %d%n",i,j);
		
		i = -10;
		i = +i;
		System.out.println(i);
		
		i = -10;
		i = -i;
		System.out.println(i);
		
		int x = 10, y = 8;
		System.out.printf("%d을 %d로 나누면, \n", x,y);
		System.out.printf("몫은 %d이고, 나머지는 %d입니다.\n", x/y, x%y);
		
		
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc";
		
		System.out.print("1. ");
		System.out.println("abc"=="abc");
		System.out.print("2. ");
		System.out.println(str1=="abc");
		System.out.print("3. ");
		System.out.println(str2=="abc");
		System.out.print("4. ");
		System.out.println(str1==str3);
		System.out.print("5. ");
		System.out.println(str1==str2);
		System.out.print("6. ");
		System.out.println(str1.equals("abc"));
		System.out.print("7. ");
		System.out.println(str1.equals(str2));
		System.out.print("8. ");
		System.out.println(str2.equals(str3));
		System.out.print("9. ");
		System.out.println(str2.equals("ABC"));
		System.out.print("10. ");
		System.out.println(str2.equalsIgnoreCase("ABC"));
		
				
		x = 15;
		
		System.out.println(10>x&&x++<20);
		System.out.println("x="+x);
		System.out.println(10<x||x++<20);
		System.out.println("x="+x);

		System.out.println(10>x&x++<20);
		System.out.println("x="+x);
		System.out.println(10<x|x++<20);
		System.out.println("x="+x);
		
		
	}

}
