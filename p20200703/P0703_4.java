package p20200703;

import java.util.Comparator;
import java.util.TreeSet;

public class P0703_4 {
	public static void main(String[] args) {
		new P0703_4().go();
	}

	public void go() {
		Book b1 = new Book("How Cats Work");
		Book b2 = new Book("Remix your Body");
		Book b3 = new Book("Finding Emo");
		TreeSet tree = new TreeSet();
		tree.add(b1); tree.add(b2); tree.add(b3);
		System.out.println("1 :"+tree);
		
/*		Book2 t1 = new Book2("How Cats Work");
		Book2 t2 = new Book2("Remix your Body");
		Book2 t3 = new Book2("Finding Emo");
		
		TreeSet tree2 = new TreeSet();
		tree2.add(t1); tree2.add(t2); tree2.add(t3);
		System.out.println("2 :"+tree2);
		*/
	}
}

class Book implements Comparable {
	
	private String title;
	public Book(String t) {
		title = t;
	}
	public String getTitle() {return title;}
	public String toString() {return title;}
	@Override
	public int compareTo(Object o) {
		Book book = (Book)o;
		return title.compareTo(book.getTitle());
	}
}

class Book2{
	private String title;
	
	public Book2(String t) {title = t;}
	public String getTitle() {
		return title;
	}
	public String toString() {
		return title;
	}
}

/*class BookCompare implements Comparator{

	public int compare(Object o1, Object o2) {
		return ((Book2)o1).getTitle().compareTo(((Book2)o2).getTitle());
	}
	
	
	
}
*/