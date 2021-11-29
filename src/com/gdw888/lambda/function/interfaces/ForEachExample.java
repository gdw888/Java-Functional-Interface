package com.gdw888.lambda.function.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachExample {
	public static void main (String[] arg) {
		List<Person> people = Arrays.asList(
				new Person("Terry", "Lee", 12),
				new Person("Curry", "Stephen", 13),
				new Person("Lebron", "James", 14));
		people.forEach((p)->{System.out.println(p);});
		people.forEach((p)->System.out.println(p));
		people.forEach(p->System.out.println(p));
		people.forEach(System.out::println);
		
		Stream<Person> personStream = people.stream();
		Stream<String> firstNameStream = personStream.map(person -> person.getFirst());
		
		firstNameStream.forEach(System.out::println);
				
	}
}
