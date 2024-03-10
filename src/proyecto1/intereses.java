package proyecto1;

import java.util.Scanner;

public class intereses {

    public static void main(String[] agrs){

        float capitalInicial, interesAnual, interesTotal, capitalFinal;
        int anios;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el Capital a Invertir: ");
        capitalInicial = teclado.nextFloat();
        System.out.print("Introduce el Interes Anual (%): ");
        interesAnual = teclado.nextFloat();
        System.out.print("Introduce el Numero de año a Invertir: ");
        anios = teclado.nextInt();
        interesTotal = capitalInicial + interesAnual / 100 * anios;
        capitalFinal = interesTotal + capitalInicial;
        System.out.println(" El Capital Final Sera: " + capitalFinal);
        System.out.println("El Interes Generado Sera: " + interesTotal);
    }

}
