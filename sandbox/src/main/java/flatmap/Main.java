package flatmap;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;


public class Main {
	
	public static void main(String[] args) {		
		Set<Team> teams = Sets.newHashSet(
				Team.of("person1", "person2", "person3"),
				Team.of("personA", "personB", "personC"),
				Team.of("persona", "personb", "personc"));
		
		Set<Person> byReduce = teams.stream()
				.map   ( team -> team.listMember() )
				.reduce( Collections.emptySet(), (a, b) -> Sets.union(a, b) );
		
		Set<Person> byFlatMap = teams.stream()
				.flatMap( team -> team.listMember().stream() )
				.collect( Collectors.toSet() );
		
		System.out.println(
				"byReduce.equals(byFlatMap): " + byReduce.equals(byFlatMap) );
	}
}
