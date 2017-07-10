package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int cols = 70;
	static int rows = 70;
	static Window window = new Window();
	static AStar aStar = new AStar(window, window.mainPanel);
	static boolean refresh = true;
	static Node lastClickedNode = AStar.nodes[0][0];
	public static void runAStar(){
		//setup everything a* needs		
		aStar.init();
		//update window
		window.pack();
		
		//run loop that finds the path
		aStar.aStarLoop();
		
		window.pack();		
	}
	
	
	public static void deInit(){
		aStar.deInit();
	}
	
	//java main, used to call just methods 
	public static void main(String[] args) {
		//open window
		window.setVisible(true);
		runAStar();
	} 
}