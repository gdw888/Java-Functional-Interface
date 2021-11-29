package com.gdw888.optionalapi;

public class OptioanalApiApp {

	public static void main(String[] args) {

		Person person = new Person("terry", "gdw88uw@gmail.com");

		if (!person.getEmailOptional().isPresent())
		{
			System.out.println("email is null");
		}

		person.getEmailOptional().map(String::toUpperCase)
								 .ifPresentOrElse(System.out::println,
										 		  ()->System.out.println("email is null"));;
		
	}
}
