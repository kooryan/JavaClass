package com.company.LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
//        new Thread(() -> {
//            System.out.println("Printing from the runnable");
//            System.out.println("Processing line 2");
//            System.out.println("Maybe on line 3");
//            System.out.printf("This is line %d\n", 4);
//        }).start();


        Employee john= new Employee("John doe", 30);
        Employee ryan = new Employee("Ryan Koo", 45);
        Employee sno = new Employee("Sno", 23);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(ryan);
        employees.add(sno);

//        Collections.sort(employees, new Comparator<Employee>() { // looking into the oracle docs, it shows that Comparator is a functional interface
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
// 3 Parts: Argument List (the two parameters employee1, employee2), Arrow Token, Body (the code that we're processing.
        // OR

        Collections.sort(employees, Comparator.comparing(Employee::getName));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
