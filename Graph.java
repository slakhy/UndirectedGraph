public class  Graph {
	
	private final int V;          // number of vertices
    private int E;                // number of edges
    private Bag<Integer>[] adj;   // adjacency lists

    
    public Graph(int V) {
    	
    	this.V = V; this.E = 0;
    	adj = (Bag<Integer>[]) new Bag[V];       // Create array of lists.
    	for (int v = 0; v < V; v++)              // Instate all lists 
    		adj[v] = new Bag<Integer>();         // to discharge. 
    }
    
    
    public int V()  {  return V;  }
    public int E()  {  return E;  }
    
    public void addEdge(int v, int w){
    	adj[v].add(w);                          
    	adj[w].add(v);                           // Add edge connecting each other.
    	E++;
    }
    public Iterable<Integer> adj(int v)
    {  return adj[v];  }
}