package GameObjects;

public class Cell {
	// Class used to store any object value.

	protected Object Value;
	
	protected int WinWhenStarted;
	
	public Cell() {
		this.Value = 0;
		this.WinWhenStarted = 0;
	}
	
	public Object GetValue() {
		return this.Value;
	}
	
	public void SetValue(Object value) {
		this.Value = value;
	}
}
