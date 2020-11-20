package test;

public class DFSGraphTraversal {
	
	Vertex[] adjLists;
	
	public void dfs() {
		boolean[] visited = new boolean[adjLists.length];
		
		for (int v = 0; v < visited.length; v++) {
			if (!visited[v]) {
				System.out.println("\nSTARTING AT " + adjLists[v].name);
				dfs(v, visited);
			}
		}
	}
	
	// recursive dfs
	private void dfs(int v, boolean[] visited) {
		visited[v] = true;
		
		System.out.println("visiting " + adjLists[v].name);
		
		for (Neighbor nbr = adjLists[v].neighbor; nbr != null; nbr = nbr.next) {
			if (!visited[nbr.vertexNum]) {
				System.out.println("\n" + adjLists[v].name + "--" + adjLists[nbr.vertexNum].name);
				dfs(nbr.vertexNum, visited);
			}
		}
	}
}
