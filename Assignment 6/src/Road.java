
public class Road implements Comparable<Road> {
	String name;
	Town source;
	int weight;
	Town destination;
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.name = name;
		this.source = source;
		this.weight = degrees;
		this.destination = destination;
	}
	
	public Road(Town source, Town destination, String name) {
		this(source, destination, 1, name);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean contains(Town town) {
		return destination.equals(town);
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object o) {
		Road r =(Road)o;
		return((source.equals(r.getSource())) && (destination.equals(r.getDestination()))) || ((source.equals(r.getDestination())) && (destination.equals(r.getSource())));
	}
	
	public Town getDestination() {
		return destination;
	}
	
	public Town getSource() {
		return source;
	}

	
	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Road o) {
		return name.compareTo(o.getName());
	}



}
