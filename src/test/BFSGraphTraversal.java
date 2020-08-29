package test;

public class BFSGraphTraversal {

	Vertex[] adjLists;
	
	public void bfs() {
		Queue queue = new Queue();
		boolean[] visited = new boolean[adjLists.length];
		
		for (int v = 0; v < visited.length; v++) {
			if (!visited[v]) {
				System.out.println("\nSTARTING AT " + adjLists[v].name);
				bfs(v, visited, queue);
			}
		}
	}
	
	private void bfs(int start, boolean[] visited, Queue queue) {
		visited[start] = true;
		System.out.println("Visiting " + adjLists[start].name);
		
		queue.enQueue(start);
		
		while (!queue.isEmpty()) {
			int v = queue.deQeueu();
			for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
				System.out.println("\n" + adjLists[v].name + "--" + adjLists[nbr.vertexNum].name);
			}
		}
	}
}
