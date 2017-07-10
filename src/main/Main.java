package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int cols = 50;
	static int rows = 50;
	static Window window = new Window();
	static AStar aStar = new AStar(window, window.mainPanel);
	
	

	
	
	//java main, used to call just methods 
	public static void main(String[] args) {
		//open window
		window.setVisible(true);
		//setup everything a* needs
		aStar.init();
		
		//update window
		window.pack();
		
		//run loop that finds the path
		aStar.aStarLoop();
		
		//update window
		window.pack();
	}

} 