import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class PeopleTest {
    public static void main(String[] args) {
        List<Person> people = null;

        try(BufferedReader reader = new BufferedReader(new FileReader("dataset.csv"))) {
            people = reader.lines()
                    .skip(1)
                    .map(str -> str.split(","))                                 //Теперь у нас Stream<String[]>
                    .map(data -> new Person(data[0], Integer.parseInt(data[1])))     //Теперь у нас Stream<Person>
                    .collect(Collectors.toList());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Средний возраст
//        int averageAge = people.stream()
//                .map(Person::getAge)         //Преобразуем всех людей в возраста (Person -> Integer)
//                .reduce(0, Integer::sum) / people.size();

        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();

        if(averageAge.isPresent()) {
            System.out.println(averageAge.getAsDouble());
        }
        else {
            System.out.println("Something went wrong :(((");
        }
    }
}
