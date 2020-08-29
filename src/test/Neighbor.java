package test;

public class Neighbor {
	public int vertexNum;
	public Neighbor next;
	
	Neighbor(int vnum, Neighbor nbr) {
		this.vertexNum = vnum;
		this.next = nbr;
	}
}
