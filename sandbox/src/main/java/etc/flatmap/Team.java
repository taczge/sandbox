package etc.flatmap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Team {

	private final Set<Person> member;
	
	public static Team of(String...persons) {
		Set<Person> ps = Arrays.stream(persons)
				.map    ( s -> new Person(s) )
				.collect( Collectors.toSet() );
		
		return new Team( ps );
	}

	public Set<Person> listMember() {
		return member;
	}

}
