public class sudoku{
	
	
	
	int grid[][] = new int[9][9];

	
	public sudoku(int grid[][]) {
	    this.grid = grid;
	}
	
	//start with given grid
	
	
	//assign empty cells with domain values : 1-9 values
	
	//ac3 comes into picture. 
	//here add all cells to revise queue. each cell will be checked against its neighbours. and its domain values will be pruned accordingly
	
	
	
	//backtracking shit. 
	
	
	
	public static void main(String[] args){
		
		
		
		    int grid[][] = {{0, 0, 3, 0, 2, 0, 6, 0, 0},
							{9, 0, 0, 3, 0, 5, 0, 0, 1},
							{0, 0, 1, 8, 0, 6, 4, 0, 0},
							{0, 0, 8, 1, 0, 2, 9, 0, 0},
							{7, 0, 0, 0, 0, 0, 0, 0, 8},
							{0, 0, 6, 7, 0, 8, 2, 0, 0},
							{0, 0, 2, 6, 0, 9, 5, 0, 0},
							{8, 0, 0, 2, 0, 3, 0, 0, 9},
							{0, 0, 5, 0, 1, 0, 3, 0, 0}};

		    sudoku g = new sudoku(grid);


		  //  g.check();

		   // g.printGrid();

	}
		
		
}
	
