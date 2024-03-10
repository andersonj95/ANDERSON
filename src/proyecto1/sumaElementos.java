package proyecto1;
import java.util.Arrays;
import java.util.List;

public class sumaElementos {

        public static void main(String[] args) {
            List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9);

            int sum = nums.stream().mapToInt(Integer::intValue).sum();
            System.out.println("La suma es: " + sum);
        }
    }

