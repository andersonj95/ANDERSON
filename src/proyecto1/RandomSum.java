package proyecto1;
import java.util.Scanner;
import java.util.Random;
public class RandomSum {
    public static void main(String[] args) {
        int num1, num2, sum, userSum;
        boolean isCorrect = false;

        Random random = new Random();

        num1 = random.nextInt(10) + 1;
        num2 = random.nextInt(10) + 1;

        sum = num1 + num2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la suma de dos numeros aleatorios entre 1 y 10:");

        while (!isCorrect) {
            if (scanner.hasNextInt()) {
                userSum = scanner.nextInt();
                if (userSum == sum) {
                    System.out.println("felicidades la respuesta es correcta.");
                    isCorrect = true;
                } else {
                    System.out.println("Lo siento tu respuesta no es correcta. intenta otra ves:");
                }
            } else {
                System.out.println("el numero te ingresarte no es valido. por favor intente otra ves:");
                scanner.next();
            }
        }

        scanner.close();
    }
}
