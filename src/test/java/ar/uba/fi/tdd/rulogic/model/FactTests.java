package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import ar.uba.fi.tdd.rulogic.Fact;
import ar.uba.fi.tdd.rulogic.Interpreter;

public class FactTests {

	@Test
	public void facts_are_equal_test() throws Exception{
		Fact a = new Fact("padre", "juan");
		Fact b = new Fact("padre", "juan");
		Interpreter interpreter  = new Interpreter();
		Assert.assertTrue(a.match(b, interpreter));
	}
	@Test
	public void facts_are_equal_with_more_than_one_variable() throws Exception{
		Fact a = new Fact("padre", "juan,pepe");
		Fact b = new Fact("padre", "juan,pepe");
		Interpreter interpreter  = new Interpreter();
		Assert.assertTrue(a.match(b, interpreter));
	}
	@Test
	public void facts_with_diferent_name() throws Exception {
		Fact a = new Fact("padre", "juan");
		Fact b = new Fact("madre", "juan");
		Interpreter interpreter  = new Interpreter();
		Assert.assertFalse(a.match(b, interpreter));
	}
	@Test
	public void facts_with_diferent_variables() throws Exception{
		Fact a = new Fact("padre", "juan");
		Fact b = new Fact("padre", "pepe");
		Interpreter interpreter  = new Interpreter();
		Assert.assertFalse(a.match(b, interpreter));
	}
}
