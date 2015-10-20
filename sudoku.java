import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Sudoku{
	
	
	
	int grid[][] = new int[9][9];
	static HashSet<Integer> []cell = new HashSet[81];
	
	
	//according to algorithm, we need a queue of all arcs in the CSP. So i am making a queue of arcs, which i will populate eventually.
	LinkedList<Arcs> queue = new LinkedList();
	
	HashSet<Integer>[] neighbour = new HashSet[81];
	
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
				 cell[count] = new HashSet<Integer>();
				 cell[count].add(1);
				 cell[count].add(2);
				 cell[count].add(3);
				 cell[count].add(4);
				 cell[count].add(5);
				 cell[count].add(6);
				 cell[count].add(7);
				 cell[count].add(8);
				 cell[count].add(9);
			 }		
			 else
			 {
				 cell[count] = new HashSet<Integer>();
				 cell[count].add(grid[i][j]);
			 }
			 count++;
		 }
	}
	
	//populate the initial queue of arcs.
	public void initQueuePopulate(){
		
		//add all row neighbours in the queue
		
		for(int i=0;i<81;i++){
			neighbour[i] = new HashSet<Integer>();
			for(int j=i/9;j<(i/9)+9;j++){		
				if(i!=j){
					Arcs arc = new Arcs(i, j);
					queue.add(arc);	
					neighbour[i].add(j);
				}
			}
		}
		
		//add all column neighbours in the queue
		for(int i=0;i<9;i++)
			for(int j=i%9;j<81;j=j+9){
				if(i!=j){
					Arcs arc = new Arcs(i,j);
					neighbour[i].add(j);
				}

			}
		
		//add all 3X3 neighbours in the queue
		
		int[] set0 ={0,1,2,9,10,11,18,19,20};
		int[] set1 ={3,4,5,12,13,14,21,22,23};		
		int[] set2 ={6,7,8,15,16,17,24,25,26};
		int[] set3 ={27,28,29,36,37,38,45,46,47};
		int[] set4 ={30,31,32,39,40,41,48,49,50};
		int[] set5 ={33,34,35,42,43,44,51,52,53};
		int[] set6 ={54,55,56,63,64,65,72,73,74};
		int[] set7 ={57,58,59,66,67,68,75,76,77};
		int[] set8 ={60,61,62,69,70,71,78,79,80};
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{	
				if(i!=j)
				{
					Arcs arc = new Arcs(set0[i],set0[j]);
					queue.add(arc);
					neighbour[set0[i]].add(set0[j]);
					Arcs arc2 = new Arcs(set1[i],set1[j]);
					queue.add(arc2);
					neighbour[set1[i]].add(set1[j]);
					Arcs arc3 = new Arcs(set2[i],set2[j]);
					queue.add(arc3);
					neighbour[set2[i]].add(set2[j]);
					Arcs arc4 = new Arcs(set3[i],set3[j]);
					queue.add(arc4);
					neighbour[set3[i]].add(set3[j]);
					Arcs arc5 = new Arcs(set4[i],set4[j]);
					queue.add(arc5);
					neighbour[set4[i]].add(set4[j]);
					Arcs arc6 = new Arcs(set5[i],set5[j]);
					queue.add(arc6);
					neighbour[set5[i]].add(set5[j]);
					Arcs arc7 = new Arcs(set6[i],set6[j]);
					queue.add(arc7);
					neighbour[set6[i]].add(set6[j]);
					Arcs arc8 = new Arcs(set7[i],set7[j]);
					queue.add(arc8);
					neighbour[set7[i]].add(set7[j]);
					Arcs arc9 = new Arcs(set8[i],set8[j]);
					queue.add(arc9);
					neighbour[set8[i]].add(set8[j]);
				}
				
			}
		}
		
		
		
		
	}

	
	//ac3 comes into picture. 
	public boolean ac3(){
		
		while(!queue.isEmpty()){
			
			Arcs arc  = queue.remove();
			int xi = arc.node1;
			int xj = arc.node2;
			
			if(revise(arc)){
				if(cell[xi].size()==0)
					return false;
			System.out.println("Reached");
			//	HashSet<Integer> temp = (HashSet<Integer>) neighbour[xi].clone();
			//	temp.remove(xj);			
				
				for (Integer xk : neighbour[xi]) {
					if(!(neighbour[xj].contains(xk)))
					queue.add(new Arcs(xk,xi));
				}
			}
		}	
		return true;
	}
	
	

	public boolean revise(Arcs arc){
		boolean revised = false;
		boolean flag;
		int xi = arc.node1;
		int xj = arc.node2;
	
		
		//for(Integer x : cell[xi])
		//for (int i = 0; i < cell[xi].size(); i++)
		Iterator hsIterator = cell[xi].iterator();
		while(hsIterator.hasNext())
		{
			int x = (int)hsIterator.next();
			flag = false;
			for(Integer y : cell[xj])
			{
				if(!neighbour[x].contains(y))
				{
					flag = true;
					break;
				}
			}
			if(!flag) {
				hsIterator.remove();
				
				revised = true;
			}
		}
		return revised;
		
		
	}
		
	
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
		    g.assign();
		    g.initQueuePopulate();
		    if(g.ac3())
		    {
		    	for(HashSet h : cell){
		    		 Integer[] someArray = (Integer[])h.toArray();
		    		 System.out.println(someArray);	    			
		    		
		    	}
		    }
		    else {
		    	System.out.println("No Shit!");
		    }
		
	}
		
		
}
	
