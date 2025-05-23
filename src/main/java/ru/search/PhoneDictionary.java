package ru.search;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> surnamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);
        var combine = namePredicate.or(phonePredicate.or(surnamePredicate.or(addressPredicate)));
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
