package ar.uba.fi.tdd.rulogic;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Console application.
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ar.uba.fi.tdd.rulogic.*;
import ar.uba.fi.tdd.rulogic.MatcheableFactory;

public class App
{
	public static void main(String[] args){
		//System.out.println("I shall answer all your questions!");
		Interpreter interp = new Interpreter();
		try {
			interp.parse_db("src/main/resources/rules.db");
			System.out.println(interp.check_query("varon(juan)"));
		} catch (Exception e) {
			System.out.println("hola");
			System.out.println(e.getMessage());
		}
    }
}
