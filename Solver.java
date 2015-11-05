import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Solver {
	
	static ArrayList<HashSet> kb = new ArrayList();
	static ArrayList<HashSet> clauses = new ArrayList();
	//static ArrayList<String> newClause = null;
	String[] colors = {"r","g","b"};
	static HashSet<Integer> []connections = new HashSet[6];	
	
	
	public void makeKB()
	{
		HashSet a = new HashSet();
		a.add("p!");
		a.add("a");
		a.add("c");
		
		kb.add(a);
		
		HashSet b = new HashSet();
		b.add("a!");
		kb.add(b);
		
		HashSet c = new HashSet();
		c.add("p");
		c.add("c!");
		kb.add(c);	
	
	}
	
	public HashSet makeClauses()
	{
		while(true)
		{
			HashSet<HashSet> nClause = new HashSet();
			HashSet<HashSet> answers = new HashSet();
			for(HashSet i : kb)
			{
				for(HashSet j : kb)
				{
					if(i!=j)
					{
						
						 answers = pl_resolve(i,j);
						 nClause.addAll(answers);
						 
					}
				}
			}	
			if(kb.containsAll(nClause))
			{
				return nClause;
			}
			else
				kb.addAll(nClause);
			
		}
	}
	    
	
	public HashSet<HashSet> pl_resolve(HashSet<String> ci, HashSet<String> cj)
	{
		HashSet<HashSet> something = new HashSet();
		String oliteral =null;
		for(String literal: ci){
			if(literal.endsWith("!"))
				 oliteral = literal.substring(0, literal.length()-1);
			else
				oliteral =literal+"!";
			if(cj.contains(oliteral))
			{
				HashSet<String> newClause  = new HashSet();
				newClause.addAll(ci);
				newClause.addAll(cj);
				newClause.remove(literal);
				newClause.remove(oliteral);
				something.add(newClause);
			}				
		}
		return something;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solver solve = new Solver();
	//	solve.makeConnections();
		solve.makeKB();
		HashSet<HashSet> answer = solve.makeClauses();
		for(HashSet i : answer){
		        
		    	System.out.println(i);
		    }
			//	solve.printList();
	}
	
	
	
	
	
	
	
	
	
	
	



}
