package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import ar.uba.fi.tdd.rulogic.Interpreter;

public class InterpreterTests {
	
	@Test
	public void query_should_be_true1() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("varon(juan)"));
	}
	
	@Test
	public void query_should_be_true2() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("mujer(maria) ."));
	}
	
	@Test
	public void query_should_be_false1() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertFalse(interpreter.check_query("mujer(mario) ."));
	}
	
	@Test
	public void query_should_be_true3() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("hijo(pepe, juan)."));
	}
}
