package proyecto1;

import java.util.Scanner;

public class suma {

    public static void main(String[] args) {

        int num1,num2, resultado;

        Scanner objeto=new Scanner(System.in);
        System.out.println("Ingrese Primer Numero que Quieres sumar: ");
        num1=objeto.nextInt();

        System.out.println("Ingrese el Segundon Numero que Quieres sumar: ");
        num2=objeto.nextInt();
        resultado=num1+num2;

        System.out.println("El Resuldato de la Suma es: "+resultado);

    }
}
