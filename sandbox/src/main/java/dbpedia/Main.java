package dbpedia;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.val;

import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class Main {

	private Main() {}
	
	private static final String LS = System.lineSeparator();
	private static final String ID = "   ";
	private static final String SERVICE_URL = "http://dbpedia.org/sparql";
	private static final Prefixes PREFIXES = Prefixes.create();
	
	@AllArgsConstructor
	@EqualsAndHashCode
	private static class Prefixes {
		private final Map<String,String> map;
		
		public static Prefixes create() {
			Map<String,String> map = new HashMap<>();
			
			map.put("rdf"        , "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
			map.put("rdfs"       , "http://www.w3.org/2000/01/rdf-schema#>");
			map.put("owl"        , "http://www.w3.org/2002/07/owl#");
			map.put("dbpedia-owl", "http://dbpedia.org/ontology/");
			map.put("dbpedia"    , "http://dbpedia.org/resource/");
			
			return new Prefixes( map );
		}
		
		@Override
		public String toString() {
			return map.keySet().stream()
					.map    ( prefix -> prefix + ": " + "<" + map.get(prefix) + ">")
					.collect( Collectors.joining(LS) );
		}
	}
	
	public static Model execQuery(String query) {
		return QueryExecutionFactory
				.sparqlService(SERVICE_URL, PREFIXES + query)
				.execConstruct();
	}
	
	public static void print(Model m) {
		StringBuilder sb = new StringBuilder();
		for ( StmtIterator it = m.listStatements(); it.hasNext(); ) {
			sb.append(it.nextStatement()).append(LS);
		}
		sb.append( "size = " + m.size() );
				
		System.out.println( sb.toString() );
	}
	
	public static Model listInstances(String clazz) {
		val query =
				"construct { ?x rdf:type " + clazz + " . }" + LS + 
				"where     { ?x rdf:type " + clazz + " . }";
		
		return execQuery(query);
	}
	
	public static String normalize(Object str) {
		val s = str.toString().trim();
		
		return s.startsWith("<") ? s : "<" + s + ">";
	}
	
	public static Model queryWith(Object subject) {
		val s = normalize( subject );
		val query =
				"construct { " + s + " ?p ?o . }" + LS +
				"where {" + LS +
				ID + s + " ?p ?o . " + LS +
				ID + "minus { " + s + " dbpedia-owl:wikiPageExternalLink ?o . }" + LS + 
				ID + "minus { " + s + " owl:sameAs ?o . }" + LS +
				ID + "filter( isURI(?o) )" + LS + 
				"}";
		
		return execQuery(query);
	}
	
	public static Model recursive(Object subject, int depth) {
		if ( depth < 0) {
			return ModelFactory.createDefaultModel();
		}

		System.out.println("depth = " + depth + ", " + subject);
		
		Model current = queryWith(subject);
		Model rest = ModelFactory.createDefaultModel();
		for ( NodeIterator it = current.listObjects(); it.hasNext(); ) {
			RDFNode object = it.next();

			rest.add( recursive(object, depth - 1) );
		}
		
		return ModelFactory.createUnion(current, rest);
	}
	
	public static void write(Model model) {
		val HOME = System.getProperty("user.home");
		val SEP = File.separator;

		String fileName = HOME + SEP + "small-dbpedia.ttl";
		FileWriter out = null;
		try {
			out = new FileWriter( fileName );
			model.write( out, "TTL" );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Model listAbout(String clazz, int depth) {
		Model instances = listInstances(clazz);
		Model descriptions = ModelFactory.createDefaultModel();

		for (ResIterator it = instances.listSubjects(); it.hasNext(); ) {
			Resource instance = it.next();
			descriptions.add( recursive(instance, depth) );
		}
		
		return ModelFactory.createUnion(instances, descriptions);
	}

	public static void main(String[] args) {
		//Model m = listAbout("<http://dbpedia.org/ontology/SpaceShuttle>", 2);
		//write( m );
		
		System.out.println( ">> end of process <<" );
	}
}
