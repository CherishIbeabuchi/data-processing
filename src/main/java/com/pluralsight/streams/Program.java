package com.pluralsight.streams;
import com.pluralsight.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        //! Import my scanner for user input
        Scanner myScan = new Scanner(System.in);

        //? Step 1 - Add at least 10 people
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("John", "Smith", 25),
                new Person("Sarah", "Johnson", 32),
                new Person("Michael", "Williams", 18),
                new Person("Emily", "Brown", 45),
                new Person("David", "Jones", 29),
                new Person("Jessica", "Garcia", 21),
                new Person("James", "Miller", 55),
                new Person("Ashley", "Davis", 37),
                new Person("Robert", "Wilson", 16),
                new Person("Amanda", "Taylor", 42)

        ));

        //?  Step 2 - Search their names
        System.out.println("Enter a first or last name to search: ");
        String searchName = myScan.nextLine();

        List<Person> matches = people.stream()
                .filter(person ->
                        person.getFirstName().equalsIgnoreCase(searchName)
                                || person.getLastName().equalsIgnoreCase(searchName))
                .collect(Collectors.toList());

        System.out.println("\nThe result matches:");

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {

        }matches.forEach(System.out::println);

        //* Step 2 -Find the Average age with streams
        double averageAge = people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum)
                / (double) people.size();

        //? Step 3 - Oldest age with streams
        int oldestAge = people.stream()
                .map(Person::getAge)
                .reduce(Integer.MIN_VALUE, Integer::max);

        //? Step 3 - Find the Youngest age with streams
        int youngestAge = people.stream()
                .map(Person::getAge)
                .reduce(Integer.MAX_VALUE, Integer::min);

        //! Display results
        System.out.printf("%nAverage Age: %.2f%n", averageAge);
        System.out.println("Oldest Age: " + oldestAge);
        System.out.println("Youngest Age: " + youngestAge);

        myScan.close();
    }
}