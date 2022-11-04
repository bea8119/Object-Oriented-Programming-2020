import it.polito.oop.bigarray.BigArray;

public class TestApplication {

	public static void main(String[] args) {
		BigArray ba = new BigArray(50);
		
		ba.setElement(23, 10);
		ba.setElement(10, 23);
		
		System.out.println("23: " + ba.getElement(23));
		System.out.println("10: " + ba.getElement(10));
		System.out.println("18: " + ba.getElement(18));
		
		ba.setElement(1800, 500);
		
		System.out.println("1000: " + ba.getElement(1000));
		System.out.println("1800: " + ba.getElement(1800));
		System.out.println("23: " + ba.getElement(23));
		System.out.println("10: " + ba.getElement(10));
		System.out.println("18: " + ba.getElement(18));
		
	}

}
