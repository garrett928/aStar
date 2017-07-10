package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Window extends JFrame implements ActionListener  {
		int cols = Main.cols;
		int rows = Main.rows;
		JMenu mode = new JMenu();
		JMenuItem saveFile = new JMenuItem();
		JMenuBar myMenuBar = new JMenuBar();
		JPanel mainPanel = new JPanel();
		GridLayout grid = new GridLayout(cols, rows, 1, 1);
		
	public Window(){
		this.setSize(500, 500);
		this.setTitle("Path Finder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		
		this.setJMenuBar(this.myMenuBar);
		this.myMenuBar.setPreferredSize(new Dimension(myMenuBar.getPreferredSize().width, 30));
		
		this.myMenuBar.add(this.mode);
		this.mode.setText("Mode");
		this.mode.setPreferredSize(new Dimension(40, mode.getPreferredSize().height));
		this.mode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		float HSB[] = new float[3]; 
		Color.RGBtoHSB(0,120,73, HSB);
		this.myMenuBar.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		
		Color.RGBtoHSB(3,117,180, HSB);
		this.saveFile.setBackground(Color.getHSBColor(HSB[0], HSB[1], HSB[2]));
		this.saveFile.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(HSB[0], HSB[1], HSB[2])));
		this.saveFile.setText("Item");
		this.saveFile.addActionListener(this);
		this.mode.add(saveFile);
		
		this.mainPanel.setLayout(grid);
		this.mainPanel.setBackground(Color.black);
		this.add(mainPanel);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}