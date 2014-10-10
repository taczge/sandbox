package etc.jena;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;

public class DBpediaAccess {
	
	public static void main(String[] args) {
		String service = "http://dbpedia.org/sparql";
		String query = "select * where { ?x ?y ?z . } limit 100";
		QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);
		
		for ( ResultSet s = qe.execSelect(); s.hasNext(); ) {
			System.out.println(s.next());
		}

		System.out.println(">> end of process <<");

	}
	
}
