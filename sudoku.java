import java.util.HashSet;
import java.util.LinkedList;

public class Sudoku{
	
	
	
	int grid[][] = new int[9][9];
	HashSet<Integer> []cell = new HashSet[81];
	
	
	//according to algorithm, we need a queue of all arcs in the CSP. So i am making a queue of arcs, which i will populate eventually.
	LinkedList<Arcs> queue = new LinkedList();
	
	public Sudoku(int grid[][]) {
	    this.grid = grid;
	}
	
	//represent every cell and its domain values in the form of a hashset
	//start with given grid	
	//assign empty cells with domain values : 1-9 values
	
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
	
	//populate the initial queue of arcs.
	public void initQueuePopulate(){
		
		//add all row neighboours in the queue
		
		for(int i=0;i<81;i++){
			for(int j=0;j<((i/9)+1)*9;j++){						
				
					Arcs arc = new Arcs(i, j);
					queue.add(arc);	
			}
		}
		
		//add all column neighbours in the queue
		for(int i=0;i<9;i++)
			for(int j=i+9;j<81;j=j+9){
				
				Arcs arc = new Arcs(i,j);	
				queue.add(arc);
			}
		
		//add all 3X3 neighbours in the queue
		
	}

	
	//ac3 comes into picture. 
	public void ac3(){
		
		
		
		
		//for each cell in the hashset, for 1 to 81 cells compare each with its neighbours, and 
		
	}
	
	public void revise(){
		
	}
	
	
	
	
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

		    Sudoku g = new Sudoku(grid);


		  //  g.check();

		   // g.printGrid();

	}
		
		
}
	
