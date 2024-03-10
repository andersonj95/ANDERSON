package proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class EliminarImpares {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("Lista original: " + numbers);

        List<Integer> noDuplicatesList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Lista sin elementos impares: " + noDuplicatesList);
    }
}
