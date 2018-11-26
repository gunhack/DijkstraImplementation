package backend;

public class Test {

	public static void main(String[] args) {
		
		AdjacencyList l = new AdjacencyList(3);
		
		
		l.addEdge(0, 1, 55, true);
		l.addEdge(0, 2, 12, true);
		l.addEdge(2, 1, 10, true);
			
		System.out.println(DijkstraAlgorithm.getMinCostPath(l, 0, 1));
	}

}

/*l.addEdge(0, 1, 10, true);
l.addEdge(0, 4, 100, true);
l.addEdge(0, 3, 30, true);

l.addEdge(1, 2, 50, true);

l.addEdge(2, 4, 10, true);

l.addEdge(3, 4, 60, true);
l.addEdge(3, 2, 20, true);*/

/*package backend;

import java.util.PriorityQueue;
import java.util.Vector;

public class DijkstraAlgorithm {
	
	 public static Vector<Integer> getMinCostPath(AdjacencyList adjacencyList, int start, int dest) {
		 
		 PriorityQueue<Edge> Q = new PriorityQueue<>();
		 Vector<Double> distance = new Vector<>();
		 Vector<Boolean> visited = new Vector<>();		 
		 Vector<Integer> prev = new Vector<>();
		 Vector<Integer> path = new Vector<>();
		 int numV = adjacencyList.size(), current, adjacent;
		 double weight;
		 
		 for(int i = 0; i < numV ; i++){
	            
			 distance.add(Double.MAX_VALUE);
			 visited.addElement(false);
			 prev.add(-1);
	     }
		 
		 System.out.println("Distances:" + distance);
		 System.out.println("Visited:" + visited);
		 System.out.println("Prev:" + prev);
		 System.out.println();
		 
		 Q.add(new Edge(start, 0));
	     distance.set(start, 0d);	  
	     
	     System.out.println("Cola:" + Q);
	     System.out.println("Distances:" + distance);
		 System.out.println();
	       
		
	     while(!Q.isEmpty()) {
	    	 
	    	 current = Q.element().dest;
	         Q.remove();
	         
	         System.out.println("Cola:" + Q);
	         System.out.println("nActual:" + current);
	         System.out.println();
	         
	         if(visited.get(current)) continue;
	         
	         visited.set(current, true);
	         System.out.println("Visited:" + visited);
	         System.out.println();
	         
	         for(Edge n : adjacencyList.getEdgeList(current)) {
	        	 System.out.println("Nodo " + current + "---\n");
	         	adjacent = n.dest;
	         	weight = n.weight;
	         	
	         	System.out.println("nAdyacente:" + adjacent);
		        System.out.println("Peso:" + weight);
		        System.out.println();
	         		
	         	if(!visited.get(adjacent)) {
	         			
	         		if(distance.get(current) + weight < distance.get(adjacent)) {
	         	            
	         			distance.set(adjacent, distance.get(current) + weight);
	         	        prev.set(adjacent, current);
	         	            
	         	        Q.add(new Edge(adjacent, distance.get(adjacent)));
	         	        
	         	       System.out.println("Distanicia:" + distance);
	         	       System.out.println("Previo:" + prev);
	         	       System.out.println("Cola:" + Q);
	         	       System.out.println();
	         	    }
	         	}
	         }
	     }
	     
	     while(prev.get(dest) != -1) {
				
	    	 path.insertElementAt(dest, 0);
	    	 dest = prev.get(dest);
	     }
			
	     return path;
	 }
}*/