import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DPLL {
	
	String[] colors = {"r","g","b"};
	static HashSet<Integer> []connections = new HashSet[6];	 //for all the edges in the kb
	static ArrayList<HashSet> kb = new ArrayList(); //for the knowledge base
	static ArrayList<String> symbols = new ArrayList(); //for all the symbols
	static HashMap<String,Boolean> model = new HashMap();
	
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
		
		//Adding symbols
		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<colors.length;j++)
			{
				symbols.add(i+colors[j]);
			}
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
	    
	    for(String i: symbols)
	    {
	    	System.out.println(i);
	    }
	}
	
	public int evaluateKB(HashMap<String,Boolean> model)
	{
		
		int trueKB = 1;
		for(HashSet<String> i: kb)
		{
			boolean trueClause= false;
			boolean unDecidedLiterals =false;
			for(String literal : i)
			{					
				boolean truthValue = !literal.endsWith("!");
				if(!truthValue)
					literal = literal.substring(0, literal.length()-1);
				if(model.containsKey(literal))
				{
					if(model.get(literal) == truthValue) //literal has truthValue that makes it true, then the whole clause is true
							trueClause = true;
				}
				else
				{
					unDecidedLiterals = true;
				}			
			}
			if(!trueClause){
				if(!unDecidedLiterals)
					return 0;
				trueKB =0;
				
			}
		}	
		if(trueKB == 1)
			return 1;
		return 2;	
	}
	
	public boolean dpllSatisfiable(ArrayList<String> symbols,HashMap<String,Boolean> model){

	
	
	int result = evaluateKB(model);
	if(result == 1)
		return true;
	else 
	if(result == 0)
		return false;
	if(symbols.size()==0)
		return false;
	String sym=symbols.get(symbols.size()-1);
	ArrayList<String> newSymbols =(ArrayList<String>)symbols.clone(); //for all the symbols
	 
	newSymbols.remove(symbols.size()-1);
	
	HashMap<String,Boolean> newModelT = (HashMap<String,Boolean>)model.clone();
	newModelT.put(sym,true);
	boolean value1=dpllSatisfiable(newSymbols,newModelT);
	if(value1)
	{
		
		for(String s : newModelT.keySet())
			System.out.println(s+" : "+ newModelT.get(s));
		System.exit(0);
		return true;
	}
	
	HashMap<String,Boolean> newModelF = (HashMap<String,Boolean>)model.clone();
	newModelF.put(sym,false);
	boolean value2=dpllSatisfiable(newSymbols,newModelF);
	if(value2)
	{
		
		for(String s : newModelF.keySet())
		{
			if(newModelF.get(s))
			System.out.println(s+" : "+ newModelF.get(s));
		}
		System.exit(0);
		return true;
	}
	return false;
	
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
	//dpll.printList();
	dpll.dpllSatisfiable(symbols, model);
	}

}
