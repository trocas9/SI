package supervisorfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author worten
 */
import java.util.Map;
import java.util.Scanner;
import org.jpl7.PrologException;
import org.jpl7.Query;
import org.jpl7.Term;



public class TestProlog {
    
        static final String WORKING_DIRECTORY;

    static {
        String tempSTR = System.getProperty("user.dir");
        WORKING_DIRECTORY = tempSTR.replace("\\", "/");
    }    
    
    public static void consultFile(String filename) {
        try {
            String ss = String.format("consult('%s/kbase/%s')", WORKING_DIRECTORY, filename);
            System.out.println("consult of " + filename + " " + (Query.hasSolution(ss) ? "succeeded" : "failed"));
        } catch (PrologException e) {
            System.out.println(e.getMessage());
        }
    }
    
        static public void runQuery(String query) {
        try {
            Map<String, Term>[] mapSolution = Query.allSolutions(query);            
            for (Map map : mapSolution) {
                map.keySet().forEach((variable) -> {
                    Object value = map.get(variable);
                    System.out.println("" + variable + "=" + value);
                });
            }
            System.out.print((mapSolution.length > 0 ? "yes" : "no"));
        } catch (PrologException e) {            System.out.println(e.getMessage());        }
    }
    
    static public void userInputPrologRoutine() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        while (!text.equalsIgnoreCase("stop")) {
            System.out.printf("\n\nGoal..: ");
            text = scan.nextLine();
            if (!text.equalsIgnoreCase("stop")) {
                runQuery(text);
            }
        }
        System.out.println(text);
    }
    
    static public void main(String[] args) {
           userInputPrologRoutine();
    }

    
    
}
    

