package backend;

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
		 
		 Q.add(new Edge(start, 0));
	     distance.set(start, 0d);	       
		
	     while(!Q.isEmpty()) {
	    	 
	    	 current = Q.element().dest;
	         Q.remove();
	         
	         if(visited.get(current)) continue;
	         
	         visited.set(current, true);
	         
	         for(Edge n : adjacencyList.getEdgeList(current)) {
	        	 
	         	adjacent = n.dest;
	         	weight = n.weight;
	         	
	         	if(!visited.get(adjacent)) {
	         			
	         		if(distance.get(current) + weight < distance.get(adjacent)) {
	         	            
	         			distance.set(adjacent, distance.get(current) + weight);
	         	        prev.set(adjacent, current);
	         	            
	         	        Q.add(new Edge(adjacent, distance.get(adjacent)));
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
}
