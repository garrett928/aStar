package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Window extends JFrame implements ActionListener  {
		int cols = Main.cols;
		int rows = Main.rows;
		JMenu aStar = new JMenu();
		JMenuItem refresh = new JMenuItem();
		JMenuItem	chooseStart = new JMenuItem();
		JMenuBar myMenuBar = new JMenuBar();
		JPanel mainPanel = new JPanel();
		GridLayout grid = new GridLayout(cols, rows, 1, 1);
		
	public Window(){
		this.setSize(600, 600);
		this.setTitle("Path Finder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		
		this.setJMenuBar(this.myMenuBar);
		this.myMenuBar.setPreferredSize(new Dimension(myMenuBar.getPreferredSize().width, 30));
		
		this.myMenuBar.add(this.aStar);
		this.aStar.setText("A*");
		this.aStar.setPreferredSize(new Dimension(40, aStar.getPreferredSize().height));
		this.aStar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		float HSB[] = new float[3]; 
		Color.RGBtoHSB(0,120,73, HSB);
		this.myMenuBar.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		
		Color.RGBtoHSB(3,117,180, HSB);
		this.refresh.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		this.refresh.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(HSB[0], HSB[1], HSB[2])));
		this.refresh.setText("Refresh");
		this.refresh.addActionListener(this);
		this.aStar.add(refresh);
		
		this.chooseStart.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		this.chooseStart.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(HSB[0], HSB[1], HSB[2])));
		this.chooseStart.setText("Choose Start");
		this.chooseStart.addActionListener(this);
		this.aStar.add(chooseStart);
		
		this.mainPanel.setLayout(grid);
		this.mainPanel.setBackground(Color.black);
		this.add(mainPanel);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource();
		 if(source == this.refresh){
			 Main.aStar.deInit();
			 Main.runAStar();
			 this.pack();
		 }
	}



}