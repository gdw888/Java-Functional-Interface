package com.gdw888.lambda.function.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
								new Person("Terry", "Lee", 34),
								new Person("Erin", "Park", 33),
								new Person("Sam", "Smith", 50),
								new Person("Taelim", "Lee", 50));
		
		Collections.sort(people, (p1,p2)->p2.getLast().compareTo(p1.getLast()));
		
		// Create a method that prints all elements in the list
		print1(people,(p)->true, p->System.out.println(p));
		
		
		System.out.println("=======");

		// Create a method that prints all people that have last name beginning with prefix
		String prefix ="L";
		print1(people,(p)->p.getLast().startsWith(prefix),p->System.out.println(p.getFirst()));
	}
	
	private static void print1(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : people) {
			if(predicate.test(person))
				consumer.accept(person);
		}
	}
	
	private static void print2(List<Person> people, PrintCondition printCondition) {
		for (Person person : people) {
			if(printCondition.test(person))
				System.out.println(person);
		}
	}
	
	private interface PrintCondition{
		public boolean test(Person p);
	}
}
