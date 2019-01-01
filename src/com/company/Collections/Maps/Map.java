package com.company.Collections.Maps;

import java.util.*;

public class map {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java was added");
        }

        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        System.out.println(languages.put("Python", "an interpreted, object-oriented, high level program with dynamic semantics"));
        System.out.println(languages.put("Algol", "an algorithmic language"));
        languages.put("Objective-C", " a general purpose, object-oriented language, used in developing IOS applications");
        // now each language/references have been stored, a key value and value pair into the map object

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "updated to level 11");
        }

   //     languages.put("Java", "updated to level 11"); // no error, key value is overwritten

        System.out.println("=================");

        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key)); // there is no specific order to note.
        }


    }
}
