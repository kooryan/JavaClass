package company.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B09",
                "G20", "G19", "G05", "G06", "g64",
                "J10", "J06");

        List<String> gNumbers = new ArrayList<>();

        bingoNumbers.stream() // the result of this call, is a stream that contains all the items in the list bingoNumbers in the same order that they occur in the list
                .map(String::toUpperCase) // calling the map method and we're passing in a another method. This map method accepts a FUNCTION
                // but this map method cannot take a method that accepts 2 arguments (a bifunction)
                .filter(s -> s.startsWith("G")) // filter the stream now, so the stream only contains bingo numbers that start with G
                .sorted() // the items are then sorted, based on the naturally ordering of the items in the stream
                .forEach(System.out::println); // important to note: this forEach method is not the same one we've used with the iterable interface
                                               // in this case we're using the forEach method from the stream class, it does what essentially the iterator one does

        // when we're calling the map method it's basically doing this:
        // String upperString = myString.toUpperCase() or toUpperCase(myString);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream); // the concat method is STATIC so we can't use it in a chain, but we can use its result as a source for another stream.
        System.out.println("———————————————————————————————————");
        System.out.println(concatStream.distinct()
                .peek(System.out::println)
                .count());

//        bingoNumbers.forEach((String bingoNum) -> {
//            if (bingoNum.startsWith("G")) {
//                gNumbers.add(bingoNum);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));
        Employee john = new Employee("John doe", 31);
        Employee ryan = new Employee("Ryan Koo", 45);
        Employee sno = new Employee("Sno Do", 23);
        Employee first = new Employee("Mark Gerg", 15);
        Employee ian = new Employee("Ian Mac", 40);
        Employee andrew = new Employee("Andrew Boe", 26);
        Employee dumb = new Employee("Bobby Banks", 17);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(ryan);
        hr.addEmployee(sno);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(first);
        accounting.addEmployee(ian);
        accounting.addEmployee(andrew);
        accounting.addEmployee(dumb);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream()) // flat map method wants a function that returns a stream and each department in the source stream becomes part of the argument
                .forEach(System.out::println);

        System.out.println("----------------------------");
  /*      List<String> sortedGNumbers = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList()); */

        List<String> sortedGNumbers = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // 1. Supplier 2. Accumulator 3. Combiner

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

         Map<Integer, List<Employee>> groupedByAge = departments.stream()
                 .flatMap(department -> department.getEmployeeList().stream())
                 .collect(Collectors.groupingBy(Employee::getAge));

        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println); // compares the ages of two employees and finds the younger employee

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s); // nothing is printed because we have no terminal operation
                    return s.length() == 3;
                }).count(); // since now we have a terminal operation, intermediate steps will now be processed
    }
}
