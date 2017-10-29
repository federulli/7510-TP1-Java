package ar.uba.fi.tdd.rulogic;


import ar.uba.fi.tdd.rulogic.Interpreter;

abstract public class Matcheable {
	
	protected String name;
	protected String variables;
	
	public String get_name(){return this.name;}
	public String get_variables(){return this.variables;}
	
	public Matcheable(String name, String variables){
		this.name = name;
		this.variables = variables;
	}
	public abstract Boolean match_with_fact(Matcheable fact, Interpreter interpreter) throws Exception;
	
	public Boolean match(Matcheable entity, Interpreter interpreter) throws Exception{
		return entity.match_with_fact(this, interpreter);
	}
}
