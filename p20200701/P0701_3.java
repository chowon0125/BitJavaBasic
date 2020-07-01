package p20200701;

public class P0701_3 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("A1");
		System.out.println(sb);
		sb.append("B2");
		System.out.println(sb);
		System.out.println(sb.charAt(2));
		sb.delete(1, 3);
		System.out.println(sb);
		sb.deleteCharAt(1);
		System.out.println(sb);
		sb.insert(1, "2");
		System.out.println(sb);
		sb.append("B3C4");
		System.out.println(sb);
		sb.replace(2, 4, "D5");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.substring(2));
		System.out.println(sb.substring(2,4));
		System.out.println(sb.reverse().substring(2,4));
	}
}
