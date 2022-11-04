
public class Arrayexperiments {
	public static void main(String[] args) {
		Integer[] array = null;
		
		array = new Integer[4];
		System.out.println(array);
		
		array[2]= new Integer(42);  //autoboxing!
		for( int i= 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
