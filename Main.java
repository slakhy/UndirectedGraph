import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int island, map, stateT, travelT;
		
		String input = scan.nextLine();
		
		String [] chosen = input.split("\\s+");
		
		island = Integer.valueOf(chosen[0]);
		map = Integer.valueOf(chosen[1]);
		stateT = Integer.valueOf(chosen[2]);
		travelT= Integer.valueOf(chosen[3]);
		
		
		Graph g = new Graph(island);
		
		for(int i = 0; i < map; i++) {
			
			input = scan.nextLine();
			String [] temp = input.split("\\s+");
			
			
			g.addEdge((Integer.valueOf(temp[0])-1), (Integer.valueOf(temp[1])-1));
			
		}
		
		input = scan.nextLine();
		
		int start = Integer.valueOf(input.split("\\s+")[0]);
		int destination = Integer.valueOf(input.split("\\s+")[1]);
		
		BFS bfs = new BFS(g, (start - 1));
		
		Iterable<Integer> pathRev = new Stack<Integer>();
		pathRev = bfs.pathTo((destination - 1));
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		
		for(int v : pathRev) {
			path.add(v);
		}
		
		System.out.println(path.size());
		
		for(int i = path.size()-1; i > 0; i--) {
			System.out.print((path.get(i) + 1) + " ");
		}
		
		System.out.println((path.get(0) + 1));
		
		
		int time = 0;
		
		for(int i = 0; i < path.size() - 1; ) {
			if((time/stateT)%2 == 0) {
				time += travelT; 
				i++;
			}
			else {
				time += 1;
			}
		}
		
		System.out.println(time);
		

	}
	

}