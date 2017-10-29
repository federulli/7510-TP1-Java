package ar.uba.fi.tdd.rulogic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ar.uba.fi.tdd.rulogic.*;


public class Rule extends Matcheable{
	private String facts;
	
	public Rule(String name, String variables, String facts){
		super(name,variables);
		this.facts = facts;
	}
	
	public Boolean match_with_fact(Matcheable fact, Interpreter interpreter) throws Exception{
		if (!this.name.equals(fact.name)) return false;
		List<String> fact_variables = new ArrayList<String>(Arrays.asList(fact.get_variables().split(",")));
		List<String> this_variables = new ArrayList<String>(Arrays.asList(this.get_variables().split(",")));
        if (fact_variables.size() != this_variables.size()) return false;
        return this.are_all_facts_true(fact, interpreter);
	}
	
	public List<String> get_facts_list(String facts, HashMap<String, String> variables) {
		List<String> splited_facts = new ArrayList<String>(Arrays.asList(facts.split(",(?=[a-z])")));
		return this.replace_map(splited_facts, variables);
	}
	
	public Boolean are_all_facts_true(Matcheable fact, Interpreter interpreter) throws Exception {
		List<String> fact_variables = new ArrayList<String>(Arrays.asList(fact.get_variables().split(",")));
		List<String> this_variables = new ArrayList<String>(Arrays.asList(this.get_variables().split(",")));
		List<String> facts  = this.get_facts_list(this.facts, this.zip_map(this_variables, fact_variables));
		for (int i = 0; i < facts.size(); i++) {
            if (interpreter.check_query(facts.get(i)) != true){
                return false;
            }
        }
        return true;
	}
	
	public List<String> replace_map(List<String> list, HashMap<String, String> map) {
		ArrayList<String> replaced_list = new ArrayList<String>();
	    for(int i=0; i < list.size(); i++) {
            String string = list.get(i);
            Iterator<Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
            	Map.Entry<String, String> pair = (Entry<String, String>)it.next();
            	string = string.replaceAll(pair.getKey(), pair.getValue());
            }
            replaced_list.add(string);
        }
        return replaced_list;
	}
	
	public HashMap<String, String> zip_map (List<String> list1, List<String> list2){
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), list2.get(i));
        }
        return map;
	}
}
