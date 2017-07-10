package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Node extends JPanel{
	
	int cols = Main.cols;
	int rows = Main.rows;
	boolean wall = false;
	private float HSB[] = new float[3];
	Node[][] nodes = AStar.nodes;
	List<Node> neighbors = new ArrayList<>();
	Node previousNode = null;
	double f = 0;
	double g = 0;
	double h = 0;
	int i;
	int j;
	
	//setup node
	public Node(JPanel panel, int i, int j){
		this.i = i;
		this.j = j;
		float HSB[] = new float[3]; 
		Color.RGBtoHSB(255,206,0, HSB);
		this.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
				
		//decide if this is a wall
		if (Math.random() < .4){
			this.wall = true;
		}
		panel.add(this);
	}
	
	
	//decide if the node is a wall 
	public void makeWall(){
		if (this.wall == true){
			Color.RGBtoHSB(3,117,180, HSB);
			this.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		}
	}
	
	
	//add all the surrounding nodes to a list
	public void addNeighbors() {
		int i = this.i;
		int j = this.j;
		if (i < cols - 1) {
			this.neighbors.add(nodes[i + 1][j]);
		}
		if (i > 0) {
			this.neighbors.add(nodes[i - 1][j]);
		}	
		if (j < rows - 1) {
			this.neighbors.add(nodes[i][j + 1]);
		}
		if (j > 0) {
			this.neighbors.add(nodes[i][j - 1]);
		}
		if (i > 0 && j > 0) {
			this.neighbors.add(nodes[i - 1][j - 1]);
		}
		if (i < cols - 1 && j > 0) {
			this.neighbors.add(nodes[i + 1][j - 1]);
		}
		if (i > 0 && j < rows - 1){
			this.neighbors.add(nodes[i - 1][j + 1]);
		}
		if (i < cols - 1 && j < rows - 1) {
			this.neighbors.add(nodes[i + 1][j + 1]);
	    }
	}

	
	//print the nodes from a list 
	public String getNodes(List<Node> arr){
		String neighborNodes = "";
		for(int x = 0; x < arr.size(); x++){
			neighborNodes += arr.get(x).i; 
			neighborNodes += ",";
			neighborNodes += arr.get(x).j;
			neighborNodes += "  ";

		}
		return neighborNodes;
	}
}
