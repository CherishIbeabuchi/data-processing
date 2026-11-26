package com.pluralsight.loops;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // Create/ import a Scanner for User input
        Scanner myScan = new Scanner(System.in);

        //? Create a list of 10 Person objects
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

        //? Search their names
        System.out.println("Enter a first or last name to search: ");

        String searchName = myScan.nextLine();

        //* Create a list hold the people who match
        List<Person> matches = new ArrayList<>();

        //> Check for each person
        for (Person thePerson : people) {

            // Add the person to the matched list if their first name of last name
            // -> matches the search value
            if (thePerson.getFirstName().equalsIgnoreCase(searchName) ||
                    thePerson.getLastName().equalsIgnoreCase(searchName)) {
                matches.add(thePerson);
            }

        }
        // Display the search results
        System.out.println("The result matches: ");

        // Loop through and print each matching person's name
        for (Person thePerson : matches) {

            System.out.println(thePerson.getFirstName() + " " + thePerson.getLastName());
        }
        // Variables used to calculate
        int totalAge = 0;

        // Start oldest and youngest with the first person's age
        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        // loop through the list to calculate average, oldest age and youngest age
        for (Person thePerson : people) {

            // Add each age to the total
            totalAge += thePerson.getAge();

            //? Find the oldest age
            if (thePerson.getAge() > oldestAge) {
                oldestAge = thePerson.getAge();
            }
            //? Find the youngest age
            if (thePerson.getAge() < youngestAge) {
                youngestAge = thePerson.getAge();
            }
        }
        // CALCULATE the average age
        double average = (double) totalAge / people.size();

        // Display the results
        System.out.println("The Average Age is:" + average);

        System.out.println("The Oldest Age is: " + oldestAge);

        System.out.println("The youngest Age is: " + youngestAge);

        //Close the Scanner
        myScan.close();
    }
}




