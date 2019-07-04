package company.LambdaExpressions.Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class MainEmployee {
    public static void main(String[] args) {
        Employee john = new Employee("John doe", 31);
        Employee ryan = new Employee("Ryan Koo", 45);
        Employee sno = new Employee("Sno Do", 23);
        Employee first = new Employee("Mark Gerg", 15);
        Employee ian = new Employee("Ian Mac", 40);
        Employee andrew = new Employee("Andrew Boe", 26);
        Employee dumb = new Employee("Bobby Banks", 17);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(ryan);
        employees.add(sno);
        employees.add(first);
        employees.add(ian);
        employees.add(andrew);
        employees.add(dumb);

        employeesByAge(employees, "\nEmployees over thirty", employee -> employee.getAge() > 30);
        employeesByAge(employees, "\nEmployees thirty and under", employee ->  employee.getAge() <= 30);


        employeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() { // using anonymous class
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThanFifteen = i ->  i > 15;
        System.out.println(greaterThanFifteen.test(10));
        int a = 20;
        System.out.println(greaterThanFifteen.test(a+20));

        IntPredicate lessThanHundred = i -> i < 100;
        System.out.println(greaterThanFifteen.and(lessThanHundred).test(50));
  //      employees.forEach(employee -> System.out.println(employee.getName() + " " + employee.getAge()));
        // here our lambda doesn't return anything, so it matches what Consumer is expecting
        // On each iteration, it calls the "accept method" in the Consumer interface, passing the employee object as the parameter
        // The accept method now evaluates the lambda expression using the past employee object as the argument.
        // The employee object is consumed and the iterator moves onto the next employee object in the list

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        for (int i = 0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }


        employees.forEach(employee -> {
            int index = employee.getName().indexOf(" ");
            String lastName = index != -1 ? employee.getName().substring(index) : "No last name";
            System.out.println("Last name of employee: " + employee.getName() + ", " + lastName);
        });

        System.out.println("----------------------------");
        Function<Employee, String> getLastName = (Employee employee) ->
            employee.getName().substring(employee.getName().indexOf(" ") + 1);

      //  String lastName = getLastName.apply(employees.get(1));

        Function<Employee, String> getFirstName = (Employee employee) ->
                employee.getName().substring(0, employee.getName().indexOf(" "));

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }


        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incByFive = i -> i + 5;
        System.out.println(incByFive.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello world");


    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void employeesByAge(List<Employee> employees,
                                       String ageText,
                                       Predicate<Employee> ageCondition) { // using Predicate, which returns a boolean value
        System.out.println(ageText);
        System.out.println("--------------------------------");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) { // the for each passes each employee into the Predicate's test method
                System.out.println(employee.getName());
            }
        }
    }
}
