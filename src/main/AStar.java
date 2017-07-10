package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AStar {
	JFrame runWindow;
	JPanel runPanel;
	float HSB[] = new float[3]; 
	int cols = Main.cols;
	int rows = Main.rows;
	static Node[][] nodes= new Node[Main.cols][Main.rows];
	List<Node> openSet = new ArrayList<>();
	List<Node> closedSet = new ArrayList<>();
	List<Node> path = new ArrayList<>();
	List<Node> neighbors = new ArrayList<>();
	Node start = null;
	Node end = null;
	Node current = null;
	
	//set where A* runs when initiated 
	public AStar(JFrame frame, JPanel panel){
		this.runWindow = frame;
		this.runPanel = panel;
	}
	 
	 //setup A*
	 public void init(){
		 int cols = this.cols;
		 int rows = this.rows;
		 openSet.add(start);
		 
			//init nodes 
			for(int i=0; i < cols; i++){
				for(int j = 0; j < rows; j++){
					nodes[i][j] = new Node(runPanel, i, j); 
				}
			}
			//add neighbor nodes 
			for(int i=0; i < cols; i++){
				for(int j = 0; j < rows; j++){
					nodes[i][j].addNeighbors();
				}
			}
			
			//declare start and end after cells have been made
			start = nodes[0][0];
			end = nodes[cols - 1][rows - 1];
			//make start and end not walls 
			start.wall = false;
			end.wall = false;
			
			for(int i=0; i < cols; i++){
				for(int j = 0; j < rows; j++){
					nodes[i][j].makeWall(); 
				}
			}

	 }
	 
	 public double heuristic(Node a, Node b){
		 double dis;
		 if(b.i + 1 == a.i || b.i - 1 == a.i || b.j + 1 == a.j || b.j - 1 == a.j){
			 dis = 2;
		 }else{
			 dis = (2 * Math.sqrt(2));
		 }
		 return dis;
	 }
	 
	 
	//remove an element from any arrayList
		public void removeFromArray(List<Node> arr, Node elt) {
			  // Could use indexOf here instead to be more efficient
			  for (int i = arr.size() - 1; i >= 0; i--) {
			    if (arr.get(i) == elt) {
			    	 arr.remove(i);
			    }
			  }
			}
		
		public void aStarLoop(){
			while(true){
			  // Am I still searching?
			  if (openSet.size() > 0) {

			    // Best next option
			    int winner = 0;
			    for (int i = 0; i < openSet.size() - 1; i++) {
			      if (openSet.get(i).f < openSet.get(winner).f) {
			        winner = i;
			      }
			    }
			    System.out.println("1");
			    current = openSet.get(winner);

			    // Did I finish?
			    if (current == end) {
				    System.out.println("Goal reached");
			    	break;
			    }
			    System.out.println("2");

			    // Best option moves from openSet to closedSet
			    removeFromArray(openSet, current);
			    closedSet.add(current);

			    // Check all the neighbors
			    current.getNodes(current.neighbors);
			    neighbors = current.neighbors;
			    for (int i = 0; i < neighbors.size() - 1; i++) {
			      Node neighbor = neighbors.get(i);
				    System.out.println("3");

			      // Valid next spot?
			      if (!closedSet.contains(neighbor) && !neighbor.wall) {
			        double tempG = current.g + heuristic(neighbor, current);

			        // Is this a better path than before?
			        boolean newPath = false;
			        if (openSet.contains(neighbor)) {
			          if (tempG < neighbor.g) {
			            neighbor.g = tempG;
			            newPath = true;
			          }
					    System.out.println("4");

			        } else {
			          neighbor.g = tempG;
			          newPath = true;
			          openSet.add(neighbor);
			        }

			        // Yes, it's a better path
			        if (newPath) {
			          neighbor.h = heuristic(neighbor, end);
			          neighbor.f = neighbor.g + neighbor.h;
			          neighbor.previousNode = current;
			        }
			      }

			    }
			    System.out.println("5");

			  // Uh oh, no solution
			  } else {
			    System.out.print("No Solution");
			    break;
			  }

			  // Draw current state of everything
			  //draw nodes that have been decided "bad"
			  for (int i = 0; i < closedSet.size() -1 ; i++) {
					Color.RGBtoHSB(38,34,40, HSB);
					closedSet.get(i).setBackground(Color.RED);			 
			  }
			    System.out.println("6");

			  //draw nodes that can be explored
			  for (int i = 0; i < openSet.size() - 1; i++) {
				  Color.RGBtoHSB(0,120,73, HSB);
					openSet.get(i).setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));			
			  }
			  
			  }

		    System.out.println("7");

			  // Find the path by working backwards
			  List<Node> path = new ArrayList<>();
			  Node temp = current;
			  path.add(temp);
			  while (temp.previousNode != null) {
			    path.add(temp.previousNode);
			    temp = temp.previousNode;
			  }
			    System.out.println("8");

			  for(int i = 0; i < path.size() - 1; i++){
				  Color.RGBtoHSB(38,34,40, HSB);
				  path.get(i).setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));		
			  }
			  this.runWindow.pack();
			}
		}

