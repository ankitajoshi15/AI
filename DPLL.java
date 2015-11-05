import java.util.ArrayList;
import java.util.HashSet;

public class DPLL {
	
	//static HashSet<Integer> []data = new HashSet[100];
	
	String[] colors = {"r","g","b"};
	static HashSet<Integer> []connections = new HashSet[6];	
	static ArrayList<HashSet> kb = new ArrayList();
	
	public void makeKB()
	{
		for(int i=0;i<connections.length;i++) //for each node
		{
			//int number = connections[i].size(); //for each node is the given node is connected to
			for(int j : connections[i])
			{
				for(int k=0;k<colors.length;k++)
				{
					HashSet clauses = new HashSet<String>();
					clauses.add(i+colors[k]+"!");					
					clauses.add(j+colors[k]+"!");					
					kb.add(clauses);							
				}		
			}	
		}
		
		for(int k=0;k<6;k++)
		{
			
			for(int i=0;i<colors.length;i++)
			{
				
				for(int j=i+1;j<colors.length;j++)
				{
					HashSet clauses = new HashSet<String>();
					clauses.add(k+colors[i]+"!");
					clauses.add(k+colors[j]+"!");
					kb.add(clauses);	
				}
				
			}
		}
		
		for(int i=0;i<6;i++)
		{
			HashSet clauses = new HashSet<String>();
			clauses.add(i+"r");
			clauses.add(i+"g");
			clauses.add(i+"b");
			kb.add(clauses);
		
		}
	}
	
	public void makeConnections()
	{
		connections[0] = new HashSet<Integer>();		
		connections[0].add(1);
		connections[0].add(3);
		connections[1] = new HashSet<Integer>();
		//connections[1].add(0);
		connections[1].add(3);
		connections[1].add(2);
		connections[2] = new HashSet<Integer>();
		//connections[2].add(1);
		connections[2].add(3);
		connections[2].add(4);
		connections[3] = new HashSet<Integer>();
		//connections[3].add(0);
		//connections[3].add(1);
		//connections[3].add(2);
		connections[3].add(4);
		connections[3].add(5);
		connections[4] = new HashSet<Integer>();
		//connections[4].add(2);
		//connections[4].add(3);
		connections[4].add(5);
		connections[5] = new HashSet<Integer>();
		//connections[5].add(3);
		//connections[5].add(4);
	
	}	
	
	public void printList(){
		
		System.out.println(kb.size());
		
	    for(HashSet i : kb){
	        
	    	System.out.println(i);
	    }
	}
	
	public void dpllSatisfiable(kb,symbols,model){
		
	result = evaluateKB(KB,model)
	if result == TRUE:
	return True
	elif result == FALSE:
	return False
	s=None
	for symbol in symbols:
	s = symbol
	break
	symbols.remove(s)
	newmodel = deepcopy(model)
	newmodel[s]=True
	ans1=DPLL(KB,symbols,newmodel)
	if ans1:
	print(newmodel)
	return True
	newmodel[s]=False
	ans1=DPLL(KB,symbols,newmodel)
	if ans1:
	print(newmodel)
	return True
	DPLL(KB,symbols,{})

	
	}
	
	public void findPureSymbol(){
		
	}
	
	public void findUnitClause(){
		
	}
	
	public void checkClausesTrue(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	DPLL dpll = new DPLL();
	
	dpll.makeConnections();
	dpll.makeKB();
	dpll.printList();
	
	}

}
