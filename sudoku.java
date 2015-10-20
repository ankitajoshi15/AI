import java.util.HashSet;

public class sudoku{
	
	
	
	int grid[][] = new int[9][9];
	HashSet<Integer> []cell = new HashSet[81];
	
	public sudoku(int grid[][]) {
	    this.grid = grid;
	}
	
	//represent every cell and its domain values in the form of a hashset
	
	public void assign(){
		
	 
	 int count =0;
	 for(int i =0;i<9;i++)
		 for(int j=0;j<9;j++)
		 {
			 if(grid[i][j]==0)
			 {
				 cell[count].add(1);
				 cell[count].add(2);
				 cell[count].add(3);
				 cell[count].add(4);
				 cell[count].add(5);
				 cell[count].add(6);
				 cell[count].add(7);
				 cell[count].add(8);
				 cell[count].add(9);
				 count++;
			 }		
			 else
			 {
				 cell[count].add(grid[i][j]);
				 count++;
			 }
				 
		 }
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
	
