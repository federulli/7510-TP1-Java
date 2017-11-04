package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.Interpreter;


public class KnowledgeBase {
	
	Interpreter interpreter;
	
	public KnowledgeBase() {
		this.interpreter = new Interpreter();
	}
	
	public boolean answer(String query) throws Exception {
		return this.interpreter.check_query(query);
	}

}
