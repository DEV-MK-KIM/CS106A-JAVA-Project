
public class MyCounter {
	
	
	//with parameters
	public MyCounter (int startValue) {
		counter = startValue;

	}
	
	//without parameters
	public MyCounter() {
		counter = 1;
		
	}
	
	
	public int  realValue() {
		int temp = counter;
		counter++;
		return (temp);
		
	}

	private int counter;
	
	
}
