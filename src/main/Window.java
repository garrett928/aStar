package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Window extends JFrame implements ActionListener  {
		int cols = Main.cols;
		int rows = Main.rows;
		JMenu aStar = new JMenu();
		JMenu runMenu = new JMenu();
		JMenuItem runItem = new JMenuItem();
		JMenuItem randomize = new JMenuItem();
		JMenuItem	chooseStart = new JMenuItem();
		JMenuBar myMenuBar = new JMenuBar();
		JPanel mainPanel = new JPanel();
		GridLayout grid = new GridLayout(cols, rows, 1, 1);
		static int lastI = 0;
		static int lastJ = 0;
		
	public Window(){
		this.setSize(600, 600);
		this.setTitle("Path Finder");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		
		this.setJMenuBar(this.myMenuBar);
		this.myMenuBar.setPreferredSize(new Dimension(myMenuBar.getPreferredSize().width, 30));
		
		this.myMenuBar.add(this.aStar);
		this.aStar.setText("A*");
		this.aStar.setPreferredSize(new Dimension(40, aStar.getPreferredSize().height));
		this.aStar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
//		this.myMenuBar.add(this.runMenu);
//		this.runMenu.setText("Run");
//		this.runMenu.setPreferredSize(new Dimension(40, runMenu.getPreferredSize().height));
//		this.runMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		float HSB[] = new float[3]; 
		Color.RGBtoHSB(0,120,73, HSB);
		this.myMenuBar.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		
		Color.RGBtoHSB(3,117,180, HSB);
		this.randomize.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		this.randomize.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(HSB[0], HSB[1], HSB[2])));
		this.randomize.setText("randomize");
		this.randomize.addActionListener(this);
		this.aStar.add(randomize);
		
//		this.chooseStart.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
//		this.chooseStart.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(HSB[0], HSB[1], HSB[2])));
//		this.chooseStart.setText("Choose Start");
//		this.chooseStart.addActionListener(this);
//		this.aStar.add(chooseStart);
		
//		this.runItem.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
//		this.runItem.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(HSB[0], HSB[1], HSB[2])));
//		this.runItem.setText("Run");
//		this.runItem.addActionListener(this);
//		this.runMenu.add(runItem);
		
		this.mainPanel.setLayout(grid);
		this.mainPanel.setBackground(Color.black);
		this.add(mainPanel);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource();
		 if(source == this.randomize){
			 Main.aStar.deInit();
			 Main.aStar.start = null;
			 Main.aStar.end = null;
			 Main.runAStar();
			 this.pack();
		 }
		 
//		 
//		 if(source == this.runItem){
//			Main.aStar.deInit();
//			 Main.runAStar();
//			 this.pack();
//		 }
//		 if(source == this.chooseStart){
//			 Main.aStar.setStartNode(AStar.nodes[lastI][lastJ]);
//			 System.out.println(lastI + "," +  lastJ);
//		 }
	}



}