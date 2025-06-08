package skills.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

class Person {
    String name;
    int age;
    Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    static class Address {
        String city;
        String street;

        public Address(String city, String street) {
            this.city = city;
            this.street = street;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}

public class NestedObjectPriorityQueue {
    public static void main(String[] args) {
        // 自定义比较器：年龄（升序）> 城市（降序）> 街道（升序）
        PriorityQueue<Person> personQueue = new PriorityQueue<>(Comparator
                .comparingInt(Person::getAge)
                .thenComparing(p -> p.address.city, Comparator.reverseOrder())
                .thenComparing(p -> p.address.street)
        );
    }
}
