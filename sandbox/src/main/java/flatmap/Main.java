package flatmap;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;


public class Main {
	
	public static void main(String[] args) {		
		Set<Team> teams = Sets.newHashSet(
				Team.of("1", "2", "3"),
				Team.of("A", "B", "C"),
				Team.of("a", "b", "c"));
		
		Set<Person> byReduce = teams.stream()
				.map   ( team -> team.listMember() )
				.reduce( Collections.emptySet(), (a, b) -> Sets.union(a, b) );
		
		Set<Person> byFlatMap = teams.stream()
				.flatMap( team -> team.listMember().stream() )
				.collect( Collectors.toSet() );
		
		System.out.println("byReduce.equals(byFlatMap): " + byReduce.equals(byFlatMap));
	}
}
