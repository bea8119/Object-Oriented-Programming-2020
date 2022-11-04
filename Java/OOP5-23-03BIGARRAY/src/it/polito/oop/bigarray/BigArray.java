package it.polito.oop.bigarray;

public class BigArray {
	private int[] arrayData;
	
	public BigArray() {
		arrayData = new int[100];
	}
	
	public BigArray(int size) {
		arrayData = new int[size];
	}
	
	// read an element from the array
	public int getElement(int index) {
		if( index < this.arrayData.length)
			return this.arrayData[index];
		
		else 
			return 0;
	}
	
	//store element into array
	public void setElement(int index, int value) {
		
		
		if( index >= this.arrayData.length) {
			//resize array
				int[] newArray = new int[index+1];
			for(int  i = 0; i < this.arrayData.length; i++)
				newArray[i] = this.arrayData[i];
			this.arrayData = newArray;
			
			
		}
			 this.arrayData[index] = value;
			
	}

}
