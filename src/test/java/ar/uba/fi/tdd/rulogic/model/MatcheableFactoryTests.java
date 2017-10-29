package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;
import ar.uba.fi.tdd.rulogic.*;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;

public class MatcheableFactoryTests {
	
	
	@Test
	public void fact_get_name() throws Exception{
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertEquals(creator.get_name("varon(juan)"), "varon");
	}
	
	@Test
	public void rule_get_name() throws Exception{
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertEquals(creator.get_name("hijo(X,Y):-varon(X),padre(Y, X)"), "hijo");
	}
	
	@Test
	public void fact_get_name_error() {
		try {
			MatcheableFactory creator = new MatcheableFactory();  
			String a = creator.get_name("varon)juan)");
            fail();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            Assert.assertThat(e.getMessage(), is("Invalid Fact or Rule: varon)juan)"));
        }
	}
	
	@Test
	public void fact_get_variables() throws Exception{
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertEquals(creator.get_variables("varon(juan)"), "juan");
	}
	
	@Test
	public void rule_get_variables() throws Exception{
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertEquals(creator.get_variables("hijo(X,Y):-varon(X),padre(Y, X)"), "X,Y");
	}
	
	@Test
	public void a_rule_is_a_fact() {
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertFalse(creator.is_a_fact("hijo(X,Y):-varon(X),padre(Y, X)"));
	}
	
	@Test
	public void a_fact_is_a_fact() {
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertTrue(creator.is_a_fact("varon(juan)"));
	}
	
	@Test
	public void get_facts_from_rule() throws Exception{
		MatcheableFactory creator = new MatcheableFactory();  
		Assert.assertEquals(creator.get_facts_string("hijo(X,Y):-varon(X),padre(Y,X)"), "varon(X),padre(Y,X)");
	}
	
	@Test
	public void create_a_fact() throws Exception {
		MatcheableFactory creator = new MatcheableFactory();  
		Matcheable fact = creator.create("hijo(pedro, pepe)");
		Assert.assertTrue(fact instanceof Fact);
	}
	
	@Test
	public void create_a_rule() throws Exception {
		MatcheableFactory creator = new MatcheableFactory();  
		Matcheable rule = creator.create("hijo(X, Y) :- varon(X), padre(Y, X)");
		Assert.assertTrue(rule instanceof Rule);
	}
}
