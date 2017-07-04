package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{

	int rows = new Main().rows;
	int cols = new Main().cols;
	
	int width = 600;
	int hieght = 600; 
	
	GridLayout grid = new GridLayout(rows, cols);
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu();
	JPanel mainPanel = new JPanel();
	JMenuItem menuItem = new JMenuItem();
	
	public Window(){
		this.setSize(new Dimension(width,hieght));
		setMenuBar();
		this.mainPanel.setBackground(Color.BLACK);
		this.mainPanel.setLayout(grid);
		this.add(mainPanel);
		this.setResizable(false);
	}
	
	
	private void setMenuBar(){
		this.setJMenuBar(menuBar);
		this.menu.setText("Menu");
		this.menuBar.add(menu);
		this.menuItem.setText("Item");
		this.menu.add(menuItem);	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
