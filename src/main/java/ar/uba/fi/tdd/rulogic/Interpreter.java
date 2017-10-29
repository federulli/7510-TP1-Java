package ar.uba.fi.tdd.rulogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Interpreter {
	
	private List<Matcheable> db;
	private MatcheableFactory creator;
	
	public Interpreter() {
		this.creator = new MatcheableFactory();
		this.db = new ArrayList<Matcheable>();
	}
	
	public void parse_db(String db_path) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(db_path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       db.add(this.creator.create(line));
		    }
		}
	}
	
	public Boolean check_query(String query) throws Exception {
		Matcheable fact = this.creator.create(query);
		for (int i = 0; i < this.db.size(); i++) {
            if (fact.match(this.db.get(i), this))
                return true;
        }
        return false;
	}

}
