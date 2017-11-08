package ar.uba.fi.tdd.rulogic.model;
import ar.uba.fi.tdd.rulogic.Interpreter;


public class KnowledgeBase {
	
	Interpreter interpreter;
	
	public KnowledgeBase() throws Exception {
		this.interpreter = new Interpreter();
		this.interpreter.parse_db("src/main/resources/rules.db");
	}
	
	public boolean answer(String query) throws Exception {
		return this.interpreter.check_query(query);
	}

}
