package company.LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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



    }
}
