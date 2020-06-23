package p20200623;

class Service{
	public int[] swap(int[] arr) {
		int temp;
		temp = arr[0];
			for(int i=0; i<arr.length-1;i++) {
			arr[i] = arr[i+1];
			}
		arr[arr.length-1] = temp;	
		return arr;
	}
	
	public void pritArr(int[] arr) {
		System.out.print("[ ");
		for(int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println(arr[arr.length-1] + " ]");
	}
}

public class Practice03 {
	public static void main(String[] args) {
		Service service = new Service();
		int[] arr = {1,2,3,4,5,6,7};
		arr = service.swap(arr);
		service.pritArr(arr);
	}
}
