package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.Matcheable;
import ar.uba.fi.tdd.rulogic.Fact;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatcheableFactory {
	
	public Matcheable create(String fact_rule_string) throws Exception{
		String fact_or_rule = fact_rule_string.replaceAll("[\\s\\.]", "");
		if (this.is_a_fact(fact_or_rule)) {
            return new Fact(this.get_name(fact_or_rule), this.get_variables(fact_or_rule));
        } else {
            return new Rule(
                this.get_name(fact_or_rule),
                this.get_variables(fact_or_rule),
                this.get_facts_string(fact_or_rule)
            );
        }
	}
	
	public String get_name(String fact_rule_string) throws Exception {
		Pattern r = Pattern.compile("([^\\(]*)\\(");
		Matcher m = r.matcher(fact_rule_string);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new Exception("Invalid Fact or Rule: " + fact_rule_string);
		}
	}
	
	public String get_variables(String fact_rule_string) throws Exception {
		Pattern r = Pattern.compile("\\(([^\\(]*)\\)");
		Matcher m = r.matcher(fact_rule_string);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new Exception("Invalid Fact or Rule: " + fact_rule_string);
		}
	}
	
	public String get_facts_string(String string_rule) throws Exception{
		Pattern r = Pattern.compile(":-(.*)");
		Matcher m = r.matcher(string_rule);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new Exception("Invalid Rule: " + string_rule);
		}
	}
	
	public Boolean is_a_fact(String fact_rule_string) {
		Pattern r = Pattern.compile(":-");
		Matcher m = r.matcher(fact_rule_string);
		if (m.find()) {
			return false;
		}
		return true;
	}
}
