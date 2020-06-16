package matrix;

public class Swap {

	public static void swap(int[] array, int i1, int i2) {
		
		int temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
	}
	
	public static void main(String args[]) {
		
		int[] numbers = {10, 20, 30, 40, 50, 60, 70};
		swap(numbers, 0, 1);
		
		System.out.printf("numbers[0]: %d\n", numbers[0]);
		System.out.printf("numbers[1]: %d\n", numbers[1]);
		
	}
	
}
