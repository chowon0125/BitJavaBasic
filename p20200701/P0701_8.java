package p20200701;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P0701_8 {
	public static void main(String[] args) {
		DecimalFormat df2 = new DecimalFormat("#,###.##");
		System.out.println(df2.format(123456789.98));
		
		DecimalFormat df3 = new DecimalFormat("#,###");
		System.out.println(df3.format(123456789));
		
		Date today = new Date();
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		System.out.println(sdf4.format(today));
		
		String pattern = "60#D|70#C|80<B|90#A";
		int[] scores = {91, 90, 80, 88, 70, 52, 60};
		
		ChoiceFormat form = new ChoiceFormat(pattern);
		
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i] + ":" + form.format(scores[i]));
		}
		
	}
}
