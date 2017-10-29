package ar.uba.fi.tdd.rulogic;


import ar.uba.fi.tdd.rulogic.Interpreter;

public class Fact extends Matcheable {

	public Fact(String name, String variables){
		super(name, variables);
	}
	public Boolean match_with_fact(Matcheable fact, Interpreter interpreter){
		if (this.name.equals(fact.get_name()) && this.variables.equals(fact.get_variables())) return true;
        return false;
	}
	
	
}
