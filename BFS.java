import java.util.Stack;

public class  BFS{
 
	private boolean[] marked; 
	private int[] edgeTo;     // Last vertex on known path to this vertex
	private final int s;      //Source
	
	public BFS(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;          // Mark the source and put it on the queue.
		queue.enqueue(s);           

		while (!queue.isEmpty()){
			int v = queue.dequeue(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
				if (!marked[w])       // For each unmarked neighboring vertex,save last edge on a shortest path,mark it since way is known,
				{                      //   and add it to the queue.
					edgeTo[w] = v;       
		            marked[w] = true; 
		            queue.enqueue(w);   
            }
		}
	}
                
   public boolean hasPathTo(int v)
   {  return marked[v];  }


   	public Iterable<Integer> pathTo(int v){
   		if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
           path.push(x);
        }
        path.push(s);
        return path;
	}
}