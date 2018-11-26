package backend;

public class Edge implements Comparable<Edge> {
	
	public int dest;
	public double weight;
    
	Edge(int dest , double weight){
    	
        this.dest = dest;
        this.weight = weight;
    }
	
	public boolean equals(Object other) {
		
		return dest == ((Edge)other).dest;
	}
    
	@Override
    public int compareTo(Edge other) {
    	
        if(weight > other.weight) return 1;
        
        if(weight == other.weight) return 0;
        
        return -1;
    }
	
	@Override
	public String toString(){
		
		return "Edge[dest=" + dest + " w=" + weight + "]";
	}
}