package proyecto1;
import java.util.Arrays;
public class VectormasGrande {

    public static void main(String[] args) {
        int[] arr = {12, 5, 20, 3, 18, 45, 2, 10, 15, 30, 55};
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("El elemento máximo en el vector es: " + max);
    }
}

