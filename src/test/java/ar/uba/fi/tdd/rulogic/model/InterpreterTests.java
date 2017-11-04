package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import ar.uba.fi.tdd.rulogic.Interpreter;

public class InterpreterTests {
	
	@Test
	public void varon_juan_true() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("varon (juan)."));
	}
	
	@Test
	public void varon_javier_false() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertFalse(interpreter.check_query("varon (javier)."));
	}
	
	
	@Test
	public void mujer_maria_true() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("mujer(maria) ."));
	}
	
	@Test
	public void mujer_mario_false() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertFalse(interpreter.check_query("mujer(mario) ."));
	}
	
	@Test
	public void hijo_pepe_juan_true() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("hijo(pepe, juan)."));
	}
	
	@Test
	public void hija_maria_roberto_false() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertFalse(interpreter.check_query("hija(maria, roberto)."));
	}
	
	@Test
	public void tio_nicolas_alejandro_roberto_true() throws Exception{
		Interpreter interpreter = new Interpreter();
		interpreter.parse_db("src/main/resources/rules.db");
		Assert.assertTrue(interpreter.check_query("tio(nicolas,alejandro, roberto)."));
	}
}
