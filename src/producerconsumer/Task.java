package producerconsumer;

public class Task {

	
	
	private String name;
	private int number;

	public Task(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", number=" + number + "]";
	}

}
