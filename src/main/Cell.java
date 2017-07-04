package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell extends JPanel{
	
	int rows = new Main().rows;
	int cols = new Main().cols;
	
	int width = 600/cols;
	int hieght = 600/rows;
	
	double f = 0;
	double g = 0;
	double h = 0;
	
	double rand = Math.random();
	
	int i;
	int j;
	
	boolean wall = false;
	
	Cell[] neighbors;
	Cell previous = null;
	
	public Cell(int i, int j, JPanel panel){
		this.i = i;
		this.j = j;
		this.setBackground(Color.YELLOW);
		this.setPreferredSize(new Dimension(width, hieght));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		JLabel label = new JLabel("C:" + i + "," + j);
		makeWall();
		panel.add("C:" + i + j, this);
	}
	
	public void makeWall(){
		if(rand < 0.4){
			this.wall = true;
			this.setBackground(Color.BLUE);
		}
	}

}
