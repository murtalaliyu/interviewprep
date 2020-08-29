package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
	Vertex[] adjLists;
	
	public Graph(String file) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(file));
		
		String graphType = sc.next();
		boolean undirected = true;
		if (graphType.equals("directed")) {
			undirected = false;
		}
		
		adjLists = new Vertex[sc.nextInt()];
		
		//read vertices
		for (int v = 0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}
		
		//read edges
		while (sc.hasNext()) {
			//read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			//add v2 to front of v1's adjacency list and
			//add v1 to front to v2's adjacency list
			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
 			
			if (undirected) {
				adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
			}
		}
	}
	
	int indexForName(String name) {
		for (int v = 0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}
	
	public void print() {
		System.out.println();
		for (int v = 0; v < adjLists.length; v++) {
			System.out.print(adjLists[v].name);
			for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr=nbr.next) {
				System.out.print("--> " + adjLists[nbr.vertexNum].name);
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * DUPLICATE
	 */
	public void dfs() {
		boolean [] visited = new boolean[adjLists.length];
		
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
		
		for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
			if (!visited[nbr.vertexNum]) {
				System.out.println("\n" + adjLists[v].name + "--" + adjLists[nbr.vertexNum].name);
				dfs(nbr.vertexNum, visited);
			}
		}
	}
	
	/**
	 * DUPLICATE
	 */
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
