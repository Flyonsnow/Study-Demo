package com.wenxuezheng;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        class Customer {
            String name;
            int age;

            public Customer(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        List<Optional<Customer>> customers = Arrays.asList(
                Optional.of(new Customer("日拱一兵", 18)),
                Optional.of(new Customer("卑微的小开发", 22)),
                Optional.empty(),
                Optional.of(new Customer("OOT", 21)),
                Optional.empty(),
                Optional.of(new Customer("温柔一刀", 23)),
                Optional.empty()
        );
        int a = 5%2;
        int b = a%2;
        long numberOf65PlusCustomers = customers.stream().flatMap(c -> c.map(Stream::of)
                        .orElseGet(Stream::empty))
                .filter(c -> c.age > 18)
                .count();

        System.out.println(numberOf65PlusCustomers);
    }

}
