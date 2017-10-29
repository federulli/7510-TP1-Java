package ar.uba.fi.tdd.rulogic.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import ar.uba.fi.tdd.rulogic.Rule;

public class RuleTests {

	@Test
	public void zip_map_ok() throws Exception{
		Rule rule = new Rule("test", "test", "test");
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("X");
		a1.add("Y");
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("juan");
		a2.add("pepe");
		HashMap<String, String> map = rule.zip_map(a1, a2);
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Y", "pepe");
		map2.put("X", "juan");
		Assert.assertEquals(map.toString(), map2.toString());
	}
	
	@Test
	public void get_facts_list() throws Exception{
		Rule rule = new Rule("test", "test", "test");
		HashMap<String, String> variables = new HashMap<String, String>();
	    variables.put("X", "juan");
		variables.put("Y", "pepe");
		java.util.List<String> r = rule.get_facts_list("varon(X),padre(Y,X)", variables);
		Assert.assertEquals(r.get(0), "varon(juan)");
		Assert.assertEquals(r.get(1), "padre(pepe,juan)");
	}
}
