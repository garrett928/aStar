package main;

public class Main {
	int rows = 10;
	int cols = 10;
	
	public static void main(String[] args){
		int rows = 10;
		int cols = 10;
		
		Cell[][] cells = new Cell[cols][rows];

		
		Window window = new Window();

		
		
		for(int i = 0; i < cols; i++){
			int count = 0;
			for(int j = 0; j < rows; j++){
				count ++;
				cells[i][j] = new Cell(i, j, window.mainPanel);
			}
		}
		window.show();
	}
	
}

