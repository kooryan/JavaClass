package company.LambdaExpressions.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaChallenges {
    public static void main(String[] args) {
        // Challenge #1: Write an anonymous class as a lambda expression
     /*   Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for(String part : parts) {
                    System.out.println(part);
                }
            }
        };*/

        Runnable runnable = () -> { // empty parentheses for no arguments
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts) {
                System.out.println(part);
            }
        };
        // runnable.run();

        // Challenge #2: Write method as lambda expression
        Function<String, String> lambdaFunction = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // Challenge #3: Execute the function in challenge #2
        System.out.println(lambdaFunction.apply("1234567890"));

        // Challenge #4 Write a method that accepts a function
        everySecondCharacter(lambdaFunction, "1234567890");

        //
        Supplier<String> iLoveJava = () -> "I love Java";

        // 7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        /*  There are many interfaces in the Java SDK, and sometimes we can use a lambda expression
         instead of creating an instance that implements the interface we want to use. Given a specific instance,
         how can we tell whether we can map a lambda expression to it? What's the criteria that has to be met?

         The answer: the interface has to be a functional interface. It can have only a single method that MUST be implemented
         */

        // 9
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name ->
//                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);

        // 11

        topNames2015.stream() // did not need to create a new list using streams
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        long namesBeginningWithA = topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("There are this many names beginning with A: " + namesBeginningWithA);

        System.out.println("-------------------------------------");
        // 13 Debugging lambda streams
        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println) // though we have this, this chain will print nothing as we have no terminal operation
                .sorted(String::compareTo)
                .collect(Collectors.toList());


    }

    public static String everySecondCharacter(Function<String, String> func, String s) {
        return func.apply(s);
    }
}
