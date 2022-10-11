package Common;

public class Tuple {

	private Object first;
	
	private Object second;
	
	public Tuple(Object firstValue, Object secondValue) {
		this.first = firstValue;
		this.second = secondValue;
	}
	
	public Object GetFirst() {
		return this.first;
	}
	
	public Object GetSecond() {
		return this.second;
	}
}
