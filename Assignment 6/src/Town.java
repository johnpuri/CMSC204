
public class Town implements Comparable<Town> {

	boolean visited;
	String name;

	public Town(Town templateTown) {
		this(templateTown.name);
	}
	
	public Town(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Town o) {
		return name.compareTo(o.getName());
	}	
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
	
	public boolean equals(Object o) {
		Town t =(Town)o;
		return name.equals(t.getName());
	}

	
	public int hashCode() {
		return name.hashCode();
	}



}
