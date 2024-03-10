package proyecto1;
import java.util.LinkedHashSet;
import java.util.List;
public class EliminarDuplicados {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 11, 11, 11, 11, 12);
        List<Integer> noDuplicatesList = new LinkedHashSet<>(list).stream().toList();
        System.out.println(noDuplicatesList);
    }
}
